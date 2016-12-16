package bytecode.arithmetics;

import bytecode.ByteCode;
import tpmv.CPU;

/**
 * Clase que representa la instrución <code>MUL</code>
 * 
 */
public class Mul extends Arithmetics {

	/**
	 * Constructor de la clase
	 */
	public Mul() {
		super();
	}

	@Override
	public String toString() {
		return "MUL" + System.getProperty("line.separator");
	}

	@Override
	protected boolean executeAux(CPU cpu, int par1, int par2) {
		return cpu.push(par2 * par1);
	}

	@Override
	protected ByteCode parseAux(String com) {
		if (com.compareToIgnoreCase("Mul") == 0)
			return new Mul();
		return null;
	}

}
