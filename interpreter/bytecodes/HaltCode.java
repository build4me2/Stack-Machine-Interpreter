package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

import java.util.List;

/**
 * Requests termination through the VM so program shutdown stays inside the interpreter lifecycle.
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
