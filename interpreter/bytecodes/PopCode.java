package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

import java.util.List;

/**
 * Uses VM stack operations so frame-boundary rules remain enforced by the runtime stack.
 */
public class PopCode implements ByteCode {

    private int count;

    @Override
    public void init(List<String> args) {
        count = Integer.parseInt(args.get(0));
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        for (int i = 0; i < count; i++) {
            try {
                virtualMachine.popRunStack();
            } catch (IllegalStateException ex) {
                break;
            }
        }
    }

    @Override
    public String toString() {
        return "POP " + count;
    }
}
