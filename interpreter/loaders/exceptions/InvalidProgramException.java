package interpreter.loaders.exceptions;

/**
 * Gives loading failures one boundary type so Interpreter can handle invalid
 * programs without depending on file I/O or reflection details.
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
