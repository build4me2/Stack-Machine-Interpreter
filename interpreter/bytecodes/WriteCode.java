package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

import java.util.List;

/**
 * Keeps program output limited to stack values so tracing and program output remain separable.
 */
public class WriteCode implements ByteCode {

    @Override
    public void init(List<String> args) {
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        System.out.println(virtualMachine.peekRunStack());
    }

    @Override
    public String toString() {
        return "WRITE";
    }
}
