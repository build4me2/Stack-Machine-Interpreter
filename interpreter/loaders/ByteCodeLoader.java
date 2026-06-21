package interpreter.loaders;

import interpreter.bytecodes.ByteCode;
import interpreter.loaders.exceptions.InvalidProgramException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Converts source-file lines into initialized ByteCode objects so parsing is
 * completed before the VM begins execution.
 */
public final class ByteCodeLoader {
    private static final String BYTECODE_PACKAGE = "interpreter.bytecodes.";

    private final String codSourceFileName;

    public ByteCodeLoader(String fileName) {
        this.codSourceFileName = fileName;
    }

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

        List<String> args = new ArrayList<>(Arrays.asList(tokens).subList(1, tokens.length));
        byteCode.init(args);
        return byteCode;
    }
}
