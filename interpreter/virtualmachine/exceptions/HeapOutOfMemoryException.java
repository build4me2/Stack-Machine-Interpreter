package interpreter.virtualmachine.exceptions;

/**
 * Keeps heap-capacity failures distinct from access failures so allocation code
 * can report that no valid address was produced.
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
