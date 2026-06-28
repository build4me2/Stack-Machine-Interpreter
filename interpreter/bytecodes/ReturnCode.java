package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

import java.util.List;

/**
 * Restores caller control through VM-owned frame and return-address operations.
 */
public class ReturnCode implements ByteCode {

    private String label;
    private int returnValue;

    @Override
    public void init(List<String> args) {
        if (!args.isEmpty()) {
            label = args.get(0);
        }
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        returnValue = virtualMachine.peekRunStack();
        virtualMachine.popFrame();
        virtualMachine.setProgramCounter(virtualMachine.popReturnAddress());
    }

    @Override
    public String toString() {
        if (label == null) {
            return "RETURN";
        }
        return "RETURN " + label + "\tEXIT " + baseLabel() + ":" + returnValue;
    }

    private String baseLabel() {
        int generatedSuffix = label.indexOf("<<");
        if (generatedSuffix < 0) {
            return label;
        }
        return label.substring(0, generatedSuffix);
    }
}
