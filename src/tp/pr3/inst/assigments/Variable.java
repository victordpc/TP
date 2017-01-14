package tp.pr3.inst.assigments;

import tp.pr3.bc.ByteCode;
import tp.pr3.bc.Load;
import tp.pr3.elements.Compiler;

public class Variable implements Term {

    private String varName;

    public Variable(){
        super();
    }

    public Variable(String term){
        this.varName = term;
    }

    @Override
    public Term parse(String term) {
        if (term.length() != 1){
            return null;
        } else{
            char name = term.charAt(0);
            if ('a' <= name && name <= 'z'){
                return new Variable(term);
            } else{
                return null;
            }
        }
    }

    public String getVarName() {
        return varName;
    }

    @Override
    public ByteCode compile(Compiler compiler) {
        int varIndex = compiler.indexOf(varName);
        return new Load(varIndex);
    }

    public String toString(){
        return this.varName;
    }
}
