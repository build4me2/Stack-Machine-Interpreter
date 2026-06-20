package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

import java.util.List;

/**
 * Bytecode for releasing heap blocks.
 */
public class FreeCode implements ByteCode {

    @Override
    public void init(List<String> args) {
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        int address = virtualMachine.popRunStack();
        virtualMachine.freeHeap(address);
    }

    @Override
    public String toString() {
        return "FREE";
    }
}
