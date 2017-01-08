package tpmv.compiler.instruction.conditionals;

import bytecode.ByteCode;
import bytecode.Out;
import bytecode.oneparameter.Load;
import elements.Compiler;
import elements.LexicalParser;
import exceptions.ArrayException;
import tpmv.compiler.instruction.Instruction;

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
