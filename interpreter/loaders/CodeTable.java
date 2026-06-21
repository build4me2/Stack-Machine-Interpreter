package interpreter.loaders;

import java.util.HashMap;
import java.util.Map;

/**
 * Keeps source tokens decoupled from class names so the loader can construct
 * instructions without hard-coding every concrete bytecode decision.
 */
public final class CodeTable {

    private static final Map<String, String> byteCodeTable = new HashMap<>();

    private CodeTable() {
    }

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

    public static String getClassName(String token) {
        return byteCodeTable.get(token.trim());
    }

}
