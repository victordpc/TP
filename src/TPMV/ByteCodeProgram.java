package TPMV;

/**
 * Clase para almacenar programas.
 */
public class ByteCodeProgram {

	private final ByteCode[] program;
	private int nextProgramPosition = 0;
	private static final int EXTEND_VALUE = 1000;

	/**
	 * Constructor de la clase
	 */
	public ByteCodeProgram() {
		this.program = new ByteCode[EXTEND_VALUE];
	}

	/**
	 * Añade un elemento de tipo ByteCode en la última posición del programa.
	 * 
	 * @param byteCode
	 *            {@code ByteCode} que añadimos.
	 * @return {@code true} exito de la operacion, {@code false} en otro caso
	 */
	public boolean addByteCode(ByteCode byteCode) {
		if (this.nextProgramPosition < EXTEND_VALUE) {
			this.program[this.nextProgramPosition++] = byteCode;
			return true;
		} else
			return false;
	}

	/**
	 * Obtiene el objeto de tipo ByteCode almacenado en el programa en la
	 * posición indicada.
	 * 
	 * @param posicion
	 *            índice que queremos recuperar
	 * @return valor almacenado.
	 */
	public ByteCode getProgram(int posicion) {
		return this.program[posicion];
	}

	/**
	 * Sustituye el valor de una posicion del programa por un valor dado.
	 * 
	 * @param position
	 *            índice del array en el que queremos sustituir su valor.
	 * @param newInstruction
	 *            instruccion que queremos insertar.
	 */
	public void replace(int position, ByteCode newInstruction) {
		this.program[position] = newInstruction;
	}

	public String toString() {
		String objectInfo = "";
		if (nextProgramPosition > 0) {
			objectInfo += "Programa almacenado: " + System.getProperty("line.separator");
			for (int i = 0; i < this.nextProgramPosition; i++)
				objectInfo += i +": " + this.program[i].toString() + System.getProperty("line.separator");
		}
		return objectInfo;
	}

	/**
	 * Obtiene el valor del numero de elementos almacenados en el programa.
	 * 
	 * @return número de elementos almacendos en el programa.
	 */
	public int getLength() {
		return this.nextProgramPosition;
	}

	/**
	 * Reinicia el programa estableciendo el contador de elementos almacenados a
	 * cero.
	 */
	public void reset() {
		this.nextProgramPosition = 0;
	}
}
