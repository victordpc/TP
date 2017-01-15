package tp.pr3.inst;

import tp.pr3.elements.LexicalParser;
import tp.pr3.inst.assignments.CompoundAssignment;
import tp.pr3.inst.assignments.SimpleAssignment;
import tp.pr3.inst.conditionals.IfThen;
import tp.pr3.inst.conditionals.While;

/**
 * Clase que se encarga de convertir textos en instrucciones
 */
public class InstructionParser {
	private final static Instruction[] instructions = { new IfThen(), new Write(), new Return(), new While(),
			new SimpleAssignment(), new CompoundAssignment() };

	/**
	 * Convierte un texto a un objeto de tipo <code>Instruction</code>.
	 * 
	 * @param linea
	 *            cadena de texto.
	 * @param lpar
	 *            lexical parser utilizado
	 * @return <code>Instruction</code> correspondiente al texto, si es
	 *         incorrecto devuelve <code>null</code>.
	 */
	public static Instruction parse(String[] linea, LexicalParser lpar) {
		for (Instruction ins : instructions) {
			Instruction instructionParsed = ins.lexParse(linea, lpar);

			if (instructionParsed != null) {
				// lpar.increaseProgramCounter();
				return instructionParsed;
			}
		}
		return null;
	}

	/**
	 * Constructor de la clase
	 */
	public InstructionParser() {
	}

}
