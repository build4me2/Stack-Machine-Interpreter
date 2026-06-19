package interpreter.loaders;

import java.util.HashMap;
import java.util.Map;

/**
 * Code table of byte codes in language X.
 *
 * Maps a bytecode token to the class name that implements it.
 */
public final class CodeTable {

    private static final Map<String, String> byteCodeTable = new HashMap<>();

    private CodeTable() {
        // do nothing
    }

    /**
     * Fills code table with class name mappings.
     */
    public static void init() {
        byteCodeTable.clear();

        byteCodeTable.put("HALT", "HaltCode");
        byteCodeTable.put("POP", "PopCode");
        byteCodeTable.put("FALSEBRANCH", "FalseBranchCode");
        byteCodeTable.put("GOTO", "GotoCode");
        byteCodeTable.put("STORE", "StoreCode");
        byteCodeTable.put("LOAD", "LoadCode");
        byteCodeTable.put("LIT", "LitCode");
        byteCodeTable.put("ARGS", "ArgsCode");
        byteCodeTable.put("CALL", "CallCode");
        byteCodeTable.put("RETURN", "ReturnCode");
        byteCodeTable.put("BOP", "BopCode");
        byteCodeTable.put("READ", "ReadCode");
        byteCodeTable.put("WRITE", "WriteCode");
        byteCodeTable.put("LABEL", "LabelCode");
        byteCodeTable.put("VERBOSE", "VerboseCode");
        byteCodeTable.put("NEW", "NewCode");
        byteCodeTable.put("HLOAD", "HeapLoadCode");
        byteCodeTable.put("HSTORE", "HeapStoreCode");
        byteCodeTable.put("FREE", "FreeCode");
    }

    /**
     * Returns the ByteCode class name for a given token.
     *
     * @param token bytecode to map. For example, HALT --> HaltCode
     * @return class name of bytecode
     */
    public static String getClassName(String token) {
        return byteCodeTable.get(token.trim());
    }

}
