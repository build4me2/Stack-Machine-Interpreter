package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

import java.util.List;

/**
 * Bytecode stub for allocating heap blocks.
 */
public class NewCode implements ByteCode {

    private int size;

    @Override
    public void init(List<String> args) {
        size = Integer.parseInt(args.get(0));
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
    }

    @Override
    public String toString() {
        return "NEW " + size;
    }
}
