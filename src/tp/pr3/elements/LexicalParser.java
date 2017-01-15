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
	private int programCounter = 0;
	private SourceProgram sProgram = null;

	/**
	 * Constructor de la clase
	 */
	public LexicalParser() {
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
		this.programCounter = 0;
	}

	/**
	 * @param pProgram
	 *            programa donde agregar el resultado del parseo
	 * @param stopKey
	 *            clave para parar el parseo
	 * @throws LexicalAnalysisException
	 *             Detecta errores que se pueden producir en el análisis
	 *             léxico, por incorreciones en el programa fuente.
	 */
	public void lexicalParser(ParsedProgram pProgram, String stopKey) throws LexicalAnalysisException {
		boolean stop = false;
		try {
			if (sProgram.getSize() == 0)
				throw new LexicalAnalysisException("El programa fuente no tiene elementos");

			while (this.programCounter < sProgram.getSize() && !stop) {
				String line = sProgram.getInstr(programCounter).trim();
				if (line.equalsIgnoreCase(stopKey))
					stop = true;
				else {
					Instruction instruction = InstructionParser.parse(line.split(" +"), this);
					if (instruction == null)

						throw new LexicalAnalysisException("Error en la traducción léxica del programa en la línea "
								+ this.programCounter + ": " + line);

					pProgram.addInst(instruction);
				}
			}
			if (!stop) {
				throw new LexicalAnalysisException(
						"Palabra clave [" + stopKey + "] no encontrada en el programa fuente");
			}
		} catch (ArrayException e) {
			throw new LexicalAnalysisException("Se ha llenado el espacio reservado para el Programa Parseado");
		}

	}
}
