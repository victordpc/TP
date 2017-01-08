package tpmv.compiler.instruction.conditionals;

import bytecode.oneparameter.conditional.ConditionalJump;
import elements.LexicalParser;
import exceptions.ArrayException;
import tpmv.compiler.instruction.assigments.Term;
import elements.Compiler;

public abstract class Condition {

    protected Term term1;
    protected Term term2;
    protected ConditionalJump conditionalJump; //Para la compilación

    public Condition(){}

    public Condition(Term term1, Term term2) {
        this.term1 = term1;
        this.term2 = term2;
    }

    public abstract Condition parse(String t1, String op, String t2, LexicalParser parser);
    public abstract void compile(Compiler compiler) throws ArrayException;
    protected abstract ConditionalJump compileOp();
    public abstract boolean compare(int par1, int par2);

}
