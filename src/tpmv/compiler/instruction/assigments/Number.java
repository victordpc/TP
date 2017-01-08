package tpmv.compiler.instruction.assigments;

import bytecode.ByteCode;
import bytecode.oneparameter.Push;
import elements.Compiler;

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
