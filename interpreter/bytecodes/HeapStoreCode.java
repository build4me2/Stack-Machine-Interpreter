package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

import java.util.List;

/**
 * Sends heap writes through the VM so address and bounds checks stay centralized.
 */
public class HeapStoreCode implements ByteCode {

    @Override
    public void init(List<String> args) {
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        int value = virtualMachine.popRunStack();
        int offset = virtualMachine.popRunStack();
        int address = virtualMachine.popRunStack();
        virtualMachine.storeHeap(address, offset, value);
    }

    @Override
    public String toString() {
        return "HSTORE";
    }
}
