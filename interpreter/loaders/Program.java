package interpreter.loaders;

import interpreter.bytecodes.AddressResolvable;
import interpreter.bytecodes.ByteCode;
import interpreter.bytecodes.LabelCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Program {

    private final List<ByteCode> program;

    /**
     * Instantiates a program object using an
     * ArrayList
     */
    public Program() {
        program = new ArrayList<>();
    }

    /**
     * Gets the size of the current program.
     *
     * @return size of program
     */
    public int getSize() {
        return program.size();
    }

    /**
     * Grabs an instance of a bytecode at an index.
     *
     * @param programCounter index of bytecode to get.
     * @return a bytecode.
     */
    public ByteCode getCode(int programCounter) {
        return program.get(programCounter);
    }

    /**
     * Adds a bytecode instance to the Program List.
     *
     * @param c bytecode to be added
     */
    public void addCode(ByteCode c) {
        program.add(c);
    }

    /**
     * Makes multiple passes through the program ArrayList
     * resolving addresses for the Goto, Call, and FalseBranch
     * bytecodes. These bytecodes can only jump to Label
     * codes that have a matching label value.
     * HINT: make note of what type of data-structure
     * ByteCodes are stored in.
     * **** METHOD SIGNATURE CANNOT BE CHANGED *****
     */
    public void resolveAddress() {
        Map<String, Integer> labelAddresses = new HashMap<>();

        for (int address = 0; address < program.size(); address++) {
            ByteCode code = program.get(address);
            if (code instanceof LabelCode labelCode) {
                labelAddresses.put(labelCode.getLabel(), address);
            }
        }

        for (ByteCode code : program) {
            if (code instanceof AddressResolvable addressResolvable) {
                Integer resolvedAddress = labelAddresses.get(addressResolvable.getLabel());
                if (resolvedAddress == null) {
                    throw new IllegalStateException("No matching label for: " + addressResolvable.getLabel());
                }

                // Resolution is kept in the loaded program so source bytecode files remain unchanged.
                addressResolvable.setResolvedAddress(resolvedAddress);
            }
        }
    }
}
