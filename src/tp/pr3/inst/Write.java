package tp.pr3.inst;

import tp.pr3.bc.ByteCode;
import tp.pr3.bc.Out;
import tp.pr3.bc.Load;
import tp.pr3.elements.Compiler;
import tp.pr3.elements.LexicalParser;
import tp.pr3.exceptions.ArrayException;

public class Write implements Instruction {
    private String varName;

    public Write() {}

    public Write(String varName){
        this.varName = varName;
    }

    @Override
    public Instruction lexParse(String[] words, LexicalParser lexParser) {
        if (words.length != 2) {
            return null;
        }else {
            lexParser.increaseProgramCounter();
            return new Write(words[1]);
        }
    }

    @Override
    public void compile(Compiler compiler) throws ArrayException {
        int varIndex = compiler.indexOf(varName);
        ByteCode byteCode = byteCode = new Load(varIndex);
        Out outByteCode = new Out();
        compiler.addByteCode(byteCode);
        compiler.addByteCode(outByteCode);
    }
}
