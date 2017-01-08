package exceptions;

public class BadFormatByteCodeException extends Exception {
    public BadFormatByteCodeException(String instr) {
        super(instr);
    }
}
