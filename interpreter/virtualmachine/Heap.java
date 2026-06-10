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
        return -1;
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
        return -1;
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

    }

    /**
     * Frees the allocated block at  address, making its slots available again.
     *
     * @param address the base address of the block to free
     * @throws InvalidHeapAddressException if  address was never allocated
     * @throws HeapUseAfterFreeException   if the block at  address has already been freed
     */
    void free(int address) throws InvalidHeapAddressException, HeapUseAfterFreeException {
       
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
       
    }
}
