package interpreter.loaders;

import interpreter.bytecodes.ByteCode;
import interpreter.loaders.exceptions.InvalidProgramException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class ByteCodeLoader {
    private static final String BYTECODE_PACKAGE = "interpreter.bytecodes.";

    private String codSourceFileName;

    /**
     * Constructs ByteCodeLoader object given a COD source code
     * file name
     *
     * @param fileName name of .cod File to load.
     */
    public ByteCodeLoader(String fileName) {
        this.codSourceFileName = fileName;
    }

    /**
     * Loads a program from a .cod file.
     *
     * @return a constructed Program Object.
     * @throws InvalidProgramException thrown when loadCodes fails.
     */
    public Program loadCodes() throws InvalidProgramException {
        Program program = new Program();

        try (BufferedReader reader = new BufferedReader(new FileReader(codSourceFileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) {
                    continue;
                }

                program.addCode(createByteCode(line));
            }
        } catch (Exception ex) {
            throw new InvalidProgramException(ex, "Unable to load bytecode program: " + codSourceFileName);
        }

        return program;
    }

    private ByteCode createByteCode(String sourceLine) throws ReflectiveOperationException {
        String[] tokens = sourceLine.split("\\s+");
        String className = CodeTable.getClassName(tokens[0]);

        if (className == null) {
            throw new ClassNotFoundException("No bytecode class mapping for token: " + tokens[0]);
        }

        Class<?> byteCodeClass = Class.forName(BYTECODE_PACKAGE + className);
        ByteCode byteCode = (ByteCode) byteCodeClass.getDeclaredConstructor().newInstance();

        // The loader stays generic by letting each concrete bytecode interpret its own arguments.
        List<String> args = new ArrayList<>(Arrays.asList(tokens).subList(1, tokens.length));
        byteCode.init(args);
        return byteCode;
    }
}
