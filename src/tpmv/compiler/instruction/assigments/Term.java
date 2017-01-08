package tpmv.compiler.instruction.assigments;

import bytecode.ByteCode;
import elements.Compiler;

public interface Term {
    Term parse(String term);
    ByteCode compile(Compiler compiler);
}
