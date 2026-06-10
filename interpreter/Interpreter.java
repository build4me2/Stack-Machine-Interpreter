package interpreter;

import interpreter.loaders.ByteCodeLoader;
import interpreter.loaders.CodeTable;
import interpreter.loaders.exceptions.InvalidProgramException;
import interpreter.loaders.Program;
import interpreter.virtualmachine.VirtualMachine;
import interpreter.virtualmachine.exceptions.HeapBoundsException;
import interpreter.virtualmachine.exceptions.HeapOutOfMemoryException;
import interpreter.virtualmachine.exceptions.HeapUseAfterFreeException;
import interpreter.virtualmachine.exceptions.InvalidHeapAddressException;

/**
 * <pre>
 *     Interpreter class runs the interpreter:
 *     1. Perform all initializations
 *     2. Load the ByteCodes from file
 *     3. Run the virtual machine
 * 
 *     THIS FILE CANNOT BE MODIFIED.
 * 
 * </pre>
 */
public class Interpreter {

    private ByteCodeLoader byteCodeLoader;

    public Interpreter(String codeFile) {
        byteCodeLoader = new ByteCodeLoader(codeFile);
    }

        void run() {
        CodeTable.init();
        Program program = null;
        try{
            program = byteCodeLoader.loadCodes();
            program.resolveAddress();
            VirtualMachine virtualMachine = new VirtualMachine(program);
            virtualMachine.executeProgram();
        } catch(InvalidProgramException ex){
            System.out.println(ex);
            ex.printStackTrace();
            System.exit(-2);
        } catch (HeapOutOfMemoryException |
                 HeapBoundsException |
                 HeapUseAfterFreeException |
                 InvalidHeapAddressException ex)
        {
            System.out.println(ex);
            ex.printStackTrace();
            System.exit(-3);
        }
    }

    public static void main(String args[]) {

        if (args.length == 0) {
            System.out.println("***Incorrect usage, try: java interpreter.Interpreter <file>");
            System.exit(1);
        }
        (new Interpreter(args[0])).run();
    }
}
