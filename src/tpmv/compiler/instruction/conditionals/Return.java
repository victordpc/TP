package tpmv.compiler.instruction.conditionals;

import bytecode.Halt;
import elements.Compiler;
import elements.LexicalParser;
import exceptions.ArrayException;
import tpmv.compiler.instruction.Instruction;

public class Return implements Instruction{

    public Return() {}

    @Override
    public Instruction lexParse(String[] words, LexicalParser lexParser) {
        if (words.length != 1 || !words[0].equalsIgnoreCase("RETURN")) {
            return null;
        }else {
            lexParser.increaseProgramCounter();
            return new Return();
        }
    }

    @Override
    public void compile(Compiler compiler) throws ArrayException {
        compiler.addByteCode(new Halt());
    }
}
