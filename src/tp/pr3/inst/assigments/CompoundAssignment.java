package tp.pr3.inst.assigments;

import tp.pr3.bc.ByteCode;
import tp.pr3.bc.arithmetics.*;
import tp.pr3.bc.Store;
import tp.pr3.elements.Compiler;
import tp.pr3.elements.LexicalParser;
import tp.pr3.exceptions.ArrayException;
import tp.pr3.inst.Instruction;

public class CompoundAssignment implements Instruction {

    private String varName;
    private String operator;
    private Term term1;
    private Term term2;

    public CompoundAssignment(){}

    public CompoundAssignment(String varName, String operator, Term term1, Term term2) {
        this.varName = varName;
        this.operator = operator;
        this.term1 = term1;
        this.term2 = term2;
    }

    @Override
    public Instruction lexParse(String[] words, LexicalParser lexParser) {
        Variable variable = (Variable)new Variable().parse(words[0]);
        if (words.length != 5 || !words[1].equals("=") || variable == null) {
            return null;
        }else {
            Term term1 = TermParser.parse(words[2]);
            Term term2 = TermParser.parse(words[4]);
            String operator = words[3];
            if (term1 != null && term2 != null && ArithmeticHelper.isAValidOperator(operator)) {
                lexParser.increaseProgramCounter();
                return new CompoundAssignment(variable.getVarName(), operator, term1, term2);
            }
        }
        return null;
    }

    @Override
    public void compile(Compiler compiler) throws ArrayException {
        ByteCode term1ByteCode = this.term1.compile(compiler);
        ByteCode term2ByteCode = this.term2.compile(compiler);
        compiler.addByteCode(term1ByteCode);
        compiler.addByteCode(term2ByteCode);

        Arithmetics arimetics = null;
        switch (operator) {
            case "+":
                arimetics = new Add();
                break;
            case "-":
                arimetics = new Sub();
                break;
            case "*":
                arimetics = new Mul();
                break;
            case "/":
                arimetics = new Div();
                break;
        }
        compiler.addByteCode(arimetics);
        int varIndex = compiler.indexOf(varName);
        Store storeByteCode = new Store(varIndex);
        compiler.addByteCode(storeByteCode);
    }
}
