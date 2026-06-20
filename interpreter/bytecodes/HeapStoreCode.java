package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

import java.util.List;

/**
 * Bytecode for storing values into heap storage.
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
