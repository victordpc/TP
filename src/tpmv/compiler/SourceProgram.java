package tpmv.compiler;

import exceptions.ArrayException;

import java.io.*;

public class SourceProgram {

    private static final int EXTEND_VALUE = 1000;
    private int nextProgramPosition = 0;
    private final String[] sourceProgram;

    public SourceProgram() {
        this.sourceProgram = new String[EXTEND_VALUE];
    }

    public boolean readFile(String fileName) throws FileNotFoundException, ArrayException {
        boolean success = true;
        try {
            FileInputStream fstream = new FileInputStream(fileName);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fstream));

            String nextLine;
            boolean stop = false;
            //Read File Line By Line
            while (((nextLine = reader.readLine()) != null) && !stop)   {
                stop = addInstruction(nextLine);
            }
            //Close the input stream
            reader.close();
        }catch (IOException exception){
            System.out.println("IOException al intentar leer el archivo del programa: " + exception.getMessage());
            success = false;
        }
        return success;
    }

    public boolean addInstruction(String instruction) throws ArrayException {
        if (this.nextProgramPosition < EXTEND_VALUE) {
            this.sourceProgram[this.nextProgramPosition++] = instruction;
            return false;
        } else {
            throw new ArrayException("Excepcion-ArrayException se ha superado el tamaño máximo de program;" +
                    " por favor refactorice su programa para que no exceda las 1000 instrucciones");
        }
    }

    public String getInstruction(int position) {
        return sourceProgram[position];
    }

    public int getNumeroInstrucciones() {
        return nextProgramPosition;
    }

    @Override
    public String toString() {
        String sourceProgramString = "Programa fuente almacenado: " + System.getProperty("line.separator");
        int i = 0;
        while (i < nextProgramPosition) {
            sourceProgramString += "[" + i + "]: " + sourceProgram[i] + System.getProperty("line.separator");
            i++;
        }
        return sourceProgramString;
    }
}
