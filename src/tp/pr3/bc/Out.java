package tp.pr3.bc;

import tp.pr3.elements.CPU;
import tp.pr3.exceptions.StackException;

/**
 * Clase que representa la instrución <code>OUT</code>
 * 
 * @author victor
 */
public class Out implements ByteCode {

	/**
	 * Constructor de la clase
	 */
	public Out() {
		super();
	}

	@Override
	public void execute(CPU cpu) throws StackException {
		cpu.out();
	}

	@Override
	public ByteCode parse(String[] s) {
		if (s.length == 1 && s[0].equalsIgnoreCase("Out"))
			return new Out();
		return null;
	}

	@Override
	public String toString() {
		return "OUTPUT " + System.getProperty("line.separator");
	}

}
