package ByteCode;

/**
 * Clase para almacenar programas.
 */
public class ByteCodeProgram {

	private static final int EXTEND_VALUE = 1000;
	private final ByteCode[] program;
	private int nextProgramPosition = 0;

	/**
	 * Constructor de la clase
	 */
	public ByteCodeProgram() {
		this.program = new ByteCode[EXTEND_VALUE];
	}

	/**
	 * Añade un elemento de tipo <code>ByteCode</code> en la última posición del programa.
	 * 
	 * @param byteCode
	 *            <code>ByteCode</code> que añadimos.
	 * @return <code>true</code> exito de la operacion, <code>false</code> en otro caso
	 */
	public boolean addByteCode(ByteCode byteCode) {
		if (this.nextProgramPosition < EXTEND_VALUE) {
			this.program[this.nextProgramPosition++] = byteCode;
			return true;
		} else
			return false;
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
	 * Obtiene el objeto de tipo <code>ByteCode</code> almacenado en el programa en la
	 * posición indicada.
	 * 
	 * @param posicion
	 *            índice que queremos recuperar
	 * @return valor almacenado.
	 */
	public ByteCode getProgram(int posicion) {
		if (posicion >= this.nextProgramPosition)
			return null;
		return this.program[posicion];
	}

	/**
	 * Sustituye el valor de una posicion del programa por un valor dado.
	 * 
	 * @param position
	 *            índice del array en el que queremos sustituir su valor.
	 * @param newInstruction
	 *            instruccion que queremos insertar.
	 * @return <code>true</code> exito de la operacion, <code>false</code> en otro caso
	 */
	public boolean replace(int position, ByteCode newInstruction) {
		if (position < nextProgramPosition) {
			this.program[position] = newInstruction;
			return true;
		} else
			return false;
	}

	/**
	 * Reinicia el programa estableciendo el contador de elementos almacenados a
	 * cero.
	 */
	public void reset() {
		this.nextProgramPosition = 0;
	}

	@Override
	public String toString() {
		String objectInfo = "";
		if (nextProgramPosition > 0) {
			objectInfo += "Programa almacenado: " + System.getProperty("line.separator");
			for (int i = 0; i < this.nextProgramPosition; i++)
				objectInfo += i + ": " + this.program[i].toString();
		}
		return objectInfo;
	}
}
