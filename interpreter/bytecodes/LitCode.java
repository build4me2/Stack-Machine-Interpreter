package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

import java.util.List;

/**
 * Bytecode stub for pushing literal values.
 */
public class LitCode implements ByteCode {

    private int value;
    private String id;

    @Override
    public void init(List<String> args) {
        value = Integer.parseInt(args.get(0));
        if (args.size() > 1) {
            id = args.get(1);
        }
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        virtualMachine.pushRunStack(value);
    }

    @Override
    public String toString() {
        if (id == null) {
            return "LIT " + value;
        }
        return "LIT " + value + " " + id + "\nint " + id;
    }
}
