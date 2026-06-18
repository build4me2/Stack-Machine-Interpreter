package interpreter.virtualmachine;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import interpreter.virtualmachine.exceptions.HeapBoundsException;
import interpreter.virtualmachine.exceptions.HeapOutOfMemoryException;
import interpreter.virtualmachine.exceptions.HeapUseAfterFreeException;
import interpreter.virtualmachine.exceptions.InvalidHeapAddressException;

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
        nextAddress = 1; // 0 is reserved as the null address
        usedSlots = 0;
    }

    /**
     * Allocates a contiguous block of size integer slots on the heap.
     *
     * @param size the number of integer slots to allocate
     * @return the base address of the newly allocated block
     * @throws HeapOutOfMemoryException if the allocation would exceed the maximum heap size
     */
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

    /**
     * Loads the integer value stored at address + offset on the heap.
     *
     * @param address the base address of the allocated block
     * @param offset  the index within the block to read from
     * @return the integer value at the specified location
     * @throws InvalidHeapAddressException if  address was never allocated
     * @throws HeapUseAfterFreeException   if the block at  address has been freed
     * @throws HeapBoundsException         if  offset is out of range for the block
     */
    int load(int address, int offset)
            throws InvalidHeapAddressException, HeapUseAfterFreeException, HeapBoundsException {
        checkAccess(address, offset);
        return allocations.get(address)[offset];
    }

    /**
     * Stores  value at  address + offset on the heap.
     *
     * @param address the base address of the allocated block
     * @param offset  the index within the block to write to
     * @param value   the integer value to store
     * @throws InvalidHeapAddressException if  address was never allocated
     * @throws HeapUseAfterFreeException   if the block at  address}has been freed
     * @throws HeapBoundsException         if  offset is out of range for the block
     */
    void store(int address, int offset, int value)
            throws InvalidHeapAddressException, HeapUseAfterFreeException, HeapBoundsException {
        checkAccess(address, offset);
        allocations.get(address)[offset] = value;
    }

    /**
     * Frees the allocated block at  address, making its slots available again.
     *
     * @param address the base address of the block to free
     * @throws InvalidHeapAddressException if  address was never allocated
     * @throws HeapUseAfterFreeException   if the block at  address has already been freed
     */
    void free(int address) throws InvalidHeapAddressException, HeapUseAfterFreeException {
        if (freed.contains(address)) {
            throw new HeapUseAfterFreeException("Heap block has already been freed: " + address);
        }

        int[] block = allocations.remove(address);
        if (block == null) {
            throw new InvalidHeapAddressException("Heap address was never allocated: " + address);
        }

        // Freed addresses remain recorded so later accesses can be distinguished from never-allocated addresses.
        freed.add(address);
        usedSlots -= block.length;
    }

    /**
     * Validates that  address refers to a live (non-freed) allocation and that
     *  offset falls within the bounds of that allocation.
     *
     * @param address the base address to validate
     * @param offset  the offset within the block to validate
     * @throws InvalidHeapAddressException if  address was never allocated
     * @throws HeapUseAfterFreeException   if the block at  address has been freed
     * @throws HeapBoundsException         if  offset is out of range for the block
     */
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
