package interpreter.bytecodes;

/**
 * Separates label resolution from execution so branch bytecodes do not need to
 * search the program while the VM is running.
 */
public interface AddressResolvable {

    String getLabel();

    void setResolvedAddress(int address);
}
