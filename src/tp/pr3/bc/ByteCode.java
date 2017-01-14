package tp.pr3.bc;

import tp.pr3.elements.CPU;
import tp.pr3.exceptions.DivByZeroException;
import tp.pr3.exceptions.StackException;

/**
 * Clase que representa las instrucciones que puede manejar la máquina virtual.
 */
public abstract class ByteCode {

	/**
	 * Ejecuta el <code>bytecode</code>
	 * 
	 * @param cpu
	 *            instancia en la que se ejecuta el <code>bytecode</code>
	 * 
	 * @return <code>true</code> exito de la operacion, <code>false</code> en
	 *         otro caso
	 */
	abstract public boolean execute(CPU cpu) throws DivByZeroException, StackException;

	/**
	 * Convierte un texto a un objeto de tipo <code>bytecode</code>.
	 * 
	 * @param s
	 *            array de cadenas de texto.
	 * 
	 * @return <code>bytecode</code> correspondiente al texto, si es incorrecto
	 *         devuelve <code>null</code>.
	 */
	abstract public ByteCode parse(String[] s);

	@Override
	abstract public String toString();
}
