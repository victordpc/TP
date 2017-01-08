package exceptions;

public class DivByZeroException extends ExecutionErrorException {

    private String instruction;

    public DivByZeroException(String instr) {
        super(instr);
    }

    @Override
    public String toString() {
        return " ExecutionErrorException en la instrucción: " + this.instruction;
    }
}
