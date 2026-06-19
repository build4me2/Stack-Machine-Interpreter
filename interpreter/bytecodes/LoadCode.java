package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

import java.util.List;

/**
 * Bytecode stub for copying a current-frame value to the stack top.
 */
public class LoadCode implements ByteCode {

    private int offset;
    private String id;

    @Override
    public void init(List<String> args) {
        offset = Integer.parseInt(args.get(0));
        if (args.size() > 1) {
            id = args.get(1);
        }
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
    }

    @Override
    public String toString() {
        if (id == null) {
            return "LOAD " + offset;
        }
        return "LOAD " + offset + " " + id;
    }
}
