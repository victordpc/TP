package tp.pr3.mv;

import tp.pr3.exceptions.ArrayException;
import tp.pr3.inst.Instruction;

/**
 * Clase que representa un programa parseado
 */
public class ParsedProgram {

	private static final int EXTEND_VALUE = 1000;
	private int nextProgramPosition = 0;
	private final Instruction[] pProgram;

	/**
	 * Constructor de la clase
	 */
	public ParsedProgram() {
		this.pProgram = new Instruction[EXTEND_VALUE];
	}

	/**
	 * Añade una instrucción
	 * 
	 * @param ins
	 *            instrucción que se añade
	 * @throws ArrayException
	 *             para contemplar errores de acceso a posiciones incorrectas de
	 *             un array.
	 */
	public void addInst(Instruction ins) throws ArrayException {
		if (this.nextProgramPosition >= EXTEND_VALUE)
			throw new ArrayException("Acceso incorrecto al array del programa");
		this.pProgram[this.nextProgramPosition++] = ins;
	}

	/**
	 * Obtiene la instrucción en la posición pasada como parámetro
	 * 
	 * @param k
	 *            posición de la instrucción
	 * @return instrucción recuperada
	 */
	public Instruction getInstruction(int k) {
		if (k < 0 || k >= this.nextProgramPosition)
			return null;
		return this.pProgram[k];
	}

	/**
	 * Tamaño del programa
	 * 
	 * @return número de elementos del programa
	 */
	public int getSize() {
		return this.nextProgramPosition;
	}

	/**
	 * Resetea el programa
	 */
	public void reset() {
		this.nextProgramPosition = 0;
	}

	@Override
	public String toString() {
		String objectInfo = "";
		if (nextProgramPosition > 0) {
			objectInfo += "Programa parseado almacenado: " + System.getProperty("line.separator");
			for (int i = 0; i < this.nextProgramPosition; i++)
				objectInfo += i + ": " + this.pProgram[i].toString();
		}
		return objectInfo;
	}

}
