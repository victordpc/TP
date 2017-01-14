package tp.pr3.mv;

import tp.pr3.exceptions.ArrayException;

import java.io.*;
import java.util.Scanner;

public class SourceProgram {

    private static final int EXTEND_VALUE = 1000;
    private int nextProgramPosition = 0;
    private final String[] sourceProgram;

    public SourceProgram() {
        this.sourceProgram = new String[EXTEND_VALUE];
    }

    public boolean readFile(String fileName) throws FileNotFoundException, ArrayException {
        boolean success = true;
        nextProgramPosition = 0;
        try {
            Scanner scanner = new Scanner(new File(fileName));
            boolean stop = false;
            //Read File Line By Line
            while (scanner.hasNextLine() && !stop)   {
                stop = addInstruction(scanner.nextLine());
            }
            scanner.close();
        }catch (IOException exception){
            throw new FileNotFoundException("Excepcion: Fichero no Encontrado...");
//            System.out.println("Excepcion: Fichero no Encontrado...");
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
        int lastSpaceCount = 0;
        String space = "";
        while (i < nextProgramPosition) {
            if (sourceProgram[i].contains("endif") || sourceProgram[i].contains("endwhile")) {
                int index = 0;
                lastSpaceCount -= 3;
                space = "";
                while (index < lastSpaceCount) {
                    space += " ";
                    index++;
                }
            }
            sourceProgramString +=  i +": " + space + sourceProgram[i] + System.getProperty("line.separator");
            if ((sourceProgram[i].contains("if") || sourceProgram[i].contains("while"))
                    && !(sourceProgram[i].contains("endif") || sourceProgram[i].contains("endwhile"))) {
                int index = 0;
                while (index < 3) {
                    space += " ";
                    index++;
                }
                lastSpaceCount += 3;
            }
            i++;
        }
        return sourceProgramString;
    }
}
