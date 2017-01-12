package tp.pr3.elements;

import tp.pr3.exceptions.ArrayException;
import tp.pr3.exceptions.LexicalAnalysisException;
import tp.pr3.inst.Instruction;
import tp.pr3.inst.InstructionParser;
import tp.pr3.mv.ParsedProgram;
import tp.pr3.mv.SourceProgram;

/**
 * Clase que representa el traductor léxico de la máquina virtual
 */
public class LexicalParser {
	private SourceProgram sProgram;
	private int programCounter;

	/**
	 * Constructor de la clase
	 */
	public LexicalParser() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * IncreaseProgramCounter
	 */
	public void increaseProgramCounter() {
		this.programCounter++;
	}

	/**
	 * Initialize
	 * 
	 * @param sourceProgram
	 *            código fuente del programa a cargar
	 */
	public void initialize(SourceProgram sourceProgram) {
		this.sProgram = sourceProgram;
	}

	/**
	 * @param pProgram
	 * @param stopKey
	 * @throws LexicalAnalysisException
	 *             Detecta errores que se pueden producir en el análisis
	 *             léxico, por incorreciones en el programa fuente.
	 */
	public void lexicalParser(ParsedProgram pProgram, String stopKey) throws LexicalAnalysisException {
		boolean stop = false;
		try {
			while (programCounter < sProgram.getSize() && !stop) {

				String line = sProgram.getInstr(programCounter);

				if (line.equalsIgnoreCase(stopKey))
					stop = true;
				else {
					Instruction instruction = InstructionParser.parse(line.split(" "), this);
					// Si instruction es null
					if (instruction == null)
						throw new LexicalAnalysisException("Error en la traducción léxica del programa");

					pProgram.addInst(instruction);
					// Aumentar programCounter
					this.programCounter++;
				}
			}
		} catch (ArrayException e) {
			throw new LexicalAnalysisException("Error en la traducción léxica del programa");
		}

	}
}
