package interpreter.virtualmachine.exceptions;

/**
 * Preserves the difference between stale references and never-allocated addresses,
 * which makes heap lifetime violations visible to the VM.
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
