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
		program = new ByteCode[EXTEND_VALUE];
	}

	/**
	 * Añade un elemento de tipo ByteCode en la última posición del programa.
	 * 
	 * @param byteCode
	 *            ByteCode que añadimos.
	 * @return Éxito o fracaso de la operación.
	 */
	public boolean addByteCode(ByteCode byteCode) {
		if (nextProgramPosition < EXTEND_VALUE) {
			program[nextProgramPosition++] = byteCode;
			return true;
		} else
			return false;
	}

	/**
	 * Obtiene el objeto de tipo ByteCode almacenado en el programa en la
	 * posición indicada.
	 * 
	 * @param posicion
	 *            Posición de la cual obtenemos el objeto ByteCode almacenado.
	 * @return Valor almacenado.
	 */
	public ByteCode getProgram(int posicion) {
		return program[posicion];
	}

	/**
	 * Sustituye el valor de una posición del programa por un valor dado.
	 * 
	 * @param position
	 *            Índice del array en el que queremos sustituir su valor.
	 * @param newInstruction
	 *            Instrucción que queremos insertar.
	 */
	public void replace(int position, ByteCode newInstruction) {
		this.program[position] = newInstruction;
	}

	public String toString() {
		String objectInfo = "";
		objectInfo += "Programa almacenado: " + System.getProperty("line.separator");
		for (int i = 0; i < nextProgramPosition; i++) {
			ByteCode storedByteCode = program[i];
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
	 * Obtiene el valor del número de elementos almacenados en el programa.
	 * 
	 * @return Número de elementos almacendos en el programa.
	 */
	public int getLength() {
		return this.nextProgramPosition;
	}

	/**
	 * Reinicia el programa estableciendo el contador de elementos almacenados a
	 * cero.
	 */
	public void reset() {
		nextProgramPosition = 0;
	}
}
