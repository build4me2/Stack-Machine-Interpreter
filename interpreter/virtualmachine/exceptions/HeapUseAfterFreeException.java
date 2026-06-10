package interpreter.virtualmachine.exceptions;

/**
 * Exception for when a program accesses heap memory after it has been freed.
 */
public class HeapUseAfterFreeException extends RuntimeException {
    public HeapUseAfterFreeException(Throwable ex) {
        super(ex);
    }

    public HeapUseAfterFreeException(Throwable ex, String message) {
        super(message, ex);
    }

    public HeapUseAfterFreeException(String message) {
        super(message);
    }
}
