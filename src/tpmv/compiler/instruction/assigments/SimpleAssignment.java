package tpmv.compiler.instruction.assigments;

import bytecode.ByteCode;
import bytecode.oneparameter.Store;
import command.CommandParser;
import elements.Compiler;
import elements.LexicalParser;
import exceptions.ArrayException;
import tpmv.compiler.instruction.Instruction;

public class SimpleAssignment implements Instruction {

    private String varName;
    private Term term;

    public SimpleAssignment() {
    }

    public SimpleAssignment(String varName, Term term) {
        this.varName = varName;
        this.term = term;
    }

    @Override
    public Instruction lexParse(String[] words, LexicalParser lexParser) {
        Variable variableParser = new Variable();
        Variable variable = (Variable) TermParser.parse(words[0]);
        if (words.length != 3 || variable == null || !words[1].equalsIgnoreCase("=")) {
            return null;
        } else {
            varName = variable.getVarName();
            term = TermParser.parse(words[2]);
            lexParser.increaseProgramCounter();
            return new SimpleAssignment(varName, term);
        }
    }

    @Override
    public void compile(Compiler compiler) throws ArrayException {
        ByteCode termByteCode = this.term.compile(compiler);
        compiler.addByteCode(termByteCode);
        int varIndex = compiler.indexOf(varName);
        Store storeByteCode = new Store(varIndex);
        compiler.addByteCode(storeByteCode);
    }
}
