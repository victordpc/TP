package tp.pr3.bc;

import tp.pr3.elements.CPU;
import tp.pr3.exceptions.DivByZeroException;
import tp.pr3.exceptions.StackException;

/**
 * Interfaz que representa los <code>ByteCode</code> que puede manejar la
 * máquina virtual.
 */
public interface ByteCode {

	/**
	 * Ejecuta el <code>ByteCode</code>
	 * 
	 * @param cpu
	 *            instancia en la que se ejecuta el <code>ByteCode</code>
	 * @throws DivByZeroException
	 *             Detecta divisiones por cero
	 * @throws StackException
	 *             Detecta errores que se producen en la pila de operandos al
	 *             ejecutar un bytecode.
	 * 
	 */
	void execute(CPU cpu) throws DivByZeroException, StackException;

	/**
	 * Convierte un texto a un objeto de tipo <code>ByteCode</code>.
	 * 
	 * @param s
	 *            array de cadenas de texto.
	 * 
	 * @return <code>ByteCode</code> correspondiente al texto, si es incorrecto
	 *         devuelve <code>null</code>.
	 */
	ByteCode parse(String[] s);

}
