package tp.pr3.exceptions;

public class DivByZeroException extends ExecutionErrorException {

    public DivByZeroException(String instr) {
        super(instr);
    }

}
