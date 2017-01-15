package tp.pr3.bc.arithmetics;

import tp.pr3.bc.ByteCode;
import tp.pr3.elements.CPU;
import tp.pr3.exceptions.DivByZeroException;
import tp.pr3.exceptions.StackException;

/**
 * Clase abstracta que representa a los ByteCodes aritméticos
 * 
 */
public abstract class Arithmetics implements ByteCode {

	/**
	 * Constructor de la clase
	 */
	public Arithmetics() {
		super();
	}

	@Override
	public void execute(CPU cpu) throws StackException, DivByZeroException {
		int c = cpu.pop();
		int sc = cpu.pop();
		operates(c, sc, cpu);
	}

	@Override
	public ByteCode parse(String[] s) {
		if (s.length != 1)
			return null;
		return parseOperation(s[0]);
	}

	/**
	 * Realiza la ejecución del comando
	 * 
	 * @param c
	 *            primer valor de la operación
	 * @param sc
	 *            segundo valor de la operación
	 * @param cpu
	 *            objeto en el que se ejecuta el comando
	 * 
	 * @throws DivByZeroException
	 *             division por cero
	 * @throws StackException
	 *             fallo de pila
	 */
	protected abstract void operates(int c, int sc, CPU cpu) throws DivByZeroException, StackException;

	/**
	 * Realiza el parseo específico del comando
	 * 
	 * @param com
	 *            cadena de texto que representa el comando
	 * @return <code>ByteCode</code> correspondiente a la operación, si es
	 *         incorrecto devuelve <code>null</code>.
	 */
	protected abstract ByteCode parseOperation(String com);

}
