package bytecode.arithmetics;

import bytecode.ByteCode;
import elements.CPU;
import exceptions.StackException;

/**
 * Clase que representa la instrución <code>SUB</code>
 * 
 */
public class Sub extends Arithmetics {

	/**
	 * Constructor de la clase
	 */
	public Sub() {
		super();
	}

	@Override
	public String toString() {
		return "SUB" + System.getProperty("line.separator");
	}

	@Override
	protected boolean executeAux(CPU cpu, int par1, int par2) throws StackException {
		return cpu.push(par2 - par1);
	}

	@Override
	protected ByteCode parseAux(String com) {
		if (com.compareToIgnoreCase("Sub") == 0)
			return new Sub();
		return null;
	}

}
