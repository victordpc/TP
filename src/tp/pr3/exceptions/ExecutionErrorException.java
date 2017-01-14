package tp.pr3.exceptions;

public class ExecutionErrorException extends Exception {
    private String instruction;

    public ExecutionErrorException(String instr) {

        super(instr);
    }

    @Override
    public String toString() {
        return " ExecutionErrorException  ";
    }

}
