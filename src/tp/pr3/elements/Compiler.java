package tp.pr3.elements;

import tp.pr3.bc.ByteCode;
import tp.pr3.mv.ByteCodeProgram;
import tp.pr3.exceptions.ArrayException;
import tp.pr3.mv.ParsedProgram;
import tp.pr3.inst.Instruction;

public class Compiler {

    private ByteCodeProgram bytecodeProgram;
    private String[] varTable;
    private int numVars;
    private final int REDIM_SIZE = 1000;

    public Compiler() {
        varTable = new String[REDIM_SIZE];
    }

    public void initialize(ByteCodeProgram bcProgram) {
        this.numVars = 0;
        this.bytecodeProgram = bcProgram;
    }

    //Throws
    public void compile(ParsedProgram pProgram) throws ArrayException {
        int i = 0;
        while (i < pProgram.getNumeroInstrucciones()) {
            Instruction instr = pProgram.getInstruction(i);
            instr.compile(this);
            i++;
        }
    }

    public int getCurrentNumberOfByteCodes() {
        return bytecodeProgram.getLength();
    }

    public int indexOf(String varName) {
        boolean stop = false;
        int i = 0;
        int index = -1;
        while (i < numVars && !stop) {
            if (varName.equalsIgnoreCase(varTable[i])) {
                index = i;
                stop = true;
            }
            i++;
        }
        if (index == -1) {
            index = numVars;
            varTable[index] = varName;
            numVars++;
        }
        return index;
    }

    public void addByteCode(ByteCode bc) throws ArrayException {
        if (bc != null) {
            bytecodeProgram.addByteCode(bc);
        }else{
            System.out.println("Atención error añadiendo bytecode en la clase Compiler");
        }
    }
}
