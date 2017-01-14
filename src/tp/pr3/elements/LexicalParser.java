package tp.pr3.elements;

import tp.pr3.exceptions.ArrayException;
import tp.pr3.exceptions.LexicalAnalysisException;
import tp.pr3.mv.ParsedProgram;
import tp.pr3.mv.SourceProgram;
import tp.pr3.inst.Instruction;
import tp.pr3.inst.InstructionParser;

public class LexicalParser {

    private SourceProgram sProgram;
    private int programCounter;

    public LexicalParser(SourceProgram sProgram) {
        this.sProgram = sProgram;
        programCounter = 0;
    }

    public void initialize() {
        this.programCounter = 0;
    }

    public void lexicalParser(ParsedProgram pProgram, String stopKey) throws LexicalAnalysisException {
        boolean stop = false;
        while (this.programCounter < sProgram.getNumeroInstrucciones() && !stop) {
            String instr = sProgram.getInstruction(this.programCounter);
            if (instr.equalsIgnoreCase(stopKey)) {
                stop = true;
            } else {
                Instruction instruction = InstructionParser.parse(instr, this); //Añadir instrucción a pProgram
                if (instruction != null) {
                    try {
                        pProgram.addInstruction(instruction);
                    } catch (ArrayException e) {
                        throw new LexicalAnalysisException(e.getMessage());
                    }
                } else {
                    throw new LexicalAnalysisException("Excepcion en la ejecucion del parseo del programa, no se ha " +
                            "podido parsear correctamente la instrucción " + instr + " En la posición " + this.programCounter
                            + System.getProperty("line.separator"));
                }
            }
        }

        if (stop == false) {
            throw new LexicalAnalysisException("Excepcion en la ejecucion del parseo del programa, falta el comando " + stopKey
                    + System.getProperty("line.separator"));
        }
    }

    public void increaseProgramCounter() {
        this.programCounter++;
    }

    @Override
    public String toString() {
        return "Resultado de análisis léxico: " + sProgram.toString()
                + System.getProperty("line.separator") + " Program counter: " + this.programCounter;
    }
}
