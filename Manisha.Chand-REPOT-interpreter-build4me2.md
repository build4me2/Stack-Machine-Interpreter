

# Grading Report for P1



## Student Name: 

Manisha.Chand


## Commit Count: 

16



## Git Diff Since Base Commit 


<details>
    <summary>Git Diff</summary>

~~~bash
diff --git a/README.md b/README.md
index 2b9a292..73b3b57 100644
--- a/README.md
+++ b/README.md
@@ -1,7 +1,40 @@
 # CSC 413 - Project Two - The Interpreter
 
-## Student Name  : Name here
+## Student Name  : Manisha Chand 
 
-## Student ID    : ID here
+## Student ID    : 924844476
 
-## Student Email : Email here
+## Student Email : mchand@sfsu.edu
+
+
+## About
+
+A stack-based virtual machine that runs compiled bytecode (`.x.cod` files) for the
+mock language X. It loads the bytecode, resolves jump labels to instruction addresses,
+and executes the program through a virtual machine that owns the runtime
+stack and heap. Supports recursion, dynamic heap memory, and a VERBOSE trace mode.
+
+## Development Environment
+
+- Java: OpenJDK 24 (Temurin); require
+- IDE: IntelliJ IDEA
+- OS: Linux
+- Version Control: Git / GitHub
+
+## Build (from the repository root)
+
+    mkdir -p build
+    find interpreter -name "*.java" >
+    javac -d build @sources.txt
+
+## Run
+
+    java -cp build interpreter.Interpreter factorial.x.cod
+
+Replace `factorial.x.cod` with any provided program (`fib.x.cod heapSumArray.x.cod,
+heapPrintArray.x.cod). Programs that use READ will prompt for integer input. To see the
+VERBOSE trace, the .cod file needs a VERBOSE ON line.
+
+## Documentation
+
+Full project documentation (PDF) is in the documentation folder.
diff --git a/documentation/chand_manisha.pdf b/documentation/chand_manisha.pdf
new file mode 100644
index 0000000..f3e908a
Binary files /dev/null and b/documentation/chand_manisha.pdf differ
diff --git a/factorial.verbose.cod b/factorial.verbose.cod
index f9e9129..28d55a4 100644
--- a/factorial.verbose.cod
+++ b/factorial.verbose.cod
@@ -1,43 +1,43 @@
-VERBOSE ON
-GOTO start<<1>>
-LABEL Read
-READ
-RETURN
-LABEL Write
-LOAD 0 dummyFormal
-WRITE
-RETURN
-LABEL start<<1>>
-GOTO continue<<3>>
-LABEL factorial<<2>>
-LOAD 0 n
-LIT 2
-BOP <
-FALSEBRANCH else<<4>>
-LIT 1
-RETURN factorial<<2>>
-POP 0
-GOTO continue<<5>>
-LABEL else<<4>>
-LOAD 0 n
-LOAD 0 n
-LIT 1
-BOP -
-ARGS 1
-CALL factorial<<2>>
-BOP *
-RETURN factorial<<2>>
-POP 0
-LABEL continue<<5>>
-POP 0
-LIT 0    GRATIS-RETURN-VALUE
-RETURN factorial<<2>>
-LABEL continue<<3>>
-ARGS 0
-CALL Read
-ARGS 1
-CALL factorial<<2>>
-ARGS 1
-CALL Write
-POP 3
+VERBOSE ON
+GOTO start<<1>>
+LABEL Read
+READ
+RETURN
+LABEL Write
+LOAD 0 dummyFormal
+WRITE
+RETURN
+LABEL start<<1>>
+GOTO continue<<3>>
+LABEL factorial<<2>>
+LOAD 0 n
+LIT 2
+BOP <
+FALSEBRANCH else<<4>>
+LIT 1
+RETURN factorial<<2>>
+POP 0
+GOTO continue<<5>>
+LABEL else<<4>>
+LOAD 0 n
+LOAD 0 n
+LIT 1
+BOP -
+ARGS 1
+CALL factorial<<2>>
+BOP *
+RETURN factorial<<2>>
+POP 0
+LABEL continue<<5>>
+POP 0
+LIT 0    GRATIS-RETURN-VALUE
+RETURN factorial<<2>>
+LABEL continue<<3>>
+ARGS 0
+CALL Read
+ARGS 1
+CALL factorial<<2>>
+ARGS 1
+CALL Write
+POP 3
 HALT
\ No newline at end of file
diff --git a/factorial.x.cod b/factorial.x.cod
index a1b1716..d185d62 100644
--- a/factorial.x.cod
+++ b/factorial.x.cod
@@ -1,42 +1,42 @@
-GOTO start<<1>>
-LABEL Read
-READ
-RETURN
-LABEL Write
-LOAD 0 dummyFormal
-WRITE
-RETURN
-LABEL start<<1>>
-GOTO continue<<3>>
-LABEL factorial<<2>>
-LOAD 0 n
-LIT 2
-BOP <
-FALSEBRANCH else<<4>>
-LIT 1
-RETURN factorial<<2>>
-POP 0
-GOTO continue<<5>>
-LABEL else<<4>>
-LOAD 0 n
-LOAD 0 n
-LIT 1
-BOP -
-ARGS 1
-CALL factorial<<2>>
-BOP *
-RETURN factorial<<2>>
-POP 0
-LABEL continue<<5>>
-POP 0
-LIT 0    GRATIS-RETURN-VALUE
-RETURN factorial<<2>>
-LABEL continue<<3>>
-ARGS 0
-CALL Read
-ARGS 1
-CALL factorial<<2>>
-ARGS 1
-CALL Write
-POP 3
+GOTO start<<1>>
+LABEL Read
+READ
+RETURN
+LABEL Write
+LOAD 0 dummyFormal
+WRITE
+RETURN
+LABEL start<<1>>
+GOTO continue<<3>>
+LABEL factorial<<2>>
+LOAD 0 n
+LIT 2
+BOP <
+FALSEBRANCH else<<4>>
+LIT 1
+RETURN factorial<<2>>
+POP 0
+GOTO continue<<5>>
+LABEL else<<4>>
+LOAD 0 n
+LOAD 0 n
+LIT 1
+BOP -
+ARGS 1
+CALL factorial<<2>>
+BOP *
+RETURN factorial<<2>>
+POP 0
+LABEL continue<<5>>
+POP 0
+LIT 0    GRATIS-RETURN-VALUE
+RETURN factorial<<2>>
+LABEL continue<<3>>
+ARGS 0
+CALL Read
+ARGS 1
+CALL factorial<<2>>
+ARGS 1
+CALL Write
+POP 3
 HALT
\ No newline at end of file
diff --git a/functionArgsTest.cod b/functionArgsTest.cod
index a1a96a6..819eb0e 100644
--- a/functionArgsTest.cod
+++ b/functionArgsTest.cod
@@ -1,60 +1,60 @@
-GOTO CONTINUE<<1>>
-LABEL CONTINUE<<2>>
-GOTO CONTINUE<<3>>
-LABEL CONTINUE<<4>>
-LIT 0
-LIT 1
-ARGS 2
-CALL doublePrint<<1>>
-POP 1
-LIT 0
-LIT 1
-LIT 2
-ARGS 3
-CALL triplePrint<<1>>
-POP 1
-LIT 0
-LIT 1
-LIT 2
-LIT 3
-ARGS 4
-CALL quadruplePrint<<1>>
-POP 66
-HALT
-LABEL CONTINUE<<1>>
-GOTO CONTINUE<<2>>
-LABEL CONTINUE<<3>>
-GOTO CONTINUE<<4>>
-LABEL doublePrint<<1>>
-LOAD 0
-WRITE
-POP 1
-LOAD 1
-WRITE
-POP 1
-RETURN doublePrint<<1>>
-LABEL triplePrint<<1>>
-LOAD 0
-WRITE
-POP 1
-LOAD 1
-WRITE
-POP 1
-LOAD 2
-WRITE
-POP 2
-RETURN triplePrint<<1>>
-LABEL quadruplePrint<<1>>
-LOAD 0
-WRITE
-POP 1
-LOAD 1
-WRITE
-POP 1
-LOAD 2
-WRITE
-POP 1
-LOAD 3
-WRITE
-POP 1
+GOTO CONTINUE<<1>>
+LABEL CONTINUE<<2>>
+GOTO CONTINUE<<3>>
+LABEL CONTINUE<<4>>
+LIT 0
+LIT 1
+ARGS 2
+CALL doublePrint<<1>>
+POP 1
+LIT 0
+LIT 1
+LIT 2
+ARGS 3
+CALL triplePrint<<1>>
+POP 1
+LIT 0
+LIT 1
+LIT 2
+LIT 3
+ARGS 4
+CALL quadruplePrint<<1>>
+POP 66
+HALT
+LABEL CONTINUE<<1>>
+GOTO CONTINUE<<2>>
+LABEL CONTINUE<<3>>
+GOTO CONTINUE<<4>>
+LABEL doublePrint<<1>>
+LOAD 0
+WRITE
+POP 1
+LOAD 1
+WRITE
+POP 1
+RETURN doublePrint<<1>>
+LABEL triplePrint<<1>>
+LOAD 0
+WRITE
+POP 1
+LOAD 1
+WRITE
+POP 1
+LOAD 2
+WRITE
+POP 2
+RETURN triplePrint<<1>>
+LABEL quadruplePrint<<1>>
+LOAD 0
+WRITE
+POP 1
+LOAD 1
+WRITE
+POP 1
+LOAD 2
+WRITE
+POP 1
+LOAD 3
+WRITE
+POP 1
 RETURN quadruplePrint<<1>>
\ No newline at end of file
diff --git a/interpreter/bytecodes/AddressResolvable.java b/interpreter/bytecodes/AddressResolvable.java
new file mode 100644
index 0000000..4192790
--- /dev/null
+++ b/interpreter/bytecodes/AddressResolvable.java
@@ -0,0 +1,12 @@
+package interpreter.bytecodes;
+
+/**
+ * Separates label resolution from execution so branch bytecodes do not need to
+ * search the program while the VM is running.
+ */
+public interface AddressResolvable {
+
+    String getLabel();
+
+    void setResolvedAddress(int address);
+}
diff --git a/interpreter/bytecodes/ArgsCode.java b/interpreter/bytecodes/ArgsCode.java
new file mode 100644
index 0000000..5cdb9db
--- /dev/null
+++ b/interpreter/bytecodes/ArgsCode.java
@@ -0,0 +1,28 @@
+package interpreter.bytecodes;
+
+import interpreter.virtualmachine.VirtualMachine;
+
+import java.util.List;
+
+/**
+ * Defines the next call frame before control transfers, keeping call setup separate from function entry.
+ */
+public class ArgsCode implements ByteCode {
+
+    private int argCount;
+
+    @Override
+    public void init(List<String> args) {
+        argCount = Integer.parseInt(args.get(0));
+    }
+
+    @Override
+    public void execute(VirtualMachine virtualMachine) {
+        virtualMachine.newFrameAt(argCount);
+    }
+
+    @Override
+    public String toString() {
+        return "ARGS " + argCount;
+    }
+}
diff --git a/interpreter/bytecodes/BopCode.java b/interpreter/bytecodes/BopCode.java
new file mode 100644
index 0000000..8311246
--- /dev/null
+++ b/interpreter/bytecodes/BopCode.java
@@ -0,0 +1,48 @@
+package interpreter.bytecodes;
+
+import interpreter.virtualmachine.VirtualMachine;
+
+import java.util.List;
+
+/**
+ * Centralizes binary expression evaluation so operands consistently follow stack order.
+ */
+public class BopCode implements ByteCode {
+
+    private String operator;
+
+    @Override
+    public void init(List<String> args) {
+        operator = args.get(0);
+    }
+
+    @Override
+    public void execute(VirtualMachine virtualMachine) {
+        int rightOperand = virtualMachine.popRunStack();
+        int leftOperand = virtualMachine.popRunStack();
+        int result;
+
+        switch (operator) {
+            case "+" -> result = leftOperand + rightOperand;
+            case "-" -> result = leftOperand - rightOperand;
+            case "*" -> result = leftOperand * rightOperand;
+            case "/" -> result = leftOperand / rightOperand;
+            case "==" -> result = leftOperand == rightOperand ? 1 : 0;
+            case "!=" -> result = leftOperand != rightOperand ? 1 : 0;
+            case "<=" -> result = leftOperand <= rightOperand ? 1 : 0;
+            case "<" -> result = leftOperand < rightOperand ? 1 : 0;
+            case ">=" -> result = leftOperand >= rightOperand ? 1 : 0;
+            case ">" -> result = leftOperand > rightOperand ? 1 : 0;
+            case "&" -> result = leftOperand != 0 && rightOperand != 0 ? 1 : 0;
+            case "|" -> result = leftOperand != 0 || rightOperand != 0 ? 1 : 0;
+            default -> throw new IllegalArgumentException("Unsupported binary operator: " + operator);
+        }
+
+        virtualMachine.pushRunStack(result);
+    }
+
+    @Override
+    public String toString() {
+        return "BOP " + operator;
+    }
+}
diff --git a/interpreter/bytecodes/ByteCode.java b/interpreter/bytecodes/ByteCode.java
new file mode 100644
index 0000000..a3073b8
--- /dev/null
+++ b/interpreter/bytecodes/ByteCode.java
@@ -0,0 +1,29 @@
+package interpreter.bytecodes;
+
+import interpreter.virtualmachine.VirtualMachine;
+
+import java.util.List;
+
+/**
+ * Keeps the VM execution loop independent of concrete instruction types, so new
+ * bytecodes can be added without changing the controller.
+ */
+public interface ByteCode {
+
+    /**
+     * Parsing belongs to each instruction because argument meaning depends on the
+     * concrete bytecode, not on the generic loader.
+     */
+    void init(List<String> args);
+
+    /**
+     * Runtime structures stay behind the VM boundary so instructions cannot break
+     * stack, heap, or program-counter invariants.
+     */
+    void execute(VirtualMachine virtualMachine);
+
+    /**
+     * Verbose tracing needs a source-level instruction view without exposing VM state.
+     */
+    String toString();
+}
diff --git a/interpreter/bytecodes/CallCode.java b/interpreter/bytecodes/CallCode.java
new file mode 100644
index 0000000..e41fe13
--- /dev/null
+++ b/interpreter/bytecodes/CallCode.java
@@ -0,0 +1,50 @@
+package interpreter.bytecodes;
+
+import interpreter.virtualmachine.VirtualMachine;
+
+import java.util.List;
+
+/**
+ * Couples the resolved function target with a saved return point so nested calls unwind predictably.
+ */
+public class CallCode implements ByteCode, AddressResolvable {
+
+    private String label;
+    private int resolvedAddress;
+    private String arguments;
+
+    @Override
+    public void init(List<String> args) {
+        label = args.get(0);
+    }
+
+    @Override
+    public void execute(VirtualMachine virtualMachine) {
+        arguments = virtualMachine.currentFrameValuesDisplay();
+        virtualMachine.pushReturnAddress(virtualMachine.getProgramCounter());
+        virtualMachine.setProgramCounter(resolvedAddress);
+    }
+
+    @Override
+    public String getLabel() {
+        return label;
+    }
+
+    @Override
+    public void setResolvedAddress(int address) {
+        resolvedAddress = address;
+    }
+
+    @Override
+    public String toString() {
+        return "CALL " + label + "\t" + baseLabel() + "(" + arguments + ")";
+    }
+
+    private String baseLabel() {
+        int generatedSuffix = label.indexOf("<<");
+        if (generatedSuffix < 0) {
+            return label;
+        }
+        return label.substring(0, generatedSuffix);
+    }
+}
diff --git a/interpreter/bytecodes/FalseBranchCode.java b/interpreter/bytecodes/FalseBranchCode.java
new file mode 100644
index 0000000..9ab0605
--- /dev/null
+++ b/interpreter/bytecodes/FalseBranchCode.java
@@ -0,0 +1,42 @@
+package interpreter.bytecodes;
+
+import interpreter.virtualmachine.VirtualMachine;
+
+import java.util.List;
+
+/**
+ * Stores a resolved branch target so conditional jumps are constant-time during execution.
+ */
+public class FalseBranchCode implements ByteCode, AddressResolvable {
+
+    private String label;
+    private int resolvedAddress;
+
+    @Override
+    public void init(List<String> args) {
+        label = args.get(0);
+    }
+
+    @Override
+    public void execute(VirtualMachine virtualMachine) {
+        int condition = virtualMachine.popRunStack();
+        if (condition == 0) {
+            virtualMachine.setProgramCounter(resolvedAddress);
+        }
+    }
+
+    @Override
+    public String getLabel() {
+        return label;
+    }
+
+    @Override
+    public void setResolvedAddress(int address) {
+        resolvedAddress = address;
+    }
+
+    @Override
+    public String toString() {
+        return "FALSEBRANCH " + label;
+    }
+}
diff --git a/interpreter/bytecodes/FreeCode.java b/interpreter/bytecodes/FreeCode.java
new file mode 100644
index 0000000..f417b98
--- /dev/null
+++ b/interpreter/bytecodes/FreeCode.java
@@ -0,0 +1,26 @@
+package interpreter.bytecodes;
+
+import interpreter.virtualmachine.VirtualMachine;
+
+import java.util.List;
+
+/**
+ * Releases memory through the VM so double-free and use-after-free policy stays in the heap component.
+ */
+public class FreeCode implements ByteCode {
+
+    @Override
+    public void init(List<String> args) {
+    }
+
+    @Override
+    public void execute(VirtualMachine virtualMachine) {
+        int address = virtualMachine.popRunStack();
+        virtualMachine.freeHeap(address);
+    }
+
+    @Override
+    public String toString() {
+        return "FREE";
+    }
+}
diff --git a/interpreter/bytecodes/GotoCode.java b/interpreter/bytecodes/GotoCode.java
new file mode 100644
index 0000000..167cac2
--- /dev/null
+++ b/interpreter/bytecodes/GotoCode.java
@@ -0,0 +1,39 @@
+package interpreter.bytecodes;
+
+import interpreter.virtualmachine.VirtualMachine;
+
+import java.util.List;
+
+/**
+ * Stores a resolved branch target so the VM does not resolve labels while running.
+ */
+public class GotoCode implements ByteCode, AddressResolvable {
+
+    private String label;
+    private int resolvedAddress;
+
+    @Override
+    public void init(List<String> args) {
+        label = args.get(0);
+    }
+
+    @Override
+    public void execute(VirtualMachine virtualMachine) {
+        virtualMachine.setProgramCounter(resolvedAddress);
+    }
+
+    @Override
+    public String getLabel() {
+        return label;
+    }
+
+    @Override
+    public void setResolvedAddress(int address) {
+        resolvedAddress = address;
+    }
+
+    @Override
+    public String toString() {
+        return "GOTO " + label;
+    }
+}
diff --git a/interpreter/bytecodes/HaltCode.java b/interpreter/bytecodes/HaltCode.java
new file mode 100644
index 0000000..5e5f020
--- /dev/null
+++ b/interpreter/bytecodes/HaltCode.java
@@ -0,0 +1,25 @@
+package interpreter.bytecodes;
+
+import interpreter.virtualmachine.VirtualMachine;
+
+import java.util.List;
+
+/**
+ * Requests termination through the VM so program shutdown stays inside the interpreter lifecycle.
+ */
+public class HaltCode implements ByteCode {
+
+    @Override
+    public void init(List<String> args) {
+    }
+
+    @Override
+    public void execute(VirtualMachine virtualMachine) {
+        virtualMachine.halt();
+    }
+
+    @Override
+    public String toString() {
+        return "HALT";
+    }
+}
diff --git a/interpreter/bytecodes/HeapLoadCode.java b/interpreter/bytecodes/HeapLoadCode.java
new file mode 100644
index 0000000..0351a27
--- /dev/null
+++ b/interpreter/bytecodes/HeapLoadCode.java
@@ -0,0 +1,28 @@
+package interpreter.bytecodes;
+
+import interpreter.virtualmachine.VirtualMachine;
+
+import java.util.List;
+
+/**
+ * Moves heap values through the VM stack path so heap validation remains centralized.
+ */
+public class HeapLoadCode implements ByteCode {
+
+    @Override
+    public void init(List<String> args) {
+    }
+
+    @Override
+    public void execute(VirtualMachine virtualMachine) {
+        int offset = virtualMachine.popRunStack();
+        int address = virtualMachine.popRunStack();
+        int value = virtualMachine.loadHeap(address, offset);
+        virtualMachine.pushRunStack(value);
+    }
+
+    @Override
+    public String toString() {
+        return "HLOAD";
+    }
+}
diff --git a/interpreter/bytecodes/HeapStoreCode.java b/interpreter/bytecodes/HeapStoreCode.java
new file mode 100644
index 0000000..433a2ac
--- /dev/null
+++ b/interpreter/bytecodes/HeapStoreCode.java
@@ -0,0 +1,28 @@
+package interpreter.bytecodes;
+
+import interpreter.virtualmachine.VirtualMachine;
+
+import java.util.List;
+
+/**
+ * Sends heap writes through the VM so address and bounds checks stay centralized.
+ */
+public class HeapStoreCode implements ByteCode {
+
+    @Override
+    public void init(List<String> args) {
+    }
+
+    @Override
+    public void execute(VirtualMachine virtualMachine) {
+        int value = virtualMachine.popRunStack();
+        int offset = virtualMachine.popRunStack();
+        int address = virtualMachine.popRunStack();
+        virtualMachine.storeHeap(address, offset, value);
+    }
+
+    @Override
+    public String toString() {
+        return "HSTORE";
+    }
+}
diff --git a/interpreter/bytecodes/LabelCode.java b/interpreter/bytecodes/LabelCode.java
new file mode 100644
index 0000000..ba2586c
--- /dev/null
+++ b/interpreter/bytecodes/LabelCode.java
@@ -0,0 +1,31 @@
+package interpreter.bytecodes;
+
+import interpreter.virtualmachine.VirtualMachine;
+
+import java.util.List;
+
+/**
+ * Preserves compiler labels in the program so address resolution has stable branch targets.
+ */
+public class LabelCode implements ByteCode {
+
+    private String label;
+
+    @Override
+    public void init(List<String> args) {
+        label = args.get(0);
+    }
+
+    @Override
+    public void execute(VirtualMachine virtualMachine) {
+    }
+
+    public String getLabel() {
+        return label;
+    }
+
+    @Override
+    public String toString() {
+        return "LABEL " + label;
+    }
+}
diff --git a/interpreter/bytecodes/LitCode.java b/interpreter/bytecodes/LitCode.java
new file mode 100644
index 0000000..3b8129b
--- /dev/null
+++ b/interpreter/bytecodes/LitCode.java
@@ -0,0 +1,35 @@
+package interpreter.bytecodes;
+
+import interpreter.virtualmachine.VirtualMachine;
+
+import java.util.List;
+
+/**
+ * Represents constants as instructions so expression evaluation uses the same VM stack path as computed values.
+ */
+public class LitCode implements ByteCode {
+
+    private int value;
+    private String id;
+
+    @Override
+    public void init(List<String> args) {
+        value = Integer.parseInt(args.get(0));
+        if (args.size() > 1) {
+            id = args.get(1);
+        }
+    }
+
+    @Override
+    public void execute(VirtualMachine virtualMachine) {
+        virtualMachine.pushRunStack(value);
+    }
+
+    @Override
+    public String toString() {
+        if (id == null) {
+            return "LIT " + value;
+        }
+        return "LIT " + value + " " + id + "\tint " + id;
+    }
+}
diff --git a/interpreter/bytecodes/LoadCode.java b/interpreter/bytecodes/LoadCode.java
new file mode 100644
index 0000000..70dac5e
--- /dev/null
+++ b/interpreter/bytecodes/LoadCode.java
@@ -0,0 +1,35 @@
+package interpreter.bytecodes;
+
+import interpreter.virtualmachine.VirtualMachine;
+
+import java.util.List;
+
+/**
+ * Delegates frame reads to the VM so ByteCodes cannot bypass runtime-stack encapsulation.
+ */
+public class LoadCode implements ByteCode {
+
+    private int offset;
+    private String id;
+
+    @Override
+    public void init(List<String> args) {
+        offset = Integer.parseInt(args.get(0));
+        if (args.size() > 1) {
+            id = args.get(1);
+        }
+    }
+
+    @Override
+    public void execute(VirtualMachine virtualMachine) {
+        virtualMachine.loadRunStack(offset);
+    }
+
+    @Override
+    public String toString() {
+        if (id == null) {
+            return "LOAD " + offset;
+        }
+        return "LOAD " + offset + " " + id + "\t<load " + id + ">";
+    }
+}
diff --git a/interpreter/bytecodes/NewCode.java b/interpreter/bytecodes/NewCode.java
new file mode 100644
index 0000000..79a1cbf
--- /dev/null
+++ b/interpreter/bytecodes/NewCode.java
@@ -0,0 +1,29 @@
+package interpreter.bytecodes;
+
+import interpreter.virtualmachine.VirtualMachine;
+
+import java.util.List;
+
+/**
+ * Requests allocation through the VM so heap ownership remains separate from instruction logic.
+ */
+public class NewCode implements ByteCode {
+
+    private int size;
+
+    @Override
+    public void init(List<String> args) {
+        size = Integer.parseInt(args.get(0));
+    }
+
+    @Override
+    public void execute(VirtualMachine virtualMachine) {
+        int address = virtualMachine.allocateHeap(size);
+        virtualMachine.pushRunStack(address);
+    }
+
+    @Override
+    public String toString() {
+        return "NEW " + size;
+    }
+}
diff --git a/interpreter/bytecodes/PopCode.java b/interpreter/bytecodes/PopCode.java
new file mode 100644
index 0000000..25f1450
--- /dev/null
+++ b/interpreter/bytecodes/PopCode.java
@@ -0,0 +1,34 @@
+package interpreter.bytecodes;
+
+import interpreter.virtualmachine.VirtualMachine;
+
+import java.util.List;
+
+/**
+ * Uses VM stack operations so frame-boundary rules remain enforced by the runtime stack.
+ */
+public class PopCode implements ByteCode {
+
+    private int count;
+
+    @Override
+    public void init(List<String> args) {
+        count = Integer.parseInt(args.get(0));
+    }
+
+    @Override
+    public void execute(VirtualMachine virtualMachine) {
+        for (int i = 0; i < count; i++) {
+            try {
+                virtualMachine.popRunStack();
+            } catch (IllegalStateException ex) {
+                break;
+            }
+        }
+    }
+
+    @Override
+    public String toString() {
+        return "POP " + count;
+    }
+}
diff --git a/interpreter/bytecodes/ReadCode.java b/interpreter/bytecodes/ReadCode.java
new file mode 100644
index 0000000..277e38a
--- /dev/null
+++ b/interpreter/bytecodes/ReadCode.java
@@ -0,0 +1,38 @@
+package interpreter.bytecodes;
+
+import interpreter.virtualmachine.VirtualMachine;
+
+import java.util.List;
+import java.util.Scanner;
+
+/**
+ * Validates input before it enters the VM stack so later bytecodes can assume integer operands.
+ */
+public class ReadCode implements ByteCode {
+
+    private static final Scanner INPUT = new Scanner(System.in);
+
+    @Override
+    public void init(List<String> args) {
+    }
+
+    @Override
+    public void execute(VirtualMachine virtualMachine) {
+        while (true) {
+            System.out.print("Please enter an integer : ");
+            if (INPUT.hasNextInt()) {
+                virtualMachine.pushRunStack(INPUT.nextInt());
+                INPUT.nextLine();
+                return;
+            }
+
+            INPUT.nextLine();
+            System.out.println("Invalid input. Please enter an integer.");
+        }
+    }
+
+    @Override
+    public String toString() {
+        return "READ";
+    }
+}
diff --git a/interpreter/bytecodes/ReturnCode.java b/interpreter/bytecodes/ReturnCode.java
new file mode 100644
index 0000000..a6892c9
--- /dev/null
+++ b/interpreter/bytecodes/ReturnCode.java
@@ -0,0 +1,44 @@
+package interpreter.bytecodes;
+
+import interpreter.virtualmachine.VirtualMachine;
+
+import java.util.List;
+
+/**
+ * Restores caller control through VM-owned frame and return-address operations.
+ */
+public class ReturnCode implements ByteCode {
+
+    private String label;
+    private int returnValue;
+
+    @Override
+    public void init(List<String> args) {
+        if (!args.isEmpty()) {
+            label = args.get(0);
+        }
+    }
+
+    @Override
+    public void execute(VirtualMachine virtualMachine) {
+        returnValue = virtualMachine.peekRunStack();
+        virtualMachine.popFrame();
+        virtualMachine.setProgramCounter(virtualMachine.popReturnAddress());
+    }
+
+    @Override
+    public String toString() {
+        if (label == null) {
+            return "RETURN";
+        }
+        return "RETURN " + label + "\tEXIT " + baseLabel() + ":" + returnValue;
+    }
+
+    private String baseLabel() {
+        int generatedSuffix = label.indexOf("<<");
+        if (generatedSuffix < 0) {
+            return label;
+        }
+        return label.substring(0, generatedSuffix);
+    }
+}
diff --git a/interpreter/bytecodes/StoreCode.java b/interpreter/bytecodes/StoreCode.java
new file mode 100644
index 0000000..f169255
--- /dev/null
+++ b/interpreter/bytecodes/StoreCode.java
@@ -0,0 +1,36 @@
+package interpreter.bytecodes;
+
+import interpreter.virtualmachine.VirtualMachine;
+
+import java.util.List;
+
+/**
+ * Delegates assignment to the VM so current-frame boundaries stay protected.
+ */
+public class StoreCode implements ByteCode {
+
+    private int offset;
+    private String id;
+    private int storedValue;
+
+    @Override
+    public void init(List<String> args) {
+        offset = Integer.parseInt(args.get(0));
+        if (args.size() > 1) {
+            id = args.get(1);
+        }
+    }
+
+    @Override
+    public void execute(VirtualMachine virtualMachine) {
+        storedValue = virtualMachine.storeRunStack(offset);
+    }
+
+    @Override
+    public String toString() {
+        if (id == null) {
+            return "STORE " + offset;
+        }
+        return "STORE " + offset + " " + id + "\t" + id + " = " + storedValue;
+    }
+}
diff --git a/interpreter/bytecodes/VerboseCode.java b/interpreter/bytecodes/VerboseCode.java
new file mode 100644
index 0000000..f245793
--- /dev/null
+++ b/interpreter/bytecodes/VerboseCode.java
@@ -0,0 +1,28 @@
+package interpreter.bytecodes;
+
+import interpreter.virtualmachine.VirtualMachine;
+
+import java.util.List;
+
+/**
+ * Changes tracing through the VM so ByteCodes do not own or query global execution state.
+ */
+public class VerboseCode implements ByteCode {
+
+    private String state;
+
+    @Override
+    public void init(List<String> args) {
+        state = args.get(0);
+    }
+
+    @Override
+    public void execute(VirtualMachine virtualMachine) {
+        virtualMachine.setVerbose("ON".equals(state));
+    }
+
+    @Override
+    public String toString() {
+        return "VERBOSE " + state;
+    }
+}
diff --git a/interpreter/bytecodes/WriteCode.java b/interpreter/bytecodes/WriteCode.java
new file mode 100644
index 0000000..37f292e
--- /dev/null
+++ b/interpreter/bytecodes/WriteCode.java
@@ -0,0 +1,25 @@
+package interpreter.bytecodes;
+
+import interpreter.virtualmachine.VirtualMachine;
+
+import java.util.List;
+
+/**
+ * Keeps program output limited to stack values so tracing and program output remain separable.
+ */
+public class WriteCode implements ByteCode {
+
+    @Override
+    public void init(List<String> args) {
+    }
+
+    @Override
+    public void execute(VirtualMachine virtualMachine) {
+        System.out.println(virtualMachine.peekRunStack());
+    }
+
+    @Override
+    public String toString() {
+        return "WRITE";
+    }
+}
diff --git a/interpreter/loaders/ByteCodeLoader.java b/interpreter/loaders/ByteCodeLoader.java
index a9bbb87..e4052e3 100644
--- a/interpreter/loaders/ByteCodeLoader.java
+++ b/interpreter/loaders/ByteCodeLoader.java
@@ -1,27 +1,60 @@
-package interpreter.loaders;
-
-import interpreter.loaders.exceptions.InvalidProgramException;
-
-public final class ByteCodeLoader {
-    private String codSourceFileName;
-
-    /**
-     * Constructs ByteCodeLoader object given a COD source code
-     * file name
-     *
-     * @param fileName name of .cod File to load.
-     */
-    public ByteCodeLoader(String fileName) {
-        this.codSourceFileName = fileName;
-    }
-
-    /**
-     * Loads a program from a .cod file.
-     *
-     * @return a constructed Program Object.
-     * @throws InvalidProgramException thrown when loadCodes fails.
-     */
-    public Program loadCodes() throws InvalidProgramException {
-        return null;
-    }
-}
+package interpreter.loaders;
+
+import interpreter.bytecodes.ByteCode;
+import interpreter.loaders.exceptions.InvalidProgramException;
+
+import java.io.BufferedReader;
+import java.io.FileReader;
+import java.util.ArrayList;
+import java.util.Arrays;
+import java.util.List;
+
+/**
+ * Converts source-file lines into initialized ByteCode objects so parsing is
+ * completed before the VM begins execution.
+ */
+public final class ByteCodeLoader {
+    private static final String BYTECODE_PACKAGE = "interpreter.bytecodes.";
+
+    private final String codSourceFileName;
+
+    public ByteCodeLoader(String fileName) {
+        this.codSourceFileName = fileName;
+    }
+
+    public Program loadCodes() throws InvalidProgramException {
+        Program program = new Program();
+
+        try (BufferedReader reader = new BufferedReader(new FileReader(codSourceFileName))) {
+            String line;
+            while ((line = reader.readLine()) != null) {
+                line = line.trim();
+                if (line.isEmpty()) {
+                    continue;
+                }
+
+                program.addCode(createByteCode(line));
+            }
+        } catch (Exception ex) {
+            throw new InvalidProgramException(ex, "Unable to load bytecode program: " + codSourceFileName);
+        }
+
+        return program;
+    }
+
+    private ByteCode createByteCode(String sourceLine) throws ReflectiveOperationException {
+        String[] tokens = sourceLine.split("\\s+");
+        String className = CodeTable.getClassName(tokens[0]);
+
+        if (className == null) {
+            throw new ClassNotFoundException("No bytecode class mapping for token: " + tokens[0]);
+        }
+
+        Class<?> byteCodeClass = Class.forName(BYTECODE_PACKAGE + className);
+        ByteCode byteCode = (ByteCode) byteCodeClass.getDeclaredConstructor().newInstance();
+
+        List<String> args = new ArrayList<>(Arrays.asList(tokens).subList(1, tokens.length));
+        byteCode.init(args);
+        return byteCode;
+    }
+}
diff --git a/interpreter/loaders/CodeTable.java b/interpreter/loaders/CodeTable.java
index 65d73cb..219b2f4 100644
--- a/interpreter/loaders/CodeTable.java
+++ b/interpreter/loaders/CodeTable.java
@@ -1,31 +1,45 @@
 package interpreter.loaders;
 
+import java.util.HashMap;
+import java.util.Map;
+
 /**
- * Code table of byte codes in language X.
- *
- * Maps a bytecode token to the class name that implements it.
+ * Keeps source tokens decoupled from class names so the loader can construct
+ * instructions without hard-coding every concrete bytecode decision.
  */
 public final class CodeTable {
 
+    private static final Map<String, String> byteCodeTable = new HashMap<>();
+
     private CodeTable() {
-        // do nothing
     }
 
-    /**
-     * Fills code table with class name mappings.
-     */
     public static void init() {
+        byteCodeTable.clear();
 
+        byteCodeTable.put("HALT", "HaltCode");
+        byteCodeTable.put("POP", "PopCode");
+        byteCodeTable.put("FALSEBRANCH", "FalseBranchCode");
+        byteCodeTable.put("GOTO", "GotoCode");
+        byteCodeTable.put("STORE", "StoreCode");
+        byteCodeTable.put("LOAD", "LoadCode");
+        byteCodeTable.put("LIT", "LitCode");
+        byteCodeTable.put("ARGS", "ArgsCode");
+        byteCodeTable.put("CALL", "CallCode");
+        byteCodeTable.put("RETURN", "ReturnCode");
+        byteCodeTable.put("BOP", "BopCode");
+        byteCodeTable.put("READ", "ReadCode");
+        byteCodeTable.put("WRITE", "WriteCode");
+        byteCodeTable.put("LABEL", "LabelCode");
+        byteCodeTable.put("VERBOSE", "VerboseCode");
+        byteCodeTable.put("NEW", "NewCode");
+        byteCodeTable.put("HLOAD", "HeapLoadCode");
+        byteCodeTable.put("HSTORE", "HeapStoreCode");
+        byteCodeTable.put("FREE", "FreeCode");
     }
 
-    /**
-     * Returns the ByteCode class name for a given token.
-     *
-     * @param token bytecode to map. For example, HALT --> HaltCode
-     * @return class name of bytecode
-     */
     public static String getClassName(String token) {
-        return null;
+        return byteCodeTable.get(token.trim());
     }
 
 }
diff --git a/interpreter/loaders/Program.java b/interpreter/loaders/Program.java
index 1727ba9..58f82c1 100644
--- a/interpreter/loaders/Program.java
+++ b/interpreter/loaders/Program.java
@@ -1,58 +1,58 @@
 package interpreter.loaders;
 
+import interpreter.bytecodes.AddressResolvable;
+import interpreter.bytecodes.ByteCode;
+import interpreter.bytecodes.LabelCode;
+
 import java.util.ArrayList;
+import java.util.HashMap;
 import java.util.List;
+import java.util.Map;
 
+/**
+ * Owns the loaded instruction sequence so parsing, address resolution, and VM
+ * execution do not share mutable source-file state.
+ */
 public class Program {
 
-    private List<ByteCode> program;
+    private final List<ByteCode> program;
 
-    /**
-     * Instantiates a program object using an
-     * ArrayList
-     */
     public Program() {
-
+        program = new ArrayList<>();
     }
 
-    /**
-     * Gets the size of the current program.
-     *
-     * @return size of program
-     */
     public int getSize() {
-        return 0;
+        return program.size();
     }
 
-    /**
-     * Grabs an instance of a bytecode at an index.
-     *
-     * @param programCounter index of bytecode to get.
-     * @return a bytecode.
-     */
     public ByteCode getCode(int programCounter) {
-        return null;
+        return program.get(programCounter);
     }
 
-    /**
-     * Adds a bytecode instance to the Program List.
-     *
-     * @param c bytecode to be added
-     */
     public void addCode(ByteCode c) {
-
+        program.add(c);
     }
 
-    /**
-     * Makes multiple passes through the program ArrayList
-     * resolving addresses for the Goto, Call, and FalseBranch
-     * bytecodes. These bytecodes can only jump to Label
-     * codes that have a matching label value.
-     * HINT: make note of what type of data-structure
-     * ByteCodes are stored in.
-     * **** METHOD SIGNATURE CANNOT BE CHANGED *****
-     */
     public void resolveAddress() {
-
+        Map<String, Integer> labelAddresses = new HashMap<>();
+
+        for (int address = 0; address < program.size(); address++) {
+            ByteCode code = program.get(address);
+            if (code instanceof LabelCode labelCode) {
+                labelAddresses.put(labelCode.getLabel(), address);
+            }
+        }
+
+        for (ByteCode code : program) {
+            if (code instanceof AddressResolvable addressResolvable) {
+                Integer resolvedAddress = labelAddresses.get(addressResolvable.getLabel());
+                if (resolvedAddress == null) {
+                    throw new IllegalStateException("No matching label for: " + addressResolvable.getLabel());
+                }
+
+                // Branch targets are cached before execution so jumps stay independent of source text.
+                addressResolvable.setResolvedAddress(resolvedAddress);
+            }
+        }
     }
 }
diff --git a/interpreter/loaders/exceptions/InvalidProgramException.java b/interpreter/loaders/exceptions/InvalidProgramException.java
index 82fac94..10b9204 100644
--- a/interpreter/loaders/exceptions/InvalidProgramException.java
+++ b/interpreter/loaders/exceptions/InvalidProgramException.java
@@ -1,10 +1,9 @@
 package interpreter.loaders.exceptions;
 
 /**
- * Exception for when loadCode fails.
- * This exception is used to bubble up all
- * exceptions that can be thrown by loadCodes.
- * 
+ * Gives loading failures one boundary type so Interpreter can handle invalid
+ * programs without depending on file I/O or reflection details.
+ *
  * DO NOT ADD ANY ADDITIONAL Constructors.
  */
 public class InvalidProgramException extends RuntimeException {
diff --git a/interpreter/virtualmachine/Heap.java b/interpreter/virtualmachine/Heap.java
index 02a9985..a48d645 100644
--- a/interpreter/virtualmachine/Heap.java
+++ b/interpreter/virtualmachine/Heap.java
@@ -1,97 +1,94 @@
-package interpreter.virtualmachine;
-
-import java.util.HashMap;
-import java.util.HashSet;
-import java.util.Map;
-import java.util.Set;
-
-import interpreter.virtualmachine.exceptions.HeapBoundsException;
-import interpreter.virtualmachine.exceptions.HeapOutOfMemoryException;
-import interpreter.virtualmachine.exceptions.HeapUseAfterFreeException;
-import interpreter.virtualmachine.exceptions.InvalidHeapAddressException;
-
-class Heap {
-
-    private static final int BYTES_PER_MEGABYTE = 1024 * 1024;
-    private static final int MAX_HEAP_SIZE_BYTES = 2 * BYTES_PER_MEGABYTE;
-    private static final int MAX_HEAP_SLOTS = MAX_HEAP_SIZE_BYTES / Integer.BYTES;
-
-    private final Map<Integer, int[]> allocations;
-    private final Set<Integer> freed;
-    private int nextAddress;
-    private int usedSlots;
-
-
-    public Heap() {
-        allocations = new HashMap<>();
-        freed = new HashSet<>();
-        nextAddress = 1; // 0 is reserved as the null address
-        usedSlots = 0;
-    }
-
-    /**
-     * Allocates a contiguous block of size integer slots on the heap.
-     *
-     * @param size the number of integer slots to allocate
-     * @return the base address of the newly allocated block
-     * @throws HeapOutOfMemoryException if the allocation would exceed the maximum heap size
-     */
-    int allocate(int size) throws HeapOutOfMemoryException {
-        return -1;
-    }
-
-    /**
-     * Loads the integer value stored at address + offset on the heap.
-     *
-     * @param address the base address of the allocated block
-     * @param offset  the index within the block to read from
-     * @return the integer value at the specified location
-     * @throws InvalidHeapAddressException if  address was never allocated
-     * @throws HeapUseAfterFreeException   if the block at  address has been freed
-     * @throws HeapBoundsException         if  offset is out of range for the block
-     */
-    int load(int address, int offset)
-            throws InvalidHeapAddressException, HeapUseAfterFreeException, HeapBoundsException {
-        return -1;
-    }
-
-    /**
-     * Stores  value at  address + offset on the heap.
-     *
-     * @param address the base address of the allocated block
-     * @param offset  the index within the block to write to
-     * @param value   the integer value to store
-     * @throws InvalidHeapAddressException if  address was never allocated
-     * @throws HeapUseAfterFreeException   if the block at  address}has been freed
-     * @throws HeapBoundsException         if  offset is out of range for the block
-     */
-    void store(int address, int offset, int value)
-            throws InvalidHeapAddressException, HeapUseAfterFreeException, HeapBoundsException {
-
-    }
-
-    /**
-     * Frees the allocated block at  address, making its slots available again.
-     *
-     * @param address the base address of the block to free
-     * @throws InvalidHeapAddressException if  address was never allocated
-     * @throws HeapUseAfterFreeException   if the block at  address has already been freed
-     */
-    void free(int address) throws InvalidHeapAddressException, HeapUseAfterFreeException {
-       
-    }
-
-    /**
-     * Validates that  address refers to a live (non-freed) allocation and that
-     *  offset falls within the bounds of that allocation.
-     *
-     * @param address the base address to validate
-     * @param offset  the offset within the block to validate
-     * @throws InvalidHeapAddressException if  address was never allocated
-     * @throws HeapUseAfterFreeException   if the block at  address has been freed
-     * @throws HeapBoundsException         if  offset is out of range for the block
-     */
-    private void checkAccess(int address, int offset) throws InvalidHeapAddressException, HeapUseAfterFreeException, HeapBoundsException {
-       
-    }
-}
+package interpreter.virtualmachine;
+
+import interpreter.virtualmachine.exceptions.HeapBoundsException;
+import interpreter.virtualmachine.exceptions.HeapOutOfMemoryException;
+import interpreter.virtualmachine.exceptions.HeapUseAfterFreeException;
+import interpreter.virtualmachine.exceptions.InvalidHeapAddressException;
+
+import java.util.HashMap;
+import java.util.HashSet;
+import java.util.Map;
+import java.util.Set;
+
+/**
+ * Isolates dynamic memory from call frames so heap references can outlive the
+ * stack frame that produced them while still enforcing address safety.
+ */
+class Heap {
+
+    private static final int BYTES_PER_MEGABYTE = 1024 * 1024;
+    private static final int MAX_HEAP_SIZE_BYTES = 2 * BYTES_PER_MEGABYTE;
+    private static final int MAX_HEAP_SLOTS = MAX_HEAP_SIZE_BYTES / Integer.BYTES;
+
+    private final Map<Integer, int[]> allocations;
+    private final Set<Integer> freed;
+    private int nextAddress;
+    private int usedSlots;
+
+
+    public Heap() {
+        allocations = new HashMap<>();
+        freed = new HashSet<>();
+        // Zero is left invalid so an uninitialized reference cannot look like a live allocation.
+        nextAddress = 1;
+        usedSlots = 0;
+    }
+
+    int allocate(int size) throws HeapOutOfMemoryException {
+        if (size <= 0) {
+            throw new IllegalArgumentException("Heap allocation size must be positive.");
+        }
+
+        if (size > MAX_HEAP_SLOTS - usedSlots) {
+            throw new HeapOutOfMemoryException("Heap allocation would exceed the maximum heap size.");
+        }
+
+        int address = nextAddress++;
+        allocations.put(address, new int[size]);
+        usedSlots += size;
+        return address;
+    }
+
+    int load(int address, int offset)
+            throws InvalidHeapAddressException, HeapUseAfterFreeException, HeapBoundsException {
+        checkAccess(address, offset);
+        return allocations.get(address)[offset];
+    }
+
+    void store(int address, int offset, int value)
+            throws InvalidHeapAddressException, HeapUseAfterFreeException, HeapBoundsException {
+        checkAccess(address, offset);
+        allocations.get(address)[offset] = value;
+    }
+
+    void free(int address) throws InvalidHeapAddressException, HeapUseAfterFreeException {
+        if (freed.contains(address)) {
+            throw new HeapUseAfterFreeException("Heap block has already been freed: " + address);
+        }
+
+        int[] block = allocations.remove(address);
+        if (block == null) {
+            throw new InvalidHeapAddressException("Heap address was never allocated: " + address);
+        }
+
+        // Freed addresses stay recorded so a stale reference is not mistaken for a never-used address.
+        freed.add(address);
+        usedSlots -= block.length;
+    }
+
+    private void checkAccess(int address, int offset) throws InvalidHeapAddressException, HeapUseAfterFreeException, HeapBoundsException {
+        if (freed.contains(address)) {
+            throw new HeapUseAfterFreeException("Heap block has already been freed: " + address);
+        }
+
+        int[] block = allocations.get(address);
+        if (block == null) {
+            throw new InvalidHeapAddressException("Heap address was never allocated: " + address);
+        }
+
+        int blockSize = block.length;
+        if (offset < 0 || offset >= blockSize) {
+            throw new HeapBoundsException("Heap offset is outside the allocated block: " + offset);
+        }
+    }
+}
diff --git a/interpreter/virtualmachine/RunTimeStack.java b/interpreter/virtualmachine/RunTimeStack.java
index aacfab8..f0806b1 100644
--- a/interpreter/virtualmachine/RunTimeStack.java
+++ b/interpreter/virtualmachine/RunTimeStack.java
@@ -4,17 +4,142 @@ import java.util.ArrayList;
 import java.util.List;
 import java.util.Stack;
 
+/**
+ * Keeps values and frame boundaries together so function calls can reuse one
+ * stack while still protecting each activation record.
+ */
 class RunTimeStack {
 
-    private List<Integer> runTimeStack;
-    private Stack<Integer> framePointer;
+    private final ArrayList<Integer> runTimeStack;
+    private final Stack<Integer> framePointer;
 
     public RunTimeStack() {
         runTimeStack = new ArrayList<>();
         framePointer = new Stack<>();
-        // Add initial frame pointer value, main is the entry
-        // point of our language, so its frame pointer is 0.
+        // Main has no caller, so its frame boundary anchors all later relative offsets.
         framePointer.add(0);
     }
 
+    public String verboseDisplay() {
+        StringBuilder display = new StringBuilder();
+
+        for (int frame = 0; frame < framePointer.size(); frame++) {
+            if (frame > 0) {
+                display.append(" ");
+            }
+
+            int frameStart = framePointer.get(frame);
+            int frameEnd = frame + 1 < framePointer.size()
+                    ? framePointer.get(frame + 1)
+                    : runTimeStack.size();
+
+            display.append(formatFrame(runTimeStack.subList(frameStart, frameEnd)));
+        }
+
+        return display.toString();
+    }
+
+    String currentFrameValuesDisplay() {
+        int frameStart = framePointer.peek();
+        StringBuilder display = new StringBuilder();
+
+        for (int index = frameStart; index < runTimeStack.size(); index++) {
+            if (index > frameStart) {
+                display.append(",");
+            }
+            display.append(runTimeStack.get(index));
+        }
+
+        return display.toString();
+    }
+
+    public int peek() {
+        if (runTimeStack.isEmpty()) {
+            throw new IllegalStateException("Cannot peek an empty runtime stack.");
+        }
+
+        return runTimeStack.get(runTimeStack.size() - 1);
+    }
+
+    public int push(int i) {
+        runTimeStack.add(i);
+        return i;
+    }
+
+    public int pop() {
+        if (runTimeStack.size() <= framePointer.peek()) {
+            throw new IllegalStateException("Cannot pop past the current frame boundary.");
+        }
+
+        return runTimeStack.remove(runTimeStack.size() - 1);
+    }
+
+    public int store(int offsetInFrame) {
+        int offset = frameOffsetToStackIndex(offsetInFrame);
+        int sizeAfterPop = runTimeStack.size() - 1;
+
+        if (offset >= sizeAfterPop) {
+            throw new IllegalArgumentException("Store offset cannot cross the current frame boundary.");
+        }
+
+        int value = pop();
+        runTimeStack.set(offset, value);
+        return value;
+    }
+
+    public int load(int offsetInFrame) {
+        int offset = frameOffsetToStackIndex(offsetInFrame);
+
+        if (offset >= runTimeStack.size()) {
+            throw new IllegalArgumentException("Load offset cannot cross the current frame boundary.");
+        }
+
+        return push(runTimeStack.get(offset));
+    }
+
+    public void newFrameAt(int offsetFromTopOfRunStack) {
+        if (offsetFromTopOfRunStack < 0 || offsetFromTopOfRunStack > runTimeStack.size()) {
+            throw new IllegalArgumentException("Frame offset must describe values already on the runtime stack.");
+        }
+
+        framePointer.push(runTimeStack.size() - offsetFromTopOfRunStack);
+    }
+
+    public void popFrame() {
+        if (framePointer.size() <= 1) {
+            throw new IllegalStateException("Cannot remove the initial runtime frame.");
+        }
+
+        int returnValue = peek();
+        int frameStart = framePointer.pop();
+
+        // Only the return value crosses back to the caller; local frame storage must disappear.
+        while (runTimeStack.size() > frameStart) {
+            runTimeStack.remove(runTimeStack.size() - 1);
+        }
+
+        push(returnValue);
+    }
+
+    private int frameOffsetToStackIndex(int offsetInFrame) {
+        if (offsetInFrame < 0) {
+            throw new IllegalArgumentException("Frame offset must be non-negative.");
+        }
+
+        return framePointer.peek() + offsetInFrame;
+    }
+
+    private String formatFrame(List<Integer> frameValues) {
+        StringBuilder frame = new StringBuilder("[");
+
+        for (int i = 0; i < frameValues.size(); i++) {
+            if (i > 0) {
+                frame.append(",");
+            }
+            frame.append(frameValues.get(i));
+        }
+
+        frame.append("]");
+        return frame.toString();
+    }
 }
diff --git a/interpreter/virtualmachine/VirtualMachine.java b/interpreter/virtualmachine/VirtualMachine.java
index d54530b..f4cdb32 100644
--- a/interpreter/virtualmachine/VirtualMachine.java
+++ b/interpreter/virtualmachine/VirtualMachine.java
@@ -1,22 +1,141 @@
-package interpreter.virtualmachine;
-
-import java.util.Stack;
-import interpreter.loaders.Program;
-
-public class VirtualMachine {
-
-    private RunTimeStack runTimeStack;
-    private Heap heap;
-    private Stack<Integer> returnAddress;
-    private Program program;
-    private int programCounter;
-    private boolean isRunning;
-
-    public VirtualMachine(Program program) {
-        this.program = program;
-        this.runTimeStack = new RunTimeStack();
-        this.heap = new Heap();
-        this.returnAddress = new Stack<>();
-        this.programCounter = 0;
-    }
-}
+package interpreter.virtualmachine;
+
+import interpreter.bytecodes.ByteCode;
+import interpreter.bytecodes.HaltCode;
+import interpreter.bytecodes.VerboseCode;
+import interpreter.loaders.Program;
+import interpreter.virtualmachine.exceptions.HeapBoundsException;
+import interpreter.virtualmachine.exceptions.HeapOutOfMemoryException;
+import interpreter.virtualmachine.exceptions.HeapUseAfterFreeException;
+import interpreter.virtualmachine.exceptions.InvalidHeapAddressException;
+
+import java.util.Stack;
+
+/**
+ * Owns execution state so ByteCodes can request operations without reaching into
+ * runtime structures directly.
+ */
+public class VirtualMachine {
+
+    private final RunTimeStack runTimeStack;
+    private final Heap heap;
+    private final Stack<Integer> returnAddress;
+    private final Program program;
+    private int programCounter;
+    private boolean isRunning;
+    private boolean isVerbose;
+
+    public VirtualMachine(Program program) {
+        this.program = program;
+        this.runTimeStack = new RunTimeStack();
+        this.heap = new Heap();
+        this.returnAddress = new Stack<>();
+        this.programCounter = 0;
+        this.isVerbose = false;
+    }
+
+    public void executeProgram() {
+        isRunning = true;
+
+        while (isRunning) {
+            ByteCode code = program.getCode(programCounter);
+            boolean verboseBeforeExecution = isVerbose;
+
+            code.execute(this);
+
+            if (shouldDisplayVerbose(code, verboseBeforeExecution)) {
+                System.out.println(code);
+                // A VERBOSE toggle reports only itself; its line marks where tracing
+                // starts or stops, so no frame snapshot belongs with it.
+                if (!(code instanceof VerboseCode)) {
+                    System.out.println(runTimeStack.verboseDisplay());
+                }
+            }
+
+            programCounter++;
+        }
+    }
+
+    public int pushRunStack(int value) {
+        return runTimeStack.push(value);
+    }
+
+    public int popRunStack() {
+        return runTimeStack.pop();
+    }
+
+    public int peekRunStack() {
+        return runTimeStack.peek();
+    }
+
+    public int loadRunStack(int offset) {
+        return runTimeStack.load(offset);
+    }
+
+    public int storeRunStack(int offset) {
+        return runTimeStack.store(offset);
+    }
+
+    public void newFrameAt(int offsetFromTopOfRunStack) {
+        runTimeStack.newFrameAt(offsetFromTopOfRunStack);
+    }
+
+    public void popFrame() {
+        runTimeStack.popFrame();
+    }
+
+    public void setProgramCounter(int programCounter) {
+        this.programCounter = programCounter;
+    }
+
+    public int getProgramCounter() {
+        return programCounter;
+    }
+
+    public void halt() {
+        isRunning = false;
+    }
+
+    public void pushReturnAddress(int address) {
+        returnAddress.push(address);
+    }
+
+    public int popReturnAddress() {
+        return returnAddress.pop();
+    }
+
+    public void setVerbose(boolean verbose) {
+        isVerbose = verbose;
+    }
+
+    public String currentFrameValuesDisplay() {
+        return runTimeStack.currentFrameValuesDisplay();
+    }
+
+    public int allocateHeap(int size) throws HeapOutOfMemoryException {
+        return heap.allocate(size);
+    }
+
+    public int loadHeap(int address, int offset)
+            throws InvalidHeapAddressException, HeapUseAfterFreeException, HeapBoundsException {
+        return heap.load(address, offset);
+    }
+
+    public void storeHeap(int address, int offset, int value)
+            throws InvalidHeapAddressException, HeapUseAfterFreeException, HeapBoundsException {
+        heap.store(address, offset, value);
+    }
+
+    public void freeHeap(int address) throws InvalidHeapAddressException, HeapUseAfterFreeException {
+        heap.free(address);
+    }
+
+    private boolean shouldDisplayVerbose(ByteCode code, boolean verboseBeforeExecution) {
+        if (code instanceof HaltCode) {
+            return false;
+        }
+
+        // The disabling instruction is still part of the trace that was active when it began.
+        return isVerbose || verboseBeforeExecution;
+    }
+}
diff --git a/interpreter/virtualmachine/exceptions/HeapBoundsException.java b/interpreter/virtualmachine/exceptions/HeapBoundsException.java
index f38bbae..06b80fb 100644
--- a/interpreter/virtualmachine/exceptions/HeapBoundsException.java
+++ b/interpreter/virtualmachine/exceptions/HeapBoundsException.java
@@ -1,7 +1,8 @@
 package interpreter.virtualmachine.exceptions;
 
 /**
- * Exception for when a heap access is outside the bounds of an allocated block.
+ * Separates out-of-range heap indexes from invalid addresses so heap errors
+ * identify which memory-safety rule was violated.
  */
 public class HeapBoundsException extends RuntimeException {
     public HeapBoundsException(Throwable ex) {
diff --git a/interpreter/virtualmachine/exceptions/HeapOutOfMemoryException.java b/interpreter/virtualmachine/exceptions/HeapOutOfMemoryException.java
index 449412d..5ea2977 100644
--- a/interpreter/virtualmachine/exceptions/HeapOutOfMemoryException.java
+++ b/interpreter/virtualmachine/exceptions/HeapOutOfMemoryException.java
@@ -1,7 +1,8 @@
 package interpreter.virtualmachine.exceptions;
 
 /**
- * Exception for when heap allocation fails because the heap is full.
+ * Keeps heap-capacity failures distinct from access failures so allocation code
+ * can report that no valid address was produced.
  */
 public class HeapOutOfMemoryException extends RuntimeException {
     public HeapOutOfMemoryException(Throwable ex) {
diff --git a/interpreter/virtualmachine/exceptions/HeapUseAfterFreeException.java b/interpreter/virtualmachine/exceptions/HeapUseAfterFreeException.java
index 9e6a1dd..d223673 100644
--- a/interpreter/virtualmachine/exceptions/HeapUseAfterFreeException.java
+++ b/interpreter/virtualmachine/exceptions/HeapUseAfterFreeException.java
@@ -1,7 +1,8 @@
 package interpreter.virtualmachine.exceptions;
 
 /**
- * Exception for when a program accesses heap memory after it has been freed.
+ * Preserves the difference between stale references and never-allocated addresses,
+ * which makes heap lifetime violations visible to the VM.
  */
 public class HeapUseAfterFreeException extends RuntimeException {
     public HeapUseAfterFreeException(Throwable ex) {
diff --git a/interpreter/virtualmachine/exceptions/InvalidHeapAddressException.java b/interpreter/virtualmachine/exceptions/InvalidHeapAddressException.java
index 7ad5ba4..4763c77 100644
--- a/interpreter/virtualmachine/exceptions/InvalidHeapAddressException.java
+++ b/interpreter/virtualmachine/exceptions/InvalidHeapAddressException.java
@@ -1,7 +1,8 @@
 package interpreter.virtualmachine.exceptions;
 
 /**
- * Exception for when a heap address is invalid.
+ * Distinguishes unknown heap references from live-block bounds errors and freed
+ * references during VM heap operations.
  */
 public class InvalidHeapAddressException extends RuntimeException {
     public InvalidHeapAddressException(Throwable ex) {

~~~

</details>




## Copy Expected Output Files Results 



~~~bash

~~~
    


## Copy COD Files Results 



~~~bash

~~~
    


## Compiling Source Code Results: 



~~~bash

~~~
    


## Code Review


<details>
    <summary>./interpreter/Interpreter.java</summary>

~~~java
package interpreter;

import interpreter.loaders.ByteCodeLoader;
import interpreter.loaders.CodeTable;
import interpreter.loaders.exceptions.InvalidProgramException;
import interpreter.loaders.Program;
import interpreter.virtualmachine.VirtualMachine;
import interpreter.virtualmachine.exceptions.HeapBoundsException;
import interpreter.virtualmachine.exceptions.HeapOutOfMemoryException;
import interpreter.virtualmachine.exceptions.HeapUseAfterFreeException;
import interpreter.virtualmachine.exceptions.InvalidHeapAddressException;

/**
 * <pre>
 *     Interpreter class runs the interpreter:
 *     1. Perform all initializations
 *     2. Load the ByteCodes from file
 *     3. Run the virtual machine
 * 
 *     THIS FILE CANNOT BE MODIFIED.
 * 
 * </pre>
 */
public class Interpreter {

    private ByteCodeLoader byteCodeLoader;

    public Interpreter(String codeFile) {
        byteCodeLoader = new ByteCodeLoader(codeFile);
    }

        void run() {
        CodeTable.init();
        Program program = null;
        try{
            program = byteCodeLoader.loadCodes();
            program.resolveAddress();
            VirtualMachine virtualMachine = new VirtualMachine(program);
            virtualMachine.executeProgram();
        } catch(InvalidProgramException ex){
            System.out.println(ex);
            ex.printStackTrace();
            System.exit(-2);
        } catch (HeapOutOfMemoryException |
                 HeapBoundsException |
                 HeapUseAfterFreeException |
                 InvalidHeapAddressException ex)
        {
            System.out.println(ex);
            ex.printStackTrace();
            System.exit(-3);
        }
    }

    public static void main(String args[]) {

        if (args.length == 0) {
            System.out.println("***Incorrect usage, try: java interpreter.Interpreter <file>");
            System.exit(1);
        }
        (new Interpreter(args[0])).run();
    }
}

~~~

</details>



<details>
    <summary>./interpreter/virtualmachine/VirtualMachine.java</summary>

~~~java
package interpreter.virtualmachine;

import interpreter.bytecodes.ByteCode;
import interpreter.bytecodes.HaltCode;
import interpreter.bytecodes.VerboseCode;
import interpreter.loaders.Program;
import interpreter.virtualmachine.exceptions.HeapBoundsException;
import interpreter.virtualmachine.exceptions.HeapOutOfMemoryException;
import interpreter.virtualmachine.exceptions.HeapUseAfterFreeException;
import interpreter.virtualmachine.exceptions.InvalidHeapAddressException;

import java.util.Stack;

/**
 * Owns execution state so ByteCodes can request operations without reaching into
 * runtime structures directly.
 */
public class VirtualMachine {

    private final RunTimeStack runTimeStack;
    private final Heap heap;
    private final Stack<Integer> returnAddress;
    private final Program program;
    private int programCounter;
    private boolean isRunning;
    private boolean isVerbose;

    public VirtualMachine(Program program) {
        this.program = program;
        this.runTimeStack = new RunTimeStack();
        this.heap = new Heap();
        this.returnAddress = new Stack<>();
        this.programCounter = 0;
        this.isVerbose = false;
    }

    public void executeProgram() {
        isRunning = true;

        while (isRunning) {
            ByteCode code = program.getCode(programCounter);
            boolean verboseBeforeExecution = isVerbose;

            code.execute(this);

            if (shouldDisplayVerbose(code, verboseBeforeExecution)) {
                System.out.println(code);
                // A VERBOSE toggle reports only itself; its line marks where tracing
                // starts or stops, so no frame snapshot belongs with it.
                if (!(code instanceof VerboseCode)) {
                    System.out.println(runTimeStack.verboseDisplay());
                }
            }

            programCounter++;
        }
    }

    public int pushRunStack(int value) {
        return runTimeStack.push(value);
    }

    public int popRunStack() {
        return runTimeStack.pop();
    }

    public int peekRunStack() {
        return runTimeStack.peek();
    }

    public int loadRunStack(int offset) {
        return runTimeStack.load(offset);
    }

    public int storeRunStack(int offset) {
        return runTimeStack.store(offset);
    }

    public void newFrameAt(int offsetFromTopOfRunStack) {
        runTimeStack.newFrameAt(offsetFromTopOfRunStack);
    }

    public void popFrame() {
        runTimeStack.popFrame();
    }

    public void setProgramCounter(int programCounter) {
        this.programCounter = programCounter;
    }

    public int getProgramCounter() {
        return programCounter;
    }

    public void halt() {
        isRunning = false;
    }

    public void pushReturnAddress(int address) {
        returnAddress.push(address);
    }

    public int popReturnAddress() {
        return returnAddress.pop();
    }

    public void setVerbose(boolean verbose) {
        isVerbose = verbose;
    }

    public String currentFrameValuesDisplay() {
        return runTimeStack.currentFrameValuesDisplay();
    }

    public int allocateHeap(int size) throws HeapOutOfMemoryException {
        return heap.allocate(size);
    }

    public int loadHeap(int address, int offset)
            throws InvalidHeapAddressException, HeapUseAfterFreeException, HeapBoundsException {
        return heap.load(address, offset);
    }

    public void storeHeap(int address, int offset, int value)
            throws InvalidHeapAddressException, HeapUseAfterFreeException, HeapBoundsException {
        heap.store(address, offset, value);
    }

    public void freeHeap(int address) throws InvalidHeapAddressException, HeapUseAfterFreeException {
        heap.free(address);
    }

    private boolean shouldDisplayVerbose(ByteCode code, boolean verboseBeforeExecution) {
        if (code instanceof HaltCode) {
            return false;
        }

        // The disabling instruction is still part of the trace that was active when it began.
        return isVerbose || verboseBeforeExecution;
    }
}

~~~

</details>



<details>
    <summary>./interpreter/virtualmachine/RunTimeStack.java</summary>

~~~java
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

~~~

</details>



<details>
    <summary>./interpreter/virtualmachine/Heap.java</summary>

~~~java
package interpreter.virtualmachine;

import interpreter.virtualmachine.exceptions.HeapBoundsException;
import interpreter.virtualmachine.exceptions.HeapOutOfMemoryException;
import interpreter.virtualmachine.exceptions.HeapUseAfterFreeException;
import interpreter.virtualmachine.exceptions.InvalidHeapAddressException;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Isolates dynamic memory from call frames so heap references can outlive the
 * stack frame that produced them while still enforcing address safety.
 */
class Heap {

    private static final int BYTES_PER_MEGABYTE = 1024 * 1024;
    private static final int MAX_HEAP_SIZE_BYTES = 2 * BYTES_PER_MEGABYTE;
    private static final int MAX_HEAP_SLOTS = MAX_HEAP_SIZE_BYTES / Integer.BYTES;

    private final Map<Integer, int[]> allocations;
    private final Set<Integer> freed;
    private int nextAddress;
    private int usedSlots;


    public Heap() {
        allocations = new HashMap<>();
        freed = new HashSet<>();
        // Zero is left invalid so an uninitialized reference cannot look like a live allocation.
        nextAddress = 1;
        usedSlots = 0;
    }

    int allocate(int size) throws HeapOutOfMemoryException {
        if (size <= 0) {
            throw new IllegalArgumentException("Heap allocation size must be positive.");
        }

        if (size > MAX_HEAP_SLOTS - usedSlots) {
            throw new HeapOutOfMemoryException("Heap allocation would exceed the maximum heap size.");
        }

        int address = nextAddress++;
        allocations.put(address, new int[size]);
        usedSlots += size;
        return address;
    }

    int load(int address, int offset)
            throws InvalidHeapAddressException, HeapUseAfterFreeException, HeapBoundsException {
        checkAccess(address, offset);
        return allocations.get(address)[offset];
    }

    void store(int address, int offset, int value)
            throws InvalidHeapAddressException, HeapUseAfterFreeException, HeapBoundsException {
        checkAccess(address, offset);
        allocations.get(address)[offset] = value;
    }

    void free(int address) throws InvalidHeapAddressException, HeapUseAfterFreeException {
        if (freed.contains(address)) {
            throw new HeapUseAfterFreeException("Heap block has already been freed: " + address);
        }

        int[] block = allocations.remove(address);
        if (block == null) {
            throw new InvalidHeapAddressException("Heap address was never allocated: " + address);
        }

        // Freed addresses stay recorded so a stale reference is not mistaken for a never-used address.
        freed.add(address);
        usedSlots -= block.length;
    }

    private void checkAccess(int address, int offset) throws InvalidHeapAddressException, HeapUseAfterFreeException, HeapBoundsException {
        if (freed.contains(address)) {
            throw new HeapUseAfterFreeException("Heap block has already been freed: " + address);
        }

        int[] block = allocations.get(address);
        if (block == null) {
            throw new InvalidHeapAddressException("Heap address was never allocated: " + address);
        }

        int blockSize = block.length;
        if (offset < 0 || offset >= blockSize) {
            throw new HeapBoundsException("Heap offset is outside the allocated block: " + offset);
        }
    }
}

~~~

</details>



<details>
    <summary>./interpreter/virtualmachine/exceptions/HeapOutOfMemoryException.java</summary>

~~~java
package interpreter.virtualmachine.exceptions;

/**
 * Keeps heap-capacity failures distinct from access failures so allocation code
 * can report that no valid address was produced.
 */
public class HeapOutOfMemoryException extends RuntimeException {
    public HeapOutOfMemoryException(Throwable ex) {
        super(ex);
    }

    public HeapOutOfMemoryException(Throwable ex, String message) {
        super(message, ex);
    }

    public HeapOutOfMemoryException(String message) {
        super(message);
    }
}

~~~

</details>



<details>
    <summary>./interpreter/virtualmachine/exceptions/HeapBoundsException.java</summary>

~~~java
package interpreter.virtualmachine.exceptions;

/**
 * Separates out-of-range heap indexes from invalid addresses so heap errors
 * identify which memory-safety rule was violated.
 */
public class HeapBoundsException extends RuntimeException {
    public HeapBoundsException(Throwable ex) {
        super(ex);
    }

    public HeapBoundsException(Throwable ex, String message) {
        super(message, ex);
    }

    public HeapBoundsException(String message) {
        super(message);
    }
}

~~~

</details>



<details>
    <summary>./interpreter/virtualmachine/exceptions/HeapUseAfterFreeException.java</summary>

~~~java
package interpreter.virtualmachine.exceptions;

/**
 * Preserves the difference between stale references and never-allocated addresses,
 * which makes heap lifetime violations visible to the VM.
 */
public class HeapUseAfterFreeException extends RuntimeException {
    public HeapUseAfterFreeException(Throwable ex) {
        super(ex);
    }

    public HeapUseAfterFreeException(Throwable ex, String message) {
        super(message, ex);
    }

    public HeapUseAfterFreeException(String message) {
        super(message);
    }
}

~~~

</details>



<details>
    <summary>./interpreter/virtualmachine/exceptions/InvalidHeapAddressException.java</summary>

~~~java
package interpreter.virtualmachine.exceptions;

/**
 * Distinguishes unknown heap references from live-block bounds errors and freed
 * references during VM heap operations.
 */
public class InvalidHeapAddressException extends RuntimeException {
    public InvalidHeapAddressException(Throwable ex) {
        super(ex);
    }

    public InvalidHeapAddressException(Throwable ex, String message) {
        super(message, ex);
    }

    public InvalidHeapAddressException(String message) {
        super(message);
    }
}

~~~

</details>



<details>
    <summary>./interpreter/loaders/ByteCodeLoader.java</summary>

~~~java
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

~~~

</details>



<details>
    <summary>./interpreter/loaders/CodeTable.java</summary>

~~~java
package interpreter.loaders;

import java.util.HashMap;
import java.util.Map;

/**
 * Keeps source tokens decoupled from class names so the loader can construct
 * instructions without hard-coding every concrete bytecode decision.
 */
public final class CodeTable {

    private static final Map<String, String> byteCodeTable = new HashMap<>();

    private CodeTable() {
    }

    public static void init() {
        byteCodeTable.clear();

        byteCodeTable.put("HALT", "HaltCode");
        byteCodeTable.put("POP", "PopCode");
        byteCodeTable.put("FALSEBRANCH", "FalseBranchCode");
        byteCodeTable.put("GOTO", "GotoCode");
        byteCodeTable.put("STORE", "StoreCode");
        byteCodeTable.put("LOAD", "LoadCode");
        byteCodeTable.put("LIT", "LitCode");
        byteCodeTable.put("ARGS", "ArgsCode");
        byteCodeTable.put("CALL", "CallCode");
        byteCodeTable.put("RETURN", "ReturnCode");
        byteCodeTable.put("BOP", "BopCode");
        byteCodeTable.put("READ", "ReadCode");
        byteCodeTable.put("WRITE", "WriteCode");
        byteCodeTable.put("LABEL", "LabelCode");
        byteCodeTable.put("VERBOSE", "VerboseCode");
        byteCodeTable.put("NEW", "NewCode");
        byteCodeTable.put("HLOAD", "HeapLoadCode");
        byteCodeTable.put("HSTORE", "HeapStoreCode");
        byteCodeTable.put("FREE", "FreeCode");
    }

    public static String getClassName(String token) {
        return byteCodeTable.get(token.trim());
    }

}

~~~

</details>



<details>
    <summary>./interpreter/loaders/Program.java</summary>

~~~java
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

~~~

</details>



<details>
    <summary>./interpreter/loaders/exceptions/InvalidProgramException.java</summary>

~~~java
package interpreter.loaders.exceptions;

/**
 * Gives loading failures one boundary type so Interpreter can handle invalid
 * programs without depending on file I/O or reflection details.
 *
 * DO NOT ADD ANY ADDITIONAL Constructors.
 */
public class InvalidProgramException extends RuntimeException {
    public InvalidProgramException(Throwable ex) {
        super(ex);
    }

    public InvalidProgramException(Throwable ex, String message) {
        super(message, ex);
    }

    public InvalidProgramException(String message) {
        super(message);
    }
}

~~~

</details>



<details>
    <summary>./interpreter/bytecodes/ByteCode.java</summary>

~~~java
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

~~~

</details>



<details>
    <summary>./interpreter/bytecodes/HaltCode.java</summary>

~~~java
package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

import java.util.List;

/**
 * Requests termination through the VM so program shutdown stays inside the interpreter lifecycle.
 */
public class HaltCode implements ByteCode {

    @Override
    public void init(List<String> args) {
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        virtualMachine.halt();
    }

    @Override
    public String toString() {
        return "HALT";
    }
}

~~~

</details>



<details>
    <summary>./interpreter/bytecodes/LoadCode.java</summary>

~~~java
package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

import java.util.List;

/**
 * Delegates frame reads to the VM so ByteCodes cannot bypass runtime-stack encapsulation.
 */
public class LoadCode implements ByteCode {

    private int offset;
    private String id;

    @Override
    public void init(List<String> args) {
        offset = Integer.parseInt(args.get(0));
        if (args.size() > 1) {
            id = args.get(1);
        }
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        virtualMachine.loadRunStack(offset);
    }

    @Override
    public String toString() {
        if (id == null) {
            return "LOAD " + offset;
        }
        return "LOAD " + offset + " " + id + "\t<load " + id + ">";
    }
}

~~~

</details>



<details>
    <summary>./interpreter/bytecodes/ArgsCode.java</summary>

~~~java
package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

import java.util.List;

/**
 * Defines the next call frame before control transfers, keeping call setup separate from function entry.
 */
public class ArgsCode implements ByteCode {

    private int argCount;

    @Override
    public void init(List<String> args) {
        argCount = Integer.parseInt(args.get(0));
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        virtualMachine.newFrameAt(argCount);
    }

    @Override
    public String toString() {
        return "ARGS " + argCount;
    }
}

~~~

</details>



<details>
    <summary>./interpreter/bytecodes/ReturnCode.java</summary>

~~~java
package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

import java.util.List;

/**
 * Restores caller control through VM-owned frame and return-address operations.
 */
public class ReturnCode implements ByteCode {

    private String label;
    private int returnValue;

    @Override
    public void init(List<String> args) {
        if (!args.isEmpty()) {
            label = args.get(0);
        }
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        returnValue = virtualMachine.peekRunStack();
        virtualMachine.popFrame();
        virtualMachine.setProgramCounter(virtualMachine.popReturnAddress());
    }

    @Override
    public String toString() {
        if (label == null) {
            return "RETURN";
        }
        return "RETURN " + label + "\tEXIT " + baseLabel() + ":" + returnValue;
    }

    private String baseLabel() {
        int generatedSuffix = label.indexOf("<<");
        if (generatedSuffix < 0) {
            return label;
        }
        return label.substring(0, generatedSuffix);
    }
}

~~~

</details>



<details>
    <summary>./interpreter/bytecodes/AddressResolvable.java</summary>

~~~java
package interpreter.bytecodes;

/**
 * Separates label resolution from execution so branch bytecodes do not need to
 * search the program while the VM is running.
 */
public interface AddressResolvable {

    String getLabel();

    void setResolvedAddress(int address);
}

~~~

</details>



<details>
    <summary>./interpreter/bytecodes/StoreCode.java</summary>

~~~java
package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

import java.util.List;

/**
 * Delegates assignment to the VM so current-frame boundaries stay protected.
 */
public class StoreCode implements ByteCode {

    private int offset;
    private String id;
    private int storedValue;

    @Override
    public void init(List<String> args) {
        offset = Integer.parseInt(args.get(0));
        if (args.size() > 1) {
            id = args.get(1);
        }
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        storedValue = virtualMachine.storeRunStack(offset);
    }

    @Override
    public String toString() {
        if (id == null) {
            return "STORE " + offset;
        }
        return "STORE " + offset + " " + id + "\t" + id + " = " + storedValue;
    }
}

~~~

</details>



<details>
    <summary>./interpreter/bytecodes/VerboseCode.java</summary>

~~~java
package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

import java.util.List;

/**
 * Changes tracing through the VM so ByteCodes do not own or query global execution state.
 */
public class VerboseCode implements ByteCode {

    private String state;

    @Override
    public void init(List<String> args) {
        state = args.get(0);
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        virtualMachine.setVerbose("ON".equals(state));
    }

    @Override
    public String toString() {
        return "VERBOSE " + state;
    }
}

~~~

</details>



<details>
    <summary>./interpreter/bytecodes/LitCode.java</summary>

~~~java
package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

import java.util.List;

/**
 * Represents constants as instructions so expression evaluation uses the same VM stack path as computed values.
 */
public class LitCode implements ByteCode {

    private int value;
    private String id;

    @Override
    public void init(List<String> args) {
        value = Integer.parseInt(args.get(0));
        if (args.size() > 1) {
            id = args.get(1);
        }
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        virtualMachine.pushRunStack(value);
    }

    @Override
    public String toString() {
        if (id == null) {
            return "LIT " + value;
        }
        return "LIT " + value + " " + id + "\tint " + id;
    }
}

~~~

</details>



<details>
    <summary>./interpreter/bytecodes/LabelCode.java</summary>

~~~java
package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

import java.util.List;

/**
 * Preserves compiler labels in the program so address resolution has stable branch targets.
 */
public class LabelCode implements ByteCode {

    private String label;

    @Override
    public void init(List<String> args) {
        label = args.get(0);
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
    }

    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return "LABEL " + label;
    }
}

~~~

</details>



<details>
    <summary>./interpreter/bytecodes/WriteCode.java</summary>

~~~java
package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

import java.util.List;

/**
 * Keeps program output limited to stack values so tracing and program output remain separable.
 */
public class WriteCode implements ByteCode {

    @Override
    public void init(List<String> args) {
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        System.out.println(virtualMachine.peekRunStack());
    }

    @Override
    public String toString() {
        return "WRITE";
    }
}

~~~

</details>



<details>
    <summary>./interpreter/bytecodes/GotoCode.java</summary>

~~~java
package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

import java.util.List;

/**
 * Stores a resolved branch target so the VM does not resolve labels while running.
 */
public class GotoCode implements ByteCode, AddressResolvable {

    private String label;
    private int resolvedAddress;

    @Override
    public void init(List<String> args) {
        label = args.get(0);
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        virtualMachine.setProgramCounter(resolvedAddress);
    }

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public void setResolvedAddress(int address) {
        resolvedAddress = address;
    }

    @Override
    public String toString() {
        return "GOTO " + label;
    }
}

~~~

</details>



<details>
    <summary>./interpreter/bytecodes/CallCode.java</summary>

~~~java
package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

import java.util.List;

/**
 * Couples the resolved function target with a saved return point so nested calls unwind predictably.
 */
public class CallCode implements ByteCode, AddressResolvable {

    private String label;
    private int resolvedAddress;
    private String arguments;

    @Override
    public void init(List<String> args) {
        label = args.get(0);
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        arguments = virtualMachine.currentFrameValuesDisplay();
        virtualMachine.pushReturnAddress(virtualMachine.getProgramCounter());
        virtualMachine.setProgramCounter(resolvedAddress);
    }

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public void setResolvedAddress(int address) {
        resolvedAddress = address;
    }

    @Override
    public String toString() {
        return "CALL " + label + "\t" + baseLabel() + "(" + arguments + ")";
    }

    private String baseLabel() {
        int generatedSuffix = label.indexOf("<<");
        if (generatedSuffix < 0) {
            return label;
        }
        return label.substring(0, generatedSuffix);
    }
}

~~~

</details>



<details>
    <summary>./interpreter/bytecodes/HeapStoreCode.java</summary>

~~~java
package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

import java.util.List;

/**
 * Sends heap writes through the VM so address and bounds checks stay centralized.
 */
public class HeapStoreCode implements ByteCode {

    @Override
    public void init(List<String> args) {
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        int value = virtualMachine.popRunStack();
        int offset = virtualMachine.popRunStack();
        int address = virtualMachine.popRunStack();
        virtualMachine.storeHeap(address, offset, value);
    }

    @Override
    public String toString() {
        return "HSTORE";
    }
}

~~~

</details>



<details>
    <summary>./interpreter/bytecodes/NewCode.java</summary>

~~~java
package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

import java.util.List;

/**
 * Requests allocation through the VM so heap ownership remains separate from instruction logic.
 */
public class NewCode implements ByteCode {

    private int size;

    @Override
    public void init(List<String> args) {
        size = Integer.parseInt(args.get(0));
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        int address = virtualMachine.allocateHeap(size);
        virtualMachine.pushRunStack(address);
    }

    @Override
    public String toString() {
        return "NEW " + size;
    }
}

~~~

</details>



<details>
    <summary>./interpreter/bytecodes/PopCode.java</summary>

~~~java
package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

import java.util.List;

/**
 * Uses VM stack operations so frame-boundary rules remain enforced by the runtime stack.
 */
public class PopCode implements ByteCode {

    private int count;

    @Override
    public void init(List<String> args) {
        count = Integer.parseInt(args.get(0));
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        for (int i = 0; i < count; i++) {
            try {
                virtualMachine.popRunStack();
            } catch (IllegalStateException ex) {
                break;
            }
        }
    }

    @Override
    public String toString() {
        return "POP " + count;
    }
}

~~~

</details>



<details>
    <summary>./interpreter/bytecodes/FalseBranchCode.java</summary>

~~~java
package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

import java.util.List;

/**
 * Stores a resolved branch target so conditional jumps are constant-time during execution.
 */
public class FalseBranchCode implements ByteCode, AddressResolvable {

    private String label;
    private int resolvedAddress;

    @Override
    public void init(List<String> args) {
        label = args.get(0);
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        int condition = virtualMachine.popRunStack();
        if (condition == 0) {
            virtualMachine.setProgramCounter(resolvedAddress);
        }
    }

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public void setResolvedAddress(int address) {
        resolvedAddress = address;
    }

    @Override
    public String toString() {
        return "FALSEBRANCH " + label;
    }
}

~~~

</details>



<details>
    <summary>./interpreter/bytecodes/ReadCode.java</summary>

~~~java
package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

import java.util.List;
import java.util.Scanner;

/**
 * Validates input before it enters the VM stack so later bytecodes can assume integer operands.
 */
public class ReadCode implements ByteCode {

    private static final Scanner INPUT = new Scanner(System.in);

    @Override
    public void init(List<String> args) {
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        while (true) {
            System.out.print("Please enter an integer : ");
            if (INPUT.hasNextInt()) {
                virtualMachine.pushRunStack(INPUT.nextInt());
                INPUT.nextLine();
                return;
            }

            INPUT.nextLine();
            System.out.println("Invalid input. Please enter an integer.");
        }
    }

    @Override
    public String toString() {
        return "READ";
    }
}

~~~

</details>



<details>
    <summary>./interpreter/bytecodes/FreeCode.java</summary>

~~~java
package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

import java.util.List;

/**
 * Releases memory through the VM so double-free and use-after-free policy stays in the heap component.
 */
public class FreeCode implements ByteCode {

    @Override
    public void init(List<String> args) {
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        int address = virtualMachine.popRunStack();
        virtualMachine.freeHeap(address);
    }

    @Override
    public String toString() {
        return "FREE";
    }
}

~~~

</details>



<details>
    <summary>./interpreter/bytecodes/HeapLoadCode.java</summary>

~~~java
package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

import java.util.List;

/**
 * Moves heap values through the VM stack path so heap validation remains centralized.
 */
public class HeapLoadCode implements ByteCode {

    @Override
    public void init(List<String> args) {
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        int offset = virtualMachine.popRunStack();
        int address = virtualMachine.popRunStack();
        int value = virtualMachine.loadHeap(address, offset);
        virtualMachine.pushRunStack(value);
    }

    @Override
    public String toString() {
        return "HLOAD";
    }
}

~~~

</details>



<details>
    <summary>./interpreter/bytecodes/BopCode.java</summary>

~~~java
package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

import java.util.List;

/**
 * Centralizes binary expression evaluation so operands consistently follow stack order.
 */
public class BopCode implements ByteCode {

    private String operator;

    @Override
    public void init(List<String> args) {
        operator = args.get(0);
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        int rightOperand = virtualMachine.popRunStack();
        int leftOperand = virtualMachine.popRunStack();
        int result;

        switch (operator) {
            case "+" -> result = leftOperand + rightOperand;
            case "-" -> result = leftOperand - rightOperand;
            case "*" -> result = leftOperand * rightOperand;
            case "/" -> result = leftOperand / rightOperand;
            case "==" -> result = leftOperand == rightOperand ? 1 : 0;
            case "!=" -> result = leftOperand != rightOperand ? 1 : 0;
            case "<=" -> result = leftOperand <= rightOperand ? 1 : 0;
            case "<" -> result = leftOperand < rightOperand ? 1 : 0;
            case ">=" -> result = leftOperand >= rightOperand ? 1 : 0;
            case ">" -> result = leftOperand > rightOperand ? 1 : 0;
            case "&" -> result = leftOperand != 0 && rightOperand != 0 ? 1 : 0;
            case "|" -> result = leftOperand != 0 || rightOperand != 0 ? 1 : 0;
            default -> throw new IllegalArgumentException("Unsupported binary operator: " + operator);
        }

        virtualMachine.pushRunStack(result);
    }

    @Override
    public String toString() {
        return "BOP " + operator;
    }
}

~~~

</details>




## Factorial Run with Input 6 and VERBOSE OFF



### Program Output



~~~bash
Please enter an integer : 6
720

~~~
    


### Program Output Diff



~~~bash
Files exp_fact6.out and act_fact6.out are identical

~~~
    


## Factorial Run with Input 6 and VERBOSE ON



### Program Output



~~~bash
VERBOSE ON
GOTO start<<1>>
[]
GOTO continue<<3>>
[]
ARGS 0
[] []
CALL Read	Read()
[] []
Please enter an integer : 6
READ
[] [6]
RETURN
[6]
ARGS 1
[] [6]
CALL factorial<<2>>	factorial(6)
[] [6]
LOAD 0 n	<load n>
[] [6,6]
LIT 2
[] [6,6,2]
BOP <
[] [6,0]
FALSEBRANCH else<<4>>
[] [6]
LOAD 0 n	<load n>
[] [6,6]
LOAD 0 n	<load n>
[] [6,6,6]
LIT 1
[] [6,6,6,1]
BOP -
[] [6,6,5]
ARGS 1
[] [6,6] [5]
CALL factorial<<2>>	factorial(5)
[] [6,6] [5]
LOAD 0 n	<load n>
[] [6,6] [5,5]
LIT 2
[] [6,6] [5,5,2]
BOP <
[] [6,6] [5,0]
FALSEBRANCH else<<4>>
[] [6,6] [5]
LOAD 0 n	<load n>
[] [6,6] [5,5]
LOAD 0 n	<load n>
[] [6,6] [5,5,5]
LIT 1
[] [6,6] [5,5,5,1]
BOP -
[] [6,6] [5,5,4]
ARGS 1
[] [6,6] [5,5] [4]
CALL factorial<<2>>	factorial(4)
[] [6,6] [5,5] [4]
LOAD 0 n	<load n>
[] [6,6] [5,5] [4,4]
LIT 2
[] [6,6] [5,5] [4,4,2]
BOP <
[] [6,6] [5,5] [4,0]
FALSEBRANCH else<<4>>
[] [6,6] [5,5] [4]
LOAD 0 n	<load n>
[] [6,6] [5,5] [4,4]
LOAD 0 n	<load n>
[] [6,6] [5,5] [4,4,4]
LIT 1
[] [6,6] [5,5] [4,4,4,1]
BOP -
[] [6,6] [5,5] [4,4,3]
ARGS 1
[] [6,6] [5,5] [4,4] [3]
CALL factorial<<2>>	factorial(3)
[] [6,6] [5,5] [4,4] [3]
LOAD 0 n	<load n>
[] [6,6] [5,5] [4,4] [3,3]
LIT 2
[] [6,6] [5,5] [4,4] [3,3,2]
BOP <
[] [6,6] [5,5] [4,4] [3,0]
FALSEBRANCH else<<4>>
[] [6,6] [5,5] [4,4] [3]
LOAD 0 n	<load n>
[] [6,6] [5,5] [4,4] [3,3]
LOAD 0 n	<load n>
[] [6,6] [5,5] [4,4] [3,3,3]
LIT 1
[] [6,6] [5,5] [4,4] [3,3,3,1]
BOP -
[] [6,6] [5,5] [4,4] [3,3,2]
ARGS 1
[] [6,6] [5,5] [4,4] [3,3] [2]
CALL factorial<<2>>	factorial(2)
[] [6,6] [5,5] [4,4] [3,3] [2]
LOAD 0 n	<load n>
[] [6,6] [5,5] [4,4] [3,3] [2,2]
LIT 2
[] [6,6] [5,5] [4,4] [3,3] [2,2,2]
BOP <
[] [6,6] [5,5] [4,4] [3,3] [2,0]
FALSEBRANCH else<<4>>
[] [6,6] [5,5] [4,4] [3,3] [2]
LOAD 0 n	<load n>
[] [6,6] [5,5] [4,4] [3,3] [2,2]
LOAD 0 n	<load n>
[] [6,6] [5,5] [4,4] [3,3] [2,2,2]
LIT 1
[] [6,6] [5,5] [4,4] [3,3] [2,2,2,1]
BOP -
[] [6,6] [5,5] [4,4] [3,3] [2,2,1]
ARGS 1
[] [6,6] [5,5] [4,4] [3,3] [2,2] [1]
CALL factorial<<2>>	factorial(1)
[] [6,6] [5,5] [4,4] [3,3] [2,2] [1]
LOAD 0 n	<load n>
[] [6,6] [5,5] [4,4] [3,3] [2,2] [1,1]
LIT 2
[] [6,6] [5,5] [4,4] [3,3] [2,2] [1,1,2]
BOP <
[] [6,6] [5,5] [4,4] [3,3] [2,2] [1,1]
FALSEBRANCH else<<4>>
[] [6,6] [5,5] [4,4] [3,3] [2,2] [1]
LIT 1
[] [6,6] [5,5] [4,4] [3,3] [2,2] [1,1]
RETURN factorial<<2>>	EXIT factorial:1
[] [6,6] [5,5] [4,4] [3,3] [2,2,1]
BOP *
[] [6,6] [5,5] [4,4] [3,3] [2,2]
RETURN factorial<<2>>	EXIT factorial:2
[] [6,6] [5,5] [4,4] [3,3,2]
BOP *
[] [6,6] [5,5] [4,4] [3,6]
RETURN factorial<<2>>	EXIT factorial:6
[] [6,6] [5,5] [4,4,6]
BOP *
[] [6,6] [5,5] [4,24]
RETURN factorial<<2>>	EXIT factorial:24
[] [6,6] [5,5,24]
BOP *
[] [6,6] [5,120]
RETURN factorial<<2>>	EXIT factorial:120
[] [6,6,120]
BOP *
[] [6,720]
RETURN factorial<<2>>	EXIT factorial:720
[720]
ARGS 1
[] [720]
CALL Write	Write(720)
[] [720]
LOAD 0 dummyFormal	<load dummyFormal>
[] [720,720]
720
WRITE
[] [720,720]
RETURN
[720]
POP 3
[]

~~~
    


### Program Output Diff



~~~bash
0a1
> VERBOSE ON

~~~
    


## Fibonacci Run with Input 6 and VERBOSE OFF



### Program Output



~~~bash
Please enter an integer : 6
8

~~~
    


### Program Output Diff



~~~bash
Files exp_fib6.out and act_fib6.out are identical

~~~
    


## Fibonacci Run with Input 6 and VERBOSE ON



### Program Output



~~~bash
VERBOSE ON
GOTO start<<1>>
[]
LIT 0 x	int x
[0]
GOTO continue<<3>>
[0]
LIT 0 k	int k
[0,0]
LIT 5
[0,0,5]
STORE 0 x	x = 5
[5,0]
ARGS 0
[5,0] []
CALL Read	Read()
[5,0] []
Please enter an integer : 6
READ
[5,0] [6]
RETURN
[5,0,6]
ARGS 1
[5,0] [6]
CALL fib<<2>>	fib(6)
[5,0] [6]
LOAD 0 n	<load n>
[5,0] [6,6]
LIT 1
[5,0] [6,6,1]
BOP <=
[5,0] [6,0]
FALSEBRANCH else<<4>>
[5,0] [6]
LOAD 0 n	<load n>
[5,0] [6,6]
LIT 2
[5,0] [6,6,2]
BOP ==
[5,0] [6,0]
FALSEBRANCH else<<6>>
[5,0] [6]
LOAD 0 n	<load n>
[5,0] [6,6]
LIT 2
[5,0] [6,6,2]
BOP -
[5,0] [6,4]
ARGS 1
[5,0] [6] [4]
CALL fib<<2>>	fib(4)
[5,0] [6] [4]
LOAD 0 n	<load n>
[5,0] [6] [4,4]
LIT 1
[5,0] [6] [4,4,1]
BOP <=
[5,0] [6] [4,0]
FALSEBRANCH else<<4>>
[5,0] [6] [4]
LOAD 0 n	<load n>
[5,0] [6] [4,4]
LIT 2
[5,0] [6] [4,4,2]
BOP ==
[5,0] [6] [4,0]
FALSEBRANCH else<<6>>
[5,0] [6] [4]
LOAD 0 n	<load n>
[5,0] [6] [4,4]
LIT 2
[5,0] [6] [4,4,2]
BOP -
[5,0] [6] [4,2]
ARGS 1
[5,0] [6] [4] [2]
CALL fib<<2>>	fib(2)
[5,0] [6] [4] [2]
LOAD 0 n	<load n>
[5,0] [6] [4] [2,2]
LIT 1
[5,0] [6] [4] [2,2,1]
BOP <=
[5,0] [6] [4] [2,0]
FALSEBRANCH else<<4>>
[5,0] [6] [4] [2]
LOAD 0 n	<load n>
[5,0] [6] [4] [2,2]
LIT 2
[5,0] [6] [4] [2,2,2]
BOP ==
[5,0] [6] [4] [2,1]
FALSEBRANCH else<<6>>
[5,0] [6] [4] [2]
LIT 1
[5,0] [6] [4] [2,1]
RETURN fib<<2>>	EXIT fib:1
[5,0] [6] [4,1]
LOAD 0 n	<load n>
[5,0] [6] [4,1,4]
LIT 1
[5,0] [6] [4,1,4,1]
BOP -
[5,0] [6] [4,1,3]
ARGS 1
[5,0] [6] [4,1] [3]
CALL fib<<2>>	fib(3)
[5,0] [6] [4,1] [3]
LOAD 0 n	<load n>
[5,0] [6] [4,1] [3,3]
LIT 1
[5,0] [6] [4,1] [3,3,1]
BOP <=
[5,0] [6] [4,1] [3,0]
FALSEBRANCH else<<4>>
[5,0] [6] [4,1] [3]
LOAD 0 n	<load n>
[5,0] [6] [4,1] [3,3]
LIT 2
[5,0] [6] [4,1] [3,3,2]
BOP ==
[5,0] [6] [4,1] [3,0]
FALSEBRANCH else<<6>>
[5,0] [6] [4,1] [3]
LOAD 0 n	<load n>
[5,0] [6] [4,1] [3,3]
LIT 2
[5,0] [6] [4,1] [3,3,2]
BOP -
[5,0] [6] [4,1] [3,1]
ARGS 1
[5,0] [6] [4,1] [3] [1]
CALL fib<<2>>	fib(1)
[5,0] [6] [4,1] [3] [1]
LOAD 0 n	<load n>
[5,0] [6] [4,1] [3] [1,1]
LIT 1
[5,0] [6] [4,1] [3] [1,1,1]
BOP <=
[5,0] [6] [4,1] [3] [1,1]
FALSEBRANCH else<<4>>
[5,0] [6] [4,1] [3] [1]
LIT 1
[5,0] [6] [4,1] [3] [1,1]
RETURN fib<<2>>	EXIT fib:1
[5,0] [6] [4,1] [3,1]
LOAD 0 n	<load n>
[5,0] [6] [4,1] [3,1,3]
LIT 1
[5,0] [6] [4,1] [3,1,3,1]
BOP -
[5,0] [6] [4,1] [3,1,2]
ARGS 1
[5,0] [6] [4,1] [3,1] [2]
CALL fib<<2>>	fib(2)
[5,0] [6] [4,1] [3,1] [2]
LOAD 0 n	<load n>
[5,0] [6] [4,1] [3,1] [2,2]
LIT 1
[5,0] [6] [4,1] [3,1] [2,2,1]
BOP <=
[5,0] [6] [4,1] [3,1] [2,0]
FALSEBRANCH else<<4>>
[5,0] [6] [4,1] [3,1] [2]
LOAD 0 n	<load n>
[5,0] [6] [4,1] [3,1] [2,2]
LIT 2
[5,0] [6] [4,1] [3,1] [2,2,2]
BOP ==
[5,0] [6] [4,1] [3,1] [2,1]
FALSEBRANCH else<<6>>
[5,0] [6] [4,1] [3,1] [2]
LIT 1
[5,0] [6] [4,1] [3,1] [2,1]
RETURN fib<<2>>	EXIT fib:1
[5,0] [6] [4,1] [3,1,1]
BOP +
[5,0] [6] [4,1] [3,2]
RETURN fib<<2>>	EXIT fib:2
[5,0] [6] [4,1,2]
BOP +
[5,0] [6] [4,3]
RETURN fib<<2>>	EXIT fib:3
[5,0] [6,3]
LOAD 0 n	<load n>
[5,0] [6,3,6]
LIT 1
[5,0] [6,3,6,1]
BOP -
[5,0] [6,3,5]
ARGS 1
[5,0] [6,3] [5]
CALL fib<<2>>	fib(5)
[5,0] [6,3] [5]
LOAD 0 n	<load n>
[5,0] [6,3] [5,5]
LIT 1
[5,0] [6,3] [5,5,1]
BOP <=
[5,0] [6,3] [5,0]
FALSEBRANCH else<<4>>
[5,0] [6,3] [5]
LOAD 0 n	<load n>
[5,0] [6,3] [5,5]
LIT 2
[5,0] [6,3] [5,5,2]
BOP ==
[5,0] [6,3] [5,0]
FALSEBRANCH else<<6>>
[5,0] [6,3] [5]
LOAD 0 n	<load n>
[5,0] [6,3] [5,5]
LIT 2
[5,0] [6,3] [5,5,2]
BOP -
[5,0] [6,3] [5,3]
ARGS 1
[5,0] [6,3] [5] [3]
CALL fib<<2>>	fib(3)
[5,0] [6,3] [5] [3]
LOAD 0 n	<load n>
[5,0] [6,3] [5] [3,3]
LIT 1
[5,0] [6,3] [5] [3,3,1]
BOP <=
[5,0] [6,3] [5] [3,0]
FALSEBRANCH else<<4>>
[5,0] [6,3] [5] [3]
LOAD 0 n	<load n>
[5,0] [6,3] [5] [3,3]
LIT 2
[5,0] [6,3] [5] [3,3,2]
BOP ==
[5,0] [6,3] [5] [3,0]
FALSEBRANCH else<<6>>
[5,0] [6,3] [5] [3]
LOAD 0 n	<load n>
[5,0] [6,3] [5] [3,3]
LIT 2
[5,0] [6,3] [5] [3,3,2]
BOP -
[5,0] [6,3] [5] [3,1]
ARGS 1
[5,0] [6,3] [5] [3] [1]
CALL fib<<2>>	fib(1)
[5,0] [6,3] [5] [3] [1]
LOAD 0 n	<load n>
[5,0] [6,3] [5] [3] [1,1]
LIT 1
[5,0] [6,3] [5] [3] [1,1,1]
BOP <=
[5,0] [6,3] [5] [3] [1,1]
FALSEBRANCH else<<4>>
[5,0] [6,3] [5] [3] [1]
LIT 1
[5,0] [6,3] [5] [3] [1,1]
RETURN fib<<2>>	EXIT fib:1
[5,0] [6,3] [5] [3,1]
LOAD 0 n	<load n>
[5,0] [6,3] [5] [3,1,3]
LIT 1
[5,0] [6,3] [5] [3,1,3,1]
BOP -
[5,0] [6,3] [5] [3,1,2]
ARGS 1
[5,0] [6,3] [5] [3,1] [2]
CALL fib<<2>>	fib(2)
[5,0] [6,3] [5] [3,1] [2]
LOAD 0 n	<load n>
[5,0] [6,3] [5] [3,1] [2,2]
LIT 1
[5,0] [6,3] [5] [3,1] [2,2,1]
BOP <=
[5,0] [6,3] [5] [3,1] [2,0]
FALSEBRANCH else<<4>>
[5,0] [6,3] [5] [3,1] [2]
LOAD 0 n	<load n>
[5,0] [6,3] [5] [3,1] [2,2]
LIT 2
[5,0] [6,3] [5] [3,1] [2,2,2]
BOP ==
[5,0] [6,3] [5] [3,1] [2,1]
FALSEBRANCH else<<6>>
[5,0] [6,3] [5] [3,1] [2]
LIT 1
[5,0] [6,3] [5] [3,1] [2,1]
RETURN fib<<2>>	EXIT fib:1
[5,0] [6,3] [5] [3,1,1]
BOP +
[5,0] [6,3] [5] [3,2]
RETURN fib<<2>>	EXIT fib:2
[5,0] [6,3] [5,2]
LOAD 0 n	<load n>
[5,0] [6,3] [5,2,5]
LIT 1
[5,0] [6,3] [5,2,5,1]
BOP -
[5,0] [6,3] [5,2,4]
ARGS 1
[5,0] [6,3] [5,2] [4]
CALL fib<<2>>	fib(4)
[5,0] [6,3] [5,2] [4]
LOAD 0 n	<load n>
[5,0] [6,3] [5,2] [4,4]
LIT 1
[5,0] [6,3] [5,2] [4,4,1]
BOP <=
[5,0] [6,3] [5,2] [4,0]
FALSEBRANCH else<<4>>
[5,0] [6,3] [5,2] [4]
LOAD 0 n	<load n>
[5,0] [6,3] [5,2] [4,4]
LIT 2
[5,0] [6,3] [5,2] [4,4,2]
BOP ==
[5,0] [6,3] [5,2] [4,0]
FALSEBRANCH else<<6>>
[5,0] [6,3] [5,2] [4]
LOAD 0 n	<load n>
[5,0] [6,3] [5,2] [4,4]
LIT 2
[5,0] [6,3] [5,2] [4,4,2]
BOP -
[5,0] [6,3] [5,2] [4,2]
ARGS 1
[5,0] [6,3] [5,2] [4] [2]
CALL fib<<2>>	fib(2)
[5,0] [6,3] [5,2] [4] [2]
LOAD 0 n	<load n>
[5,0] [6,3] [5,2] [4] [2,2]
LIT 1
[5,0] [6,3] [5,2] [4] [2,2,1]
BOP <=
[5,0] [6,3] [5,2] [4] [2,0]
FALSEBRANCH else<<4>>
[5,0] [6,3] [5,2] [4] [2]
LOAD 0 n	<load n>
[5,0] [6,3] [5,2] [4] [2,2]
LIT 2
[5,0] [6,3] [5,2] [4] [2,2,2]
BOP ==
[5,0] [6,3] [5,2] [4] [2,1]
FALSEBRANCH else<<6>>
[5,0] [6,3] [5,2] [4] [2]
LIT 1
[5,0] [6,3] [5,2] [4] [2,1]
RETURN fib<<2>>	EXIT fib:1
[5,0] [6,3] [5,2] [4,1]
LOAD 0 n	<load n>
[5,0] [6,3] [5,2] [4,1,4]
LIT 1
[5,0] [6,3] [5,2] [4,1,4,1]
BOP -
[5,0] [6,3] [5,2] [4,1,3]
ARGS 1
[5,0] [6,3] [5,2] [4,1] [3]
CALL fib<<2>>	fib(3)
[5,0] [6,3] [5,2] [4,1] [3]
LOAD 0 n	<load n>
[5,0] [6,3] [5,2] [4,1] [3,3]
LIT 1
[5,0] [6,3] [5,2] [4,1] [3,3,1]
BOP <=
[5,0] [6,3] [5,2] [4,1] [3,0]
FALSEBRANCH else<<4>>
[5,0] [6,3] [5,2] [4,1] [3]
LOAD 0 n	<load n>
[5,0] [6,3] [5,2] [4,1] [3,3]
LIT 2
[5,0] [6,3] [5,2] [4,1] [3,3,2]
BOP ==
[5,0] [6,3] [5,2] [4,1] [3,0]
FALSEBRANCH else<<6>>
[5,0] [6,3] [5,2] [4,1] [3]
LOAD 0 n	<load n>
[5,0] [6,3] [5,2] [4,1] [3,3]
LIT 2
[5,0] [6,3] [5,2] [4,1] [3,3,2]
BOP -
[5,0] [6,3] [5,2] [4,1] [3,1]
ARGS 1
[5,0] [6,3] [5,2] [4,1] [3] [1]
CALL fib<<2>>	fib(1)
[5,0] [6,3] [5,2] [4,1] [3] [1]
LOAD 0 n	<load n>
[5,0] [6,3] [5,2] [4,1] [3] [1,1]
LIT 1
[5,0] [6,3] [5,2] [4,1] [3] [1,1,1]
BOP <=
[5,0] [6,3] [5,2] [4,1] [3] [1,1]
FALSEBRANCH else<<4>>
[5,0] [6,3] [5,2] [4,1] [3] [1]
LIT 1
[5,0] [6,3] [5,2] [4,1] [3] [1,1]
RETURN fib<<2>>	EXIT fib:1
[5,0] [6,3] [5,2] [4,1] [3,1]
LOAD 0 n	<load n>
[5,0] [6,3] [5,2] [4,1] [3,1,3]
LIT 1
[5,0] [6,3] [5,2] [4,1] [3,1,3,1]
BOP -
[5,0] [6,3] [5,2] [4,1] [3,1,2]
ARGS 1
[5,0] [6,3] [5,2] [4,1] [3,1] [2]
CALL fib<<2>>	fib(2)
[5,0] [6,3] [5,2] [4,1] [3,1] [2]
LOAD 0 n	<load n>
[5,0] [6,3] [5,2] [4,1] [3,1] [2,2]
LIT 1
[5,0] [6,3] [5,2] [4,1] [3,1] [2,2,1]
BOP <=
[5,0] [6,3] [5,2] [4,1] [3,1] [2,0]
FALSEBRANCH else<<4>>
[5,0] [6,3] [5,2] [4,1] [3,1] [2]
LOAD 0 n	<load n>
[5,0] [6,3] [5,2] [4,1] [3,1] [2,2]
LIT 2
[5,0] [6,3] [5,2] [4,1] [3,1] [2,2,2]
BOP ==
[5,0] [6,3] [5,2] [4,1] [3,1] [2,1]
FALSEBRANCH else<<6>>
[5,0] [6,3] [5,2] [4,1] [3,1] [2]
LIT 1
[5,0] [6,3] [5,2] [4,1] [3,1] [2,1]
RETURN fib<<2>>	EXIT fib:1
[5,0] [6,3] [5,2] [4,1] [3,1,1]
BOP +
[5,0] [6,3] [5,2] [4,1] [3,2]
RETURN fib<<2>>	EXIT fib:2
[5,0] [6,3] [5,2] [4,1,2]
BOP +
[5,0] [6,3] [5,2] [4,3]
RETURN fib<<2>>	EXIT fib:3
[5,0] [6,3] [5,2,3]
BOP +
[5,0] [6,3] [5,5]
RETURN fib<<2>>	EXIT fib:5
[5,0] [6,3,5]
BOP +
[5,0] [6,8]
RETURN fib<<2>>	EXIT fib:8
[5,0,8]
ARGS 1
[5,0] [8]
CALL Write	Write(8)
[5,0] [8]
LOAD 0 dummyFormal	<load dummyFormal>
[5,0] [8,8]
8
WRITE
[5,0] [8,8]
RETURN
[5,0,8]
STORE 1 k	k = 8
[5,8]
LIT 0 x	int x
[5,8,0]
LIT 7
[5,8,0,7]
STORE 2 x	x = 7
[5,8,7]
LIT 8
[5,8,7,8]
STORE 2 x	x = 8
[5,8,8]
POP 1
[5,8]
POP 2
[]

~~~
    


### Program Output Diff



~~~bash
0a1
> VERBOSE ON

~~~
    


## Function Args Test and and VERBOSE OFF



### Program Output



~~~bash
0
1
0
1
2
0
1
2
3

~~~
    


### Program Output Diff



~~~bash
Files exp_functest.out and act_functest.out are identical

~~~
    


## Function Args Test and VERBOSE ON



### Program Output



~~~bash
VERBOSE ON
GOTO CONTINUE<<1>>
[]
GOTO CONTINUE<<2>>
[]
GOTO CONTINUE<<3>>
[]
GOTO CONTINUE<<4>>
[]
LIT 0
[0]
LIT 1
[0,1]
ARGS 2
[] [0,1]
CALL doublePrint<<1>>	doublePrint(0,1)
[] [0,1]
LOAD 0
[] [0,1,0]
0
WRITE
[] [0,1,0]
POP 1
[] [0,1]
LOAD 1
[] [0,1,1]
1
WRITE
[] [0,1,1]
POP 1
[] [0,1]
RETURN doublePrint<<1>>	EXIT doublePrint:1
[1]
POP 1
[]
LIT 0
[0]
LIT 1
[0,1]
LIT 2
[0,1,2]
ARGS 3
[] [0,1,2]
CALL triplePrint<<1>>	triplePrint(0,1,2)
[] [0,1,2]
LOAD 0
[] [0,1,2,0]
0
WRITE
[] [0,1,2,0]
POP 1
[] [0,1,2]
LOAD 1
[] [0,1,2,1]
1
WRITE
[] [0,1,2,1]
POP 1
[] [0,1,2]
LOAD 2
[] [0,1,2,2]
2
WRITE
[] [0,1,2,2]
POP 2
[] [0,1]
RETURN triplePrint<<1>>	EXIT triplePrint:1
[1]
POP 1
[]
LIT 0
[0]
LIT 1
[0,1]
LIT 2
[0,1,2]
LIT 3
[0,1,2,3]
ARGS 4
[] [0,1,2,3]
CALL quadruplePrint<<1>>	quadruplePrint(0,1,2,3)
[] [0,1,2,3]
LOAD 0
[] [0,1,2,3,0]
0
WRITE
[] [0,1,2,3,0]
POP 1
[] [0,1,2,3]
LOAD 1
[] [0,1,2,3,1]
1
WRITE
[] [0,1,2,3,1]
POP 1
[] [0,1,2,3]
LOAD 2
[] [0,1,2,3,2]
2
WRITE
[] [0,1,2,3,2]
POP 1
[] [0,1,2,3]
LOAD 3
[] [0,1,2,3,3]
3
WRITE
[] [0,1,2,3,3]
POP 1
[] [0,1,2,3]
RETURN quadruplePrint<<1>>	EXIT quadruplePrint:3
[3]
POP 66
[]

~~~
    


### Program Output Diff



~~~bash
0a1
> VERBOSE ON

~~~
    


## Heap Print Array Test and VERBOSE OFF



### Program Output



~~~bash
 : 7
5
6
7

~~~
    


### Program Output Diff



~~~bash
1,3c1
< Please enter an integer: 5
< Please enter an integer: 6
< Please enter an integer: 7
---
>  : 7

~~~
    


## Heap Print Array Test and VERBOSE ON



### Program Output



~~~bash
 : 7
READ
[1,1,2] [7]
RETURN
[1,1,2,7]
HSTORE
[1]
LOAD 0 arr	<load arr>
[1,1]
LIT 0
[1,1,0]
HLOAD
[1,5]
ARGS 1
[1] [5]
CALL Write	Write(5)
[1] [5]
LOAD 0 dummyFormal	<load dummyFormal>
[1] [5,5]
5
WRITE
[1] [5,5]
RETURN
[1,5]
POP 1
[1]
LOAD 0 arr	<load arr>
[1,1]
LIT 1
[1,1,1]
HLOAD
[1,6]
ARGS 1
[1] [6]
CALL Write	Write(6)
[1] [6]
LOAD 0 dummyFormal	<load dummyFormal>
[1] [6,6]
6
WRITE
[1] [6,6]
RETURN
[1,6]
POP 1
[1]
LOAD 0 arr	<load arr>
[1,1]
LIT 2
[1,1,2]
HLOAD
[1,7]
ARGS 1
[1] [7]
CALL Write	Write(7)
[1] [7]
LOAD 0 dummyFormal	<load dummyFormal>
[1] [7,7]
7
WRITE
[1] [7,7]
RETURN
[1,7]
POP 1
[1]
LOAD 0 arr	<load arr>
[1,1]
FREE
[1]
POP 1
[]

~~~
    


### Program Output Diff



~~~bash
1,47c1
< GOTO start<<1>>
< [] 
< LIT 0 arr		int arr
< [0] 
< NEW 3
< [0, 1] 
< STORE 0 arr	arr = 1
< [1] 
< LOAD 0 arr	<load arr>
< [1, 1] 
< LIT 0
< [1, 1, 0] 
< ARGS 0
< [1, 1, 0] [] 
< CALL Read	Read()
< [1, 1, 0] [] 
< Please enter an integer: 5
< READ
< [1, 1, 0] [5] 
< RETURN
< [1, 1, 0, 5] 
< HSTORE
< [1] 
< LOAD 0 arr	<load arr>
< [1, 1] 
< LIT 1
< [1, 1, 1] 
< ARGS 0
< [1, 1, 1] [] 
< CALL Read	Read()
< [1, 1, 1] [] 
< Please enter an integer: 6
< READ
< [1, 1, 1] [6] 
< RETURN
< [1, 1, 1, 6] 
< HSTORE
< [1] 
< LOAD 0 arr	<load arr>
< [1, 1] 
< LIT 2
< [1, 1, 2] 
< ARGS 0
< [1, 1, 2] [] 
< CALL Read	Read()
< [1, 1, 2] [] 
< Please enter an integer: 7
---
>  : 7

~~~
    


## Heap Sum Array Test and VERBOSE OFF



### Program Output



~~~bash
150

~~~
    


### Program Output Diff



~~~bash
Files exp_heapsum.out and act_heapsum.out are identical

~~~
    


## Heap Sum Array Test and VERBOSE ON



### Program Output



~~~bash
VERBOSE ON
GOTO start<<1>>
[]
LIT 0 arr	int arr
[0]
NEW 5
[0,1]
STORE 0 arr	arr = 1
[1]
LOAD 0 arr	<load arr>
[1,1]
LIT 0
[1,1,0]
LIT 10
[1,1,0,10]
HSTORE
[1]
LOAD 0 arr	<load arr>
[1,1]
LIT 1
[1,1,1]
LIT 20
[1,1,1,20]
HSTORE
[1]
LOAD 0 arr	<load arr>
[1,1]
LIT 2
[1,1,2]
LIT 30
[1,1,2,30]
HSTORE
[1]
LOAD 0 arr	<load arr>
[1,1]
LIT 3
[1,1,3]
LIT 40
[1,1,3,40]
HSTORE
[1]
LOAD 0 arr	<load arr>
[1,1]
LIT 4
[1,1,4]
LIT 50
[1,1,4,50]
HSTORE
[1]
LIT 0 sum	int sum
[1,0]
LOAD 0 arr	<load arr>
[1,0,1]
LIT 0
[1,0,1,0]
HLOAD
[1,0,10]
LOAD 0 arr	<load arr>
[1,0,10,1]
LIT 1
[1,0,10,1,1]
HLOAD
[1,0,10,20]
BOP +
[1,0,30]
LOAD 0 arr	<load arr>
[1,0,30,1]
LIT 2
[1,0,30,1,2]
HLOAD
[1,0,30,30]
BOP +
[1,0,60]
LOAD 0 arr	<load arr>
[1,0,60,1]
LIT 3
[1,0,60,1,3]
HLOAD
[1,0,60,40]
BOP +
[1,0,100]
LOAD 0 arr	<load arr>
[1,0,100,1]
LIT 4
[1,0,100,1,4]
HLOAD
[1,0,100,50]
BOP +
[1,0,150]
STORE 1 sum	sum = 150
[1,150]
LOAD 1 sum	<load sum>
[1,150,150]
ARGS 1
[1,150] [150]
CALL Write	Write(150)
[1,150] [150]
LOAD 0 dummyFormal	<load dummyFormal>
[1,150] [150,150]
150
WRITE
[1,150] [150,150]
RETURN
[1,150,150]
LOAD 0 arr	<load arr>
[1,150,150,1]
FREE
[1,150,150]
POP 3
[]

~~~
    


### Program Output Diff



~~~bash
0a1
> VERBOSE ON

~~~
    
