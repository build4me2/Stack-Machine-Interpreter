package interpreter.virtualmachine;

import interpreter.bytecodes.ByteCode;
import interpreter.loaders.Program;
import interpreter.virtualmachine.exceptions.HeapBoundsException;
import interpreter.virtualmachine.exceptions.HeapOutOfMemoryException;
import interpreter.virtualmachine.exceptions.HeapUseAfterFreeException;
import interpreter.virtualmachine.exceptions.InvalidHeapAddressException;

import java.util.Stack;

/**
 * Owns execution state so ByteCodes can request operations without reaching into
 * runtime structures directly.
 */
public class VirtualMachine {

    private final RunTimeStack runTimeStack;
    private final Heap heap;
    private final Stack<Integer> returnAddress;
    private final Program program;
    private int programCounter;
    private boolean isRunning;
    private boolean isVerbose;

    public VirtualMachine(Program program) {
        this.program = program;
        this.runTimeStack = new RunTimeStack();
        this.heap = new Heap();
        this.returnAddress = new Stack<>();
        this.programCounter = 0;
        this.isVerbose = false;
    }

    public void executeProgram() {
        isRunning = true;

        while (isRunning) {
            ByteCode code = program.getCode(programCounter);
            boolean verboseBeforeExecution = isVerbose;

            code.execute(this);

            if (shouldDisplayVerbose(code, verboseBeforeExecution)) {
                System.out.println(code);
                System.out.println(runTimeStack.verboseDisplay());
            }

            programCounter++;
        }
    }

    public int pushRunStack(int value) {
        return runTimeStack.push(value);
    }

    public int popRunStack() {
        return runTimeStack.pop();
    }

    public int peekRunStack() {
        return runTimeStack.peek();
    }

    public int loadRunStack(int offset) {
        return runTimeStack.load(offset);
    }

    public int storeRunStack(int offset) {
        return runTimeStack.store(offset);
    }

    public void newFrameAt(int offsetFromTopOfRunStack) {
        runTimeStack.newFrameAt(offsetFromTopOfRunStack);
    }

    public void popFrame() {
        runTimeStack.popFrame();
    }

    public void setProgramCounter(int programCounter) {
        this.programCounter = programCounter;
    }

    public int getProgramCounter() {
        return programCounter;
    }

    public void halt() {
        isRunning = false;
    }

    public void pushReturnAddress(int address) {
        returnAddress.push(address);
    }

    public int popReturnAddress() {
        return returnAddress.pop();
    }

    public void setVerbose(boolean verbose) {
        isVerbose = verbose;
    }

    public String currentFrameValuesDisplay() {
        return runTimeStack.currentFrameValuesDisplay();
    }

    public int allocateHeap(int size) throws HeapOutOfMemoryException {
        return heap.allocate(size);
    }

    public int loadHeap(int address, int offset)
            throws InvalidHeapAddressException, HeapUseAfterFreeException, HeapBoundsException {
        return heap.load(address, offset);
    }

    public void storeHeap(int address, int offset, int value)
            throws InvalidHeapAddressException, HeapUseAfterFreeException, HeapBoundsException {
        heap.store(address, offset, value);
    }

    public void freeHeap(int address) throws InvalidHeapAddressException, HeapUseAfterFreeException {
        heap.free(address);
    }

    private boolean shouldDisplayVerbose(ByteCode code, boolean verboseBeforeExecution) {
        if (code.getClass().getSimpleName().equals("HaltCode")) {
            return false;
        }

        // The disabling instruction is still part of the trace that was active when it began.
        return isVerbose || verboseBeforeExecution;
    }
}
