package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

import java.util.List;

/**
 * Bytecode stub for leaving a function body.
 */
public class ReturnCode implements ByteCode {

    private String label;

    @Override
    public void init(List<String> args) {
        if (!args.isEmpty()) {
            label = args.get(0);
        }
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
    }

    @Override
    public String toString() {
        if (label == null) {
            return "RETURN";
        }
        return "RETURN " + label;
    }
}
