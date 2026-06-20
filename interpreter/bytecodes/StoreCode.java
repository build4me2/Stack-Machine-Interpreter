package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

import java.util.List;

/**
 * Bytecode for storing the top runtime value in the current frame.
 */
public class StoreCode implements ByteCode {

    private int offset;
    private String id;
    private int storedValue;

    @Override
    public void init(List<String> args) {
        offset = Integer.parseInt(args.get(0));
        if (args.size() > 1) {
            id = args.get(1);
        }
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        storedValue = virtualMachine.storeRunStack(offset);
    }

    @Override
    public String toString() {
        if (id == null) {
            return "STORE " + offset;
        }
        return "STORE " + offset + " " + id + "\n" + id + "=" + storedValue;
    }
}
