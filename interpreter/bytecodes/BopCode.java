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
        int rightOperand = virtualMachine.popRunStack();
        int leftOperand = virtualMachine.popRunStack();
        int result;

        switch (operator) {
            case "+" -> result = leftOperand + rightOperand;
            case "-" -> result = leftOperand - rightOperand;
            case "*" -> result = leftOperand * rightOperand;
            case "/" -> result = leftOperand / rightOperand;
            case "==" -> result = leftOperand == rightOperand ? 1 : 0;
            case "!=" -> result = leftOperand != rightOperand ? 1 : 0;
            case "<=" -> result = leftOperand <= rightOperand ? 1 : 0;
            case "<" -> result = leftOperand < rightOperand ? 1 : 0;
            case ">=" -> result = leftOperand >= rightOperand ? 1 : 0;
            case ">" -> result = leftOperand > rightOperand ? 1 : 0;
            case "&" -> result = leftOperand != 0 && rightOperand != 0 ? 1 : 0;
            case "|" -> result = leftOperand != 0 || rightOperand != 0 ? 1 : 0;
            default -> throw new IllegalArgumentException("Unsupported binary operator: " + operator);
        }

        virtualMachine.pushRunStack(result);
    }

    @Override
    public String toString() {
        return "BOP " + operator;
    }
}
