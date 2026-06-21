package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

import java.util.List;

/**
 * Requests allocation through the VM so heap ownership remains separate from instruction logic.
 */
public class NewCode implements ByteCode {

    private int size;

    @Override
    public void init(List<String> args) {
        size = Integer.parseInt(args.get(0));
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        int address = virtualMachine.allocateHeap(size);
        virtualMachine.pushRunStack(address);
    }

    @Override
    public String toString() {
        return "NEW " + size;
    }
}
