package interpreter.virtualmachine.exceptions;

/**
 * Exception for when heap allocation fails because the heap is full.
 */
public class HeapOutOfMemoryException extends RuntimeException {
    public HeapOutOfMemoryException(Throwable ex) {
        super(ex);
    }

    public HeapOutOfMemoryException(Throwable ex, String message) {
        super(message, ex);
    }

    public HeapOutOfMemoryException(String message) {
        super(message);
    }
}
