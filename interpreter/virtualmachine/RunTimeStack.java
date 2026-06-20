package interpreter.virtualmachine;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class RunTimeStack {

    private final ArrayList<Integer> runTimeStack;
    private final Stack<Integer> framePointer;

    public RunTimeStack() {
        runTimeStack = new ArrayList<>();
        framePointer = new Stack<>();
        // Main begins at frame zero, so every later frame can be represented as an offset from it.
        framePointer.add(0);
    }

    /**
     * Used for displaying the current state of the runTimeStack.
     * It will print portions of the stack based on respective
     * frame markers.
     * Example [1,2,3] [4,5,6] [7,8]
     * Frame pointers would be 0,3,6
     *
     * @return formatted runtime stack grouped by activation frame
     */
    public String verboseDisplay() {
        StringBuilder display = new StringBuilder();

        for (int frame = 0; frame < framePointer.size(); frame++) {
            if (frame > 0) {
                display.append(" ");
            }

            int frameStart = framePointer.get(frame);
            int frameEnd = frame + 1 < framePointer.size()
                    ? framePointer.get(frame + 1)
                    : runTimeStack.size();

            display.append(formatFrame(runTimeStack.subList(frameStart, frameEnd)));
        }

        return display.toString();
    }

    String currentFrameValuesDisplay() {
        int frameStart = framePointer.peek();
        StringBuilder display = new StringBuilder();

        for (int index = frameStart; index < runTimeStack.size(); index++) {
            if (index > frameStart) {
                display.append(",");
            }
            display.append(runTimeStack.get(index));
        }

        return display.toString();
    }

    /**
     * Returns the top of the runtime stack, but does not remove it.
     *
     * @return copy of the top of the stack
     */
    public int peek() {
        if (runTimeStack.isEmpty()) {
            throw new IllegalStateException("Cannot peek an empty runtime stack.");
        }

        return runTimeStack.get(runTimeStack.size() - 1);
    }

    /**
     * Pushes a value to the top of the runtime stack.
     *
     * @param i value to be pushed
     * @return value pushed
     */
    public int push(int i) {
        runTimeStack.add(i);
        return i;
    }

    /**
     * Removes the top value of the runtime stack.
     *
     * @return the value popped
     */
    public int pop() {
        if (runTimeStack.size() <= framePointer.peek()) {
            throw new IllegalStateException("Cannot pop past the current frame boundary.");
        }

        return runTimeStack.remove(runTimeStack.size() - 1);
    }

    /**
     * Takes the top item of the run time stack, and stores
     * it into an offset starting from the current frame.
     *
     * @param offsetInFrame number of slots above current frame marker
     * @return the item just stored
     */
    public int store(int offsetInFrame) {
        int offset = frameOffsetToStackIndex(offsetInFrame);
        int sizeAfterPop = runTimeStack.size() - 1;

        if (offset >= sizeAfterPop) {
            throw new IllegalArgumentException("Store offset cannot cross the current frame boundary.");
        }

        int value = pop();
        runTimeStack.set(offset, value);
        return value;
    }

    /**
     * Takes a value from the run time stack that is at offset
     * from the current frame marker and pushes it onto the top of
     * the stack.
     *
     * @param offsetInFrame number of slots above current frame marker
     * @return item just loaded into the offset
     */
    public int load(int offsetInFrame) {
        int offset = frameOffsetToStackIndex(offsetInFrame);

        if (offset >= runTimeStack.size()) {
            throw new IllegalArgumentException("Load offset cannot cross the current frame boundary.");
        }

        return push(runTimeStack.get(offset));
    }

    /**
     * Creates a new frame pointer at the index offset slots down
     * from the top of the runtime stack.
     *
     * @param offsetFromTopOfRunStack slots down from the top of the runtime stack
     */
    public void newFrameAt(int offsetFromTopOfRunStack) {
        if (offsetFromTopOfRunStack < 0 || offsetFromTopOfRunStack > runTimeStack.size()) {
            throw new IllegalArgumentException("Frame offset must describe values already on the runtime stack.");
        }

        framePointer.push(runTimeStack.size() - offsetFromTopOfRunStack);
    }

    /**
     * Pops the current frame off the runtime stack. Also removes
     * the frame pointer value from the FramePointer Stack.
     */
    public void popFrame() {
        if (framePointer.size() <= 1) {
            throw new IllegalStateException("Cannot remove the initial runtime frame.");
        }

        int returnValue = peek();
        int frameStart = framePointer.pop();

        // A returning function leaves only its result for the caller, not its local frame storage.
        while (runTimeStack.size() > frameStart) {
            runTimeStack.remove(runTimeStack.size() - 1);
        }

        push(returnValue);
    }

    private int frameOffsetToStackIndex(int offsetInFrame) {
        if (offsetInFrame < 0) {
            throw new IllegalArgumentException("Frame offset must be non-negative.");
        }

        return framePointer.peek() + offsetInFrame;
    }

    private String formatFrame(List<Integer> frameValues) {
        StringBuilder frame = new StringBuilder("[");

        for (int i = 0; i < frameValues.size(); i++) {
            if (i > 0) {
                frame.append(",");
            }
            frame.append(frameValues.get(i));
        }

        frame.append("]");
        return frame.toString();
    }
}
