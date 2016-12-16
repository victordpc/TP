package bytecode.arithmetics;

import bytecode.ByteCode;
import tpmv.CPU;

/**
 * Clase abstracta que representa a los ByteCodes aritméticos
 * 
 */
public abstract class Arithmetics extends ByteCode {

	/**
	 * Constructor de la clase
	 */
	public Arithmetics() {
		super();
	}

	@Override
	public boolean execute(CPU cpu) {
		if (cpu.getStackLength() >= 2) {
			int c = cpu.pop();
			int sc = cpu.pop();
			return executeAux(cpu, c, sc);
		}
		return false;
	}

	@Override
	public ByteCode parse(String[] s) {
		if (s.length != 1)
			return null;
		return parseAux(s[0]);
	}

	/**
	 * Realiza la ejecución del comando
	 * 
	 * @param cpu
	 *            objeto en el que se ejecuta el comando
	 * @param par1
	 *            primer valor de la operación
	 * @param par2
	 *            segundo valor de la operación
	 * @return <code>true</code> si se ha efectuado correctamente la operación,
	 *         <code>false</code> en otro caso
	 */
	protected abstract boolean executeAux(CPU cpu, int par1, int par2);

	/**
	 * Realiza el parseo específico del comando
	 * 
	 * @param com
	 *            cadena de texto que representa el comando
	 * @return <code>ByteCode</code> correspondiente a la operación, si es
	 *         incorrecto devuelve <code>null</code>.
	 */
	protected abstract ByteCode parseAux(String com);
}
