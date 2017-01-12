package tp.pr3.mv;

import tp.pr3.bc.ByteCode;
import tp.pr3.exceptions.ArrayException;

/**
 * Clase para almacenar programas de ByteCodes.
 */
public class ByteCodeProgram {

	private static final int EXTEND_VALUE = 1000;
	private final ByteCode[] bcProgram;
	private int nextProgramPosition = 0;

	/**
	 * Constructor de la clase
	 */
	public ByteCodeProgram() {
		this.bcProgram = new ByteCode[EXTEND_VALUE];
	}

	/**
	 * Añade un elemento de tipo <code>ByteCode</code> en el programa. Si pos no
	 * es un número mayor o igual que 0 y menor que el número de instrucciones,
	 * se añade en la siguiente posición libre. Si no, se añade, reemplazando la
	 * instrucción que hubiera
	 * 
	 * @param bc
	 *            <code>ByteCode</code> que añadimos.
	 * @param pos
	 *            posición en la que se añade la instrucción
	 * 
	 * @return <code>true</code> exito de la operacion, <code>false</code> en
	 *         otro caso
	 * @throws ArrayException
	 *             contemplar errores de acceso a posiciones incorrectas de un
	 *             array
	 */
	public boolean addByteCode(ByteCode bc, int pos) throws ArrayException {
		if (0 <= pos && pos < this.nextProgramPosition) {
			this.bcProgram[pos] = bc;
		} else
			this.bcProgram[this.nextProgramPosition++] = bc;
		return true;
	}

	/**
	 * Obtiene el objeto de tipo <code>ByteCode</code> almacenado en el programa
	 * en la posición indicada.
	 * 
	 * @param i
	 *            índice que queremos recuperar
	 * 
	 * @return valor almacenado.
	 * @throws ArrayException
	 *             TODO
	 */
	public ByteCode getInst(int i) throws ArrayException {
		if (i < 0 || i >= this.nextProgramPosition)
			throw new ArrayException("Acceso erroneo al Programa");
		return this.bcProgram[i];
	}

	/**
	 * Reinicia el programa estableciendo el contador de elementos almacenados a
	 * cero.
	 */
	public void reset() {
		this.nextProgramPosition = 0;
	}

	/**
	 * Obtiene el valor del numero de elementos almacenados en el programa.
	 * 
	 * @return número de elementos almacendos en el programa.
	 */
	public int size() {
		return this.nextProgramPosition;
	}

	@Override
	public String toString() {
		String objectInfo = "";
		if (nextProgramPosition > 0) {
			objectInfo += "Programa almacenado: " + System.getProperty("line.separator");
			for (int i = 0; i < this.nextProgramPosition; i++)
				objectInfo += i + ": " + this.bcProgram[i].toString();
		}
		return objectInfo;
	}
}
