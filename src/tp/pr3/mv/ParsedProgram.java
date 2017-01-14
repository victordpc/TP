package tp.pr3.mv;

import tp.pr3.exceptions.ArrayException;
import tp.pr3.inst.Instruction;

//Almacena instruction
public class ParsedProgram {

    private int programCounter;
    private Instruction[] pProgram;
    private static final int EXTEND_VALUE = 1000;

    public ParsedProgram() {
        this.pProgram = new Instruction[EXTEND_VALUE];
    }

    public void addInstruction(Instruction instruction) throws ArrayException {
        if (programCounter < 1000) {
            pProgram[programCounter++] = instruction;
        }else {
            throw new ArrayException("Excepcion-ArrayException se ha superado el tamaño máximo de program;" +
                    " por favor refactorice su programa para que no exceda las 1000 instrucciones");
        }
    }

    public Instruction getInstruction(int i ) {
        return pProgram[i];
    }

    @Override
    public String toString() {
        String sourceProgramString = "";
        int i = 0;
        while (i < programCounter) {
            sourceProgramString += pProgram[i].toString() + System.getProperty("line.separator");
            i++;
        }
        return sourceProgramString;
    }

    public int getNumeroInstrucciones() {
        return programCounter;
    }
}
