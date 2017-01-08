package tpmv.compiler.instruction;

import elements.Compiler;
import elements.LexicalParser;
import exceptions.ArrayException;

public interface Instruction {
    Instruction lexParse(String[] words, LexicalParser lexParser);
    void compile(Compiler compiler) throws ArrayException;
}
