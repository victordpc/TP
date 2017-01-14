package tp.pr3.inst;

import tp.pr3.elements.Compiler;
import tp.pr3.elements.LexicalParser;
import tp.pr3.exceptions.ArrayException;

public interface Instruction {
    Instruction lexParse(String[] words, LexicalParser lexParser);
    void compile(Compiler compiler) throws ArrayException;
}
