package tp.pr3.inst;

import tp.pr3.bc.Halt;
import tp.pr3.elements.Compiler;
import tp.pr3.elements.LexicalParser;
import tp.pr3.exceptions.ArrayException;

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
