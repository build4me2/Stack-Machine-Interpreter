package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

import java.util.List;

/**
 * Changes tracing through the VM so ByteCodes do not own or query global execution state.
 */
public class VerboseCode implements ByteCode {

    private String state;

    @Override
    public void init(List<String> args) {
        state = args.get(0);
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        virtualMachine.setVerbose("ON".equals(state));
    }

    @Override
    public String toString() {
        return "VERBOSE " + state;
    }
}
