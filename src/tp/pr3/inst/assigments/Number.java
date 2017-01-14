package tp.pr3.inst.assigments;

import tp.pr3.bc.ByteCode;
import tp.pr3.bc.Push;
import tp.pr3.elements.Compiler;

public class Number implements Term {

    private int value;

    public Number() {
    }

    public Number(int value) {
        this.value = value;
    }

    @Override
    public Term parse(String term) {
        try {
            int value = Integer.parseInt(term);
            return new Number(value);
        } catch (NumberFormatException exception) {
            return null;
        }
    }

    @Override
    public ByteCode compile(Compiler compiler) {
        return new Push(value);
    }

    public String toString() {
        return Integer.toString(this.value);
    }
}
