package interpreter.loaders.exceptions;

/**
 * Exception for when loadCode fails.
 * This exception is used to bubble up all
 * exceptions that can be thrown by loadCodes.
 * 
 * DO NOT ADD ANY ADDITIONAL Constructors.
 */
public class InvalidProgramException extends RuntimeException {
    public InvalidProgramException(Throwable ex) {
        super(ex);
    }

    public InvalidProgramException(Throwable ex, String message) {
        super(message, ex);
    }

    public InvalidProgramException(String message) {
        super(message);
    }
}
