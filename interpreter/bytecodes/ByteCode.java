package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

import java.util.List;

/**
 * Common contract for every executable bytecode in the interpreter.
 */
public interface ByteCode {

    /**
     * Initialization is separated from construction because the loader creates bytecodes
     * dynamically before delegating argument interpretation to each concrete bytecode.
     *
     * @param args source tokens that follow the bytecode name
     */
    void init(List<String> args);

    /**
     * Bytecodes operate through the virtual machine so runtime structures remain owned
     * by the component responsible for program execution.
     *
     * @param virtualMachine executing virtual machine
     */
    void execute(VirtualMachine virtualMachine);

    /**
     * Provides the source-level representation used by the virtual machine when verbose
     * execution is enabled.
     *
     * @return bytecode display text
     */
    String toString();
}
