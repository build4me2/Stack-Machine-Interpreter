# CSC 413 - Project Two - The Interpreter

## Student Name  : Manisha Chand 

## Student ID    : 924844476

## Student Email : mchand@sfsu.edu


## About

A stack-based virtual machine that runs compiled bytecode (`.x.cod` files) for the
mock language X. It loads the bytecode, resolves jump labels to instruction addresses,
and executes the program through a virtual machine that owns the runtime
stack and heap. Supports recursion, dynamic heap memory, and a VERBOSE trace mode.

## Development Environment

- Java: OpenJDK 24 (Temurin); require
- IDE: IntelliJ IDEA
- OS: Linux
- Version Control: Git / GitHub

## Build (from the repository root)

    mkdir -p build
    find interpreter -name "*.java" >
    javac -d build @sources.txt

## Run

    java -cp build interpreter.Interpreter factorial.x.cod

Replace `factorial.x.cod` with any provided program (`fib.x.cod heapSumArray.x.cod,
heapPrintArray.x.cod). Programs that use READ will prompt for integer input. To see the
VERBOSE trace, the .cod file needs a VERBOSE ON line.

## Documentation

Full project documentation (PDF) is in the documentation folder.
