package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

import java.util.List;

/**
 * Bytecode stub for binary operations.
 */
public class BopCode implements ByteCode {

    private String operator;

    @Override
    public void init(List<String> args) {
        operator = args.get(0);
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
    }

    @Override
    public String toString() {
        return "BOP " + operator;
    }
}
