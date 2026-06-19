package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

import java.util.List;

/**
 * Bytecode stub for marking symbolic program locations.
 */
public class LabelCode implements ByteCode {

    private String label;

    @Override
    public void init(List<String> args) {
        label = args.get(0);
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
    }

    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return "LABEL " + label;
    }
}
