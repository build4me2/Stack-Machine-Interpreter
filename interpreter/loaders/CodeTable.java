package interpreter.loaders;

/**
 * Code table of byte codes in language X.
 *
 * Maps a bytecode token to the class name that implements it.
 */
public final class CodeTable {

    private CodeTable() {
        // do nothing
    }

    /**
     * Fills code table with class name mappings.
     */
    public static void init() {

    }

    /**
     * Returns the ByteCode class name for a given token.
     *
     * @param token bytecode to map. For example, HALT --> HaltCode
     * @return class name of bytecode
     */
    public static String getClassName(String token) {
        return null;
    }

}
