package tp.pr3.elements;

import tp.pr3.bc.ByteCode;
import tp.pr3.exceptions.ArrayException;
import tp.pr3.mv.ByteCodeProgram;
import tp.pr3.mv.ParsedProgram;

/**
 * Clase que representa el compilador de la máquina virtual, pasamos de un
 * <code>ParsedProgram</code> a un <code>ByteCodeProgram</code>
 */
public class Compiler {

	/**
	 * Constructor de la clase
	 */
	public Compiler() {

	}

	/**
	 * @param bc
	 * @throws ArrayException
	 *             para contemplar errores de acceso a posiciones incorrectas de
	 *             un array
	 */
	public void addByteCode(ByteCode bc) throws ArrayException {

	}

	/**
	 * Añade una variable
	 * 
	 * @param varName
	 *            nombre de la variable
	 * @return índice de la variable
	 */
	public int addVariable(String varName) {
		return 0;
	}

	/**
	 * @param pProgram
	 * @throws ArrayException
	 *             para contemplar errores de acceso a posiciones incorrectas de
	 *             un array
	 */
	public void compile(ParsedProgram pProgram) throws ArrayException {
		// TODO Auto-generated method stub

	}

	/**
	 * @return
	 */
	public int getSizeBcProgram() {
		return 0;

	}

	/**
	 * Este método devuelve el índice de la variable varName en la tabla de
	 * variables, con el efecto colateral de que si no está, añade la variable a
	 * la tabla
	 * 
	 * @param varName
	 *            nombre de la variable
	 * @return indice de la variable
	 */
	public int indexOf(String varName) {
		return 0;
	}

	/**
	 * @param bcProgram
	 */
	public void initialize(ByteCodeProgram bcProgram) {

	}

	public String toString() {
		return "Compilador";

	}

}
