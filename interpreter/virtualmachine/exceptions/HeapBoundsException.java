package interpreter.virtualmachine.exceptions;

/**
 * Exception for when a heap access is outside the bounds of an allocated block.
 */
public class HeapBoundsException extends RuntimeException {
    public HeapBoundsException(Throwable ex) {
        super(ex);
    }

    public HeapBoundsException(Throwable ex, String message) {
        super(message, ex);
    }

    public HeapBoundsException(String message) {
        super(message);
    }
}
