package interpreter.loaders;

import interpreter.bytecodes.AddressResolvable;
import interpreter.bytecodes.ByteCode;
import interpreter.bytecodes.LabelCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Owns the loaded instruction sequence so parsing, address resolution, and VM
 * execution do not share mutable source-file state.
 */
public class Program {

    private final List<ByteCode> program;

    public Program() {
        program = new ArrayList<>();
    }

    public int getSize() {
        return program.size();
    }

    public ByteCode getCode(int programCounter) {
        return program.get(programCounter);
    }

    public void addCode(ByteCode c) {
        program.add(c);
    }

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

                // Branch targets are cached before execution so jumps stay independent of source text.
                addressResolvable.setResolvedAddress(resolvedAddress);
            }
        }
    }
}
