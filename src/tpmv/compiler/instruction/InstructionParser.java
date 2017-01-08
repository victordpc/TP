package tpmv.compiler.instruction;

import elements.LexicalParser;
import tpmv.compiler.instruction.assigments.CompoundAssignment;
import tpmv.compiler.instruction.assigments.SimpleAssignment;
import tpmv.compiler.instruction.conditionals.IfThen;
import tpmv.compiler.instruction.conditionals.Return;
import tpmv.compiler.instruction.conditionals.While;
import tpmv.compiler.instruction.conditionals.Write;

// Al igual que para los comandos o bytecodes, hace falta la clase InstructionParser, que se implementa de forma similar.
public class InstructionParser {

    private final static Instruction[] instructions = {new SimpleAssignment(), new CompoundAssignment(),
            new Write(), new Return(), new While(), new IfThen()};

    /**
     * Convierte un texto a un objeto de tipo <code>instruction</code>.
     *
     * @param linea         cadena de texto
     * @param lexicalParser el lexicalParser
     * @return <code>instruction</code> correspondiente al texto, si es incorrecto
     * devuelve <code>null</code>
     */
    public static Instruction parse(String linea, LexicalParser lexicalParser) {
        String[] instructionArray = linea.split(" ");
        for (Instruction instructionPaser : instructions) {
            Instruction instruction = instructionPaser.lexParse(instructionArray, lexicalParser);
            if (instruction != null) {
                return instruction;
            }
        }
        return null;
    }
}
