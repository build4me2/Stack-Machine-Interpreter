package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

import java.util.List;

/**
 * Releases memory through the VM so double-free and use-after-free policy stays in the heap component.
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
