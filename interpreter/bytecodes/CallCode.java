package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

import java.util.List;

/**
 * Bytecode for entering a function body.
 */
public class CallCode implements ByteCode, AddressResolvable {

    private String label;
    private int resolvedAddress;
    private String arguments;

    @Override
    public void init(List<String> args) {
        label = args.get(0);
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        arguments = virtualMachine.currentFrameValuesDisplay();
        virtualMachine.pushReturnAddress(virtualMachine.getProgramCounter());
        virtualMachine.setProgramCounter(resolvedAddress);
    }

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public void setResolvedAddress(int address) {
        resolvedAddress = address;
    }

    @Override
    public String toString() {
        return "CALL " + label + " " + baseLabel() + "(" + arguments + ")";
    }

    private String baseLabel() {
        int generatedSuffix = label.indexOf("<<");
        if (generatedSuffix < 0) {
            return label;
        }
        return label.substring(0, generatedSuffix);
    }
}
