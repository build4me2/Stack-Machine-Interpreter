package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

import java.util.List;

/**
 * Bytecode stub for stopping program execution.
 */
public class HaltCode implements ByteCode {

    @Override
    public void init(List<String> args) {
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        virtualMachine.halt();
    }

    @Override
    public String toString() {
        return "HALT";
    }
}
