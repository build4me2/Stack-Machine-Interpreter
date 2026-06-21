package interpreter.virtualmachine.exceptions;

/**
 * Distinguishes unknown heap references from live-block bounds errors and freed
 * references during VM heap operations.
 */
public class InvalidHeapAddressException extends RuntimeException {
    public InvalidHeapAddressException(Throwable ex) {
        super(ex);
    }

    public InvalidHeapAddressException(Throwable ex, String message) {
        super(message, ex);
    }

    public InvalidHeapAddressException(String message) {
        super(message);
    }
}
