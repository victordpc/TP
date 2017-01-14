package tp.pr3.mv;

import tp.pr3.exceptions.ArrayException;
import tp.pr3.bc.ByteCode;

/**
 * Clase para almacenar programas.
 */
public class ByteCodeProgram {

	private static final int EXTEND_VALUE = 1000;
	private int nextProgramPosition = 0;
	private final ByteCode[] program;

	/**
	 * Constructor de la clase
	 */
	public ByteCodeProgram() {
		this.program = new ByteCode[EXTEND_VALUE];
	}

	/**
	 * Añade un elemento de tipo <code>bytecode</code> en la última posición del
	 * programa.
	 * 
	 * @param byteCode
	 *            <code>bytecode</code> que añadimos.
	 * 
	 * @return <code>true</code> exito de la operacion, <code>false</code> en
	 *         otro caso
	 */
	public boolean addByteCode(ByteCode byteCode) throws ArrayException {
		if (this.nextProgramPosition < EXTEND_VALUE) {
			this.program[this.nextProgramPosition++] = byteCode;
			return true;
		} else{
            throw new ArrayException("Excepcion-ArrayException se ha superado el tamaño máximo de program;" +
                    " por favor refactorice su programa para que no exceda las 1000 instrucciones");
        }
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
	 * Obtiene el objeto de tipo <code>bytecode</code> almacenado en el programa
	 * en la posición indicada.
	 * 
	 * @param posicion
	 *            índice que queremos recuperar
	 * 
	 * @return valor almacenado.
	 */
	public ByteCode getProgram(int posicion) throws ArrayException {
		if (posicion < this.nextProgramPosition){
			return this.program[posicion];
		}else {
			throw new ArrayException("Se ha intentado acceder a una posicion que no existe");
		}
	}

	/**
	 * Sustituye el valor de una posicion del programa por un valor dado.
	 * 
	 * @param position
	 *            índice del array en el que queremos sustituir su valor.
	 * @param newInstruction
	 *            instruccion que queremos insertar.
	 * 
	 * @return <code>true</code> exito de la operacion, <code>false</code> en
	 *         otro caso
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
			objectInfo += "Programa bytecode almacenado: " + System.getProperty("line.separator");
			for (int i = 0; i < this.nextProgramPosition; i++)
				objectInfo += i + ": " + this.program[i].toString();
		}
		return objectInfo;
	}
}
