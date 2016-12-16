package bytecode.arithmetics;

import bytecode.ByteCode;
import tpmv.CPU;

/**
 * Clase que representa la instrución <code>DIV</code>
 * 
 */
public class Div extends Arithmetics {

	/**
	 * Constructor de la clase
	 */
	public Div() {
		super();
	}

	@Override
	public String toString() {
		return "DIV" + System.getProperty("line.separator");
	}

	@Override
	protected boolean executeAux(CPU cpu, int par1, int par2) {
		if (par1 != 0) {
			return cpu.push(par2 / par1);
		}
		return false;
	}

	@Override
	protected ByteCode parseAux(String com) {
		if (com.compareToIgnoreCase("DIV") == 0)
			return new Div();
		return null;
	}

}
