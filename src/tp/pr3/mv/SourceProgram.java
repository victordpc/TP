package tp.pr3.mv;

import tp.pr3.exceptions.ArrayException;

/**
 * Clase que representa el código fuente a cargar en el sistema
 */
public class SourceProgram {

	private static final int EXTEND_VALUE = 1000;
	private int nextProgramPosition = 0;
	private final String[] sProgram;

	/**
	 * Constructor de la clase
	 */
	public SourceProgram() {
		this.sProgram = new String[EXTEND_VALUE];
	}

	/**
	 * Añade una instrucción al programa
	 * 
	 * @param ins
	 *            instrucción
	 * @throws ArrayException
	 *             para contemplar errores de acceso a posiciones incorrectas de
	 *             un array.
	 */
	public void addInst(String ins) throws ArrayException {
		if (this.nextProgramPosition >= EXTEND_VALUE)
			throw new ArrayException("Acceso incorrecto al array del programa");

		this.sProgram[this.nextProgramPosition++] = ins;
	}

	/**
	 * Obtiene a instrucción almacenada en la posición recibida por parámetro
	 * 
	 * @param k
	 *            posición de la instrucción que queremos recuperar
	 * @return instrucción del programa
	 */
	public String getInstr(int k) {
		if (k < 0 || k >= this.nextProgramPosition)
			return null;
		return this.sProgram[k];
	}

	/**
	 * Obtiene la longitud del programa
	 * 
	 * @return longitud del programa
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
			objectInfo += "Programa fuente almacenado: " + System.getProperty("line.separator");
			for (int i = 0; i < this.nextProgramPosition; i++)
				objectInfo += i + ": " + this.sProgram[i].toString();
		}
		return objectInfo;
	}
}
