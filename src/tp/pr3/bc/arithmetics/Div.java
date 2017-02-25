package tp.pr3.bc.arithmetics;

import tp.pr3.bc.ByteCode;
import tp.pr3.elements.CPU;
import tp.pr3.exceptions.DivByZeroException;
import tp.pr3.exceptions.StackException;

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
	protected void operates(int c, int sc, CPU cpu) throws DivByZeroException, StackException {
		if (c != 0) {
			cpu.push(sc / c);
		} else
			throw new DivByZeroException("Division por cero detectada");
	}

	@Override
	protected ByteCode parseOperation(String com) {
		if (com.compareToIgnoreCase("DIV") == 0)
			return new Div();
		return null;
	}

}
