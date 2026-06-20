package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

import java.util.List;
import java.util.Scanner;

/**
 * Bytecode for reading integer input.
 */
public class ReadCode implements ByteCode {

    private static final Scanner INPUT = new Scanner(System.in);

    @Override
    public void init(List<String> args) {
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        while (true) {
            System.out.print("Please enter an integer : ");
            if (INPUT.hasNextInt()) {
                virtualMachine.pushRunStack(INPUT.nextInt());
                INPUT.nextLine();
                return;
            }

            INPUT.nextLine();
            System.out.println("Invalid input. Please enter an integer.");
        }
    }

    @Override
    public String toString() {
        return "READ";
    }
}
