package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

import java.util.List;

/**
 * Bytecode stub for changing verbose execution state.
 */
public class VerboseCode implements ByteCode {

    private String state;

    @Override
    public void init(List<String> args) {
        state = args.get(0);
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
    }

    @Override
    public String toString() {
        return "VERBOSE " + state;
    }
}
