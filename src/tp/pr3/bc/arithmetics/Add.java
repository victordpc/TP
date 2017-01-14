package tp.pr3.bc.arithmetics;

import tp.pr3.bc.ByteCode;
import tp.pr3.elements.CPU;
import tp.pr3.exceptions.StackException;

/**
 * Clase que representa la instrución <code>ADD</code>
 * 
 */
public class Add extends Arithmetics {

	/**
	 * Constructor de la clase
	 */
	public Add() {
		super();
	}

	@Override
	public String toString() {
		return "ADD" + System.getProperty("line.separator");
	}

	@Override
	protected boolean executeAux(CPU cpu, int par1, int par2)throws StackException {
		return cpu.push(par2 + par1);
	}

	@Override
	protected ByteCode parseAux(String com) {
		if (com.compareToIgnoreCase("Add") == 0)
			return new Add();
		return null;
	}
}
