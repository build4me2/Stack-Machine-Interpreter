package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

import java.util.List;

/**
 * Defines the next call frame before control transfers, keeping call setup separate from function entry.
 */
public class ArgsCode implements ByteCode {

    private int argCount;

    @Override
    public void init(List<String> args) {
        argCount = Integer.parseInt(args.get(0));
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        virtualMachine.newFrameAt(argCount);
    }

    @Override
    public String toString() {
        return "ARGS " + argCount;
    }
}
