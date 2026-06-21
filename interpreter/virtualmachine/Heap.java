package interpreter.virtualmachine;

import interpreter.virtualmachine.exceptions.HeapBoundsException;
import interpreter.virtualmachine.exceptions.HeapOutOfMemoryException;
import interpreter.virtualmachine.exceptions.HeapUseAfterFreeException;
import interpreter.virtualmachine.exceptions.InvalidHeapAddressException;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Isolates dynamic memory from call frames so heap references can outlive the
 * stack frame that produced them while still enforcing address safety.
 */
class Heap {

    private static final int BYTES_PER_MEGABYTE = 1024 * 1024;
    private static final int MAX_HEAP_SIZE_BYTES = 2 * BYTES_PER_MEGABYTE;
    private static final int MAX_HEAP_SLOTS = MAX_HEAP_SIZE_BYTES / Integer.BYTES;

    private final Map<Integer, int[]> allocations;
    private final Set<Integer> freed;
    private int nextAddress;
    private int usedSlots;


    public Heap() {
        allocations = new HashMap<>();
        freed = new HashSet<>();
        // Zero is left invalid so an uninitialized reference cannot look like a live allocation.
        nextAddress = 1;
        usedSlots = 0;
    }

    int allocate(int size) throws HeapOutOfMemoryException {
        if (size <= 0) {
            throw new IllegalArgumentException("Heap allocation size must be positive.");
        }

        if (size > MAX_HEAP_SLOTS - usedSlots) {
            throw new HeapOutOfMemoryException("Heap allocation would exceed the maximum heap size.");
        }

        int address = nextAddress++;
        allocations.put(address, new int[size]);
        usedSlots += size;
        return address;
    }

    int load(int address, int offset)
            throws InvalidHeapAddressException, HeapUseAfterFreeException, HeapBoundsException {
        checkAccess(address, offset);
        return allocations.get(address)[offset];
    }

    void store(int address, int offset, int value)
            throws InvalidHeapAddressException, HeapUseAfterFreeException, HeapBoundsException {
        checkAccess(address, offset);
        allocations.get(address)[offset] = value;
    }

    void free(int address) throws InvalidHeapAddressException, HeapUseAfterFreeException {
        if (freed.contains(address)) {
            throw new HeapUseAfterFreeException("Heap block has already been freed: " + address);
        }

        int[] block = allocations.remove(address);
        if (block == null) {
            throw new InvalidHeapAddressException("Heap address was never allocated: " + address);
        }

        // Freed addresses stay recorded so a stale reference is not mistaken for a never-used address.
        freed.add(address);
        usedSlots -= block.length;
    }

    private void checkAccess(int address, int offset) throws InvalidHeapAddressException, HeapUseAfterFreeException, HeapBoundsException {
        if (freed.contains(address)) {
            throw new HeapUseAfterFreeException("Heap block has already been freed: " + address);
        }

        int[] block = allocations.get(address);
        if (block == null) {
            throw new InvalidHeapAddressException("Heap address was never allocated: " + address);
        }

        int blockSize = block.length;
        if (offset < 0 || offset >= blockSize) {
            throw new HeapBoundsException("Heap offset is outside the allocated block: " + offset);
        }
    }
}
