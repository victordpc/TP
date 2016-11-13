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
	 * A�ade un elemento de tipo ByteCode en la ultima posicion del programa.
	 * 
	 * @param byteCode
	 *            ByteCode que a�adimos.
	 * @return Exito o fracaso de la operacion.
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
	 * posicion indicada.
	 * 
	 * @param posicion
	 *            Posicion de la cual obtenemos el objeto ByteCode almacenado.
	 * @return Valor almacenado.
	 */
	public ByteCode getProgram(int posicion) {
		return this.program[posicion];
	}

	/**
	 * Sustituye el valor de una posicion del programa por un valor dado.
	 * 
	 * @param position
	 *            Indice del array en el que queremos sustituir su valor.
	 * @param newInstruction
	 *            Instruccion que queremos insertar.
	 */
	public void replace(int position, ByteCode newInstruction) {
		this.program[position] = newInstruction;
	}

	public String toString() {
		String objectInfo = "";
		objectInfo += "Programa almacenado: " + System.getProperty("line.separator");
		for (int i = 0; i < this.nextProgramPosition; i++) {
			ByteCode storedByteCode = this.program[i];
			switch (storedByteCode.name) {
			case PUSH:
			case LOAD:
			case STORE:
				objectInfo += i + ": " + storedByteCode.getName().toString() + " " + storedByteCode.getParam()
						+ System.getProperty("line.separator");
				break;
			default:
				objectInfo += i + ": " + storedByteCode.getName().toString() + System.getProperty("line.separator");
				break;
			}
		}
		return objectInfo;
	}

	/**
	 * Obtiene el valor del numero de elementos almacenados en el programa.
	 * 
	 * @return Numero de elementos almacendos en el programa.
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
