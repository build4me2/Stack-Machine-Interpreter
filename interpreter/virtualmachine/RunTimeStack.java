package interpreter.virtualmachine;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Keeps values and frame boundaries together so function calls can reuse one
 * stack while still protecting each activation record.
 */
class RunTimeStack {

    private final ArrayList<Integer> runTimeStack;
    private final Stack<Integer> framePointer;

    public RunTimeStack() {
        runTimeStack = new ArrayList<>();
        framePointer = new Stack<>();
        // Main has no caller, so its frame boundary anchors all later relative offsets.
        framePointer.add(0);
    }

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

    public int peek() {
        if (runTimeStack.isEmpty()) {
            throw new IllegalStateException("Cannot peek an empty runtime stack.");
        }

        return runTimeStack.get(runTimeStack.size() - 1);
    }

    public int push(int i) {
        runTimeStack.add(i);
        return i;
    }

    public int pop() {
        if (runTimeStack.size() <= framePointer.peek()) {
            throw new IllegalStateException("Cannot pop past the current frame boundary.");
        }

        return runTimeStack.remove(runTimeStack.size() - 1);
    }

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

    public int load(int offsetInFrame) {
        int offset = frameOffsetToStackIndex(offsetInFrame);

        if (offset >= runTimeStack.size()) {
            throw new IllegalArgumentException("Load offset cannot cross the current frame boundary.");
        }

        return push(runTimeStack.get(offset));
    }

    public void newFrameAt(int offsetFromTopOfRunStack) {
        if (offsetFromTopOfRunStack < 0 || offsetFromTopOfRunStack > runTimeStack.size()) {
            throw new IllegalArgumentException("Frame offset must describe values already on the runtime stack.");
        }

        framePointer.push(runTimeStack.size() - offsetFromTopOfRunStack);
    }

    public void popFrame() {
        if (framePointer.size() <= 1) {
            throw new IllegalStateException("Cannot remove the initial runtime frame.");
        }

        int returnValue = peek();
        int frameStart = framePointer.pop();

        // Only the return value crosses back to the caller; local frame storage must disappear.
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
