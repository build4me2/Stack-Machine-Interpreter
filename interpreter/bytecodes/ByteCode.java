package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

import java.util.List;

/**
 * Keeps the VM execution loop independent of concrete instruction types, so new
 * bytecodes can be added without changing the controller.
 */
public interface ByteCode {

    /**
     * Parsing belongs to each instruction because argument meaning depends on the
     * concrete bytecode, not on the generic loader.
     */
    void init(List<String> args);

    /**
     * Runtime structures stay behind the VM boundary so instructions cannot break
     * stack, heap, or program-counter invariants.
     */
    void execute(VirtualMachine virtualMachine);

    /**
     * Verbose tracing needs a source-level instruction view without exposing VM state.
     */
    String toString();
}
