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
	protected void operates(int c, int sc, CPU cpu) throws StackException {
		cpu.push(sc + c);
	}

	@Override
	protected ByteCode parseOperation(String com) {
		if (com.compareToIgnoreCase("Add") == 0)
			return new Add();
		return null;
	}
}
