package interpreter.virtualmachine.exceptions;

/**
 * Exception for when a heap address is invalid.
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
