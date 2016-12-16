package bytecode;

import tpmv.CPU;

/**
 * Clase que representa las instrucciones que puede manejar la máquina virtual.
 */
public abstract class ByteCode {

	/**
	 * Ejecuta el <code>ByteCode</code>
	 * 
	 * @param cpu
	 *            instancia en la que se ejecuta el <code>ByteCode</code>
	 * 
	 * @return <code>true</code> exito de la operacion, <code>false</code> en
	 *         otro caso
	 */
	abstract public boolean execute(CPU cpu);

	/**
	 * Convierte un texto a un objeto de tipo <code>ByteCode</code>.
	 * 
	 * @param s
	 *            array de cadenas de texto.
	 * 
	 * @return <code>ByteCode</code> correspondiente al texto, si es incorrecto
	 *         devuelve <code>null</code>.
	 */
	abstract public ByteCode parse(String[] s);

	@Override
	abstract public String toString();
}
