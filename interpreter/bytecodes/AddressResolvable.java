package interpreter.bytecodes;

/**
 * Marks bytecodes whose symbolic label must be converted to a program address
 * before execution begins.
 */
public interface AddressResolvable {

    /**
     * @return symbolic label read from the bytecode source file
     */
    String getLabel();

    /**
     * Stores the absolute program address resolved from the symbolic label.
     *
     * @param address index of the matching label bytecode in the loaded program
     */
    void setResolvedAddress(int address);
}
