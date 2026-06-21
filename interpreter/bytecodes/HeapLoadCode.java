package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

import java.util.List;

/**
 * Moves heap values through the VM stack path so heap validation remains centralized.
 */
public class HeapLoadCode implements ByteCode {

    @Override
    public void init(List<String> args) {
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        int offset = virtualMachine.popRunStack();
        int address = virtualMachine.popRunStack();
        int value = virtualMachine.loadHeap(address, offset);
        virtualMachine.pushRunStack(value);
    }

    @Override
    public String toString() {
        return "HLOAD";
    }
}
