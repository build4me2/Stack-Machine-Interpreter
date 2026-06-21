package interpreter.virtualmachine.exceptions;

/**
 * Separates out-of-range heap indexes from invalid addresses so heap errors
 * identify which memory-safety rule was violated.
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
