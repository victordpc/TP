package tp.pr3.bc.arithmetics;

import tp.pr3.bc.ByteCode;
import tp.pr3.elements.CPU;
import tp.pr3.exceptions.StackException;

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
	protected void operates(int c, int sc, CPU cpu) throws StackException {
		cpu.push(sc * c);
	}

	@Override
	protected ByteCode parseOperation(String com) {
		if (com.compareToIgnoreCase("Mul") == 0)
			return new Mul();
		return null;
	}

}
