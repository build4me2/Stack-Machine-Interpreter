package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

import java.util.List;

/**
 * Bytecode stub for unconditional control-flow jumps.
 */
public class GotoCode implements ByteCode, AddressResolvable {

    private String label;
    private int resolvedAddress;

    @Override
    public void init(List<String> args) {
        label = args.get(0);
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
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
        return "GOTO " + label;
    }
}
