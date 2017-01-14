package tp.pr3.bc;

import tp.pr3.elements.CPU;

/**
 * Clase que representa la instrución <code>OUT</code>
 * 
 * @author victor
 */
public class Out extends ByteCode {

	/**
	 * Constructor de la clase
	 */
	public Out() {
		super();
	}

	@Override
	public boolean execute(CPU cpu) {
		return cpu.out();
	}

	@Override
	public ByteCode parse(String[] s) {
		if (s.length == 1 && s[0].equalsIgnoreCase("Out"))
			return new Out();
		return null;
	}

	@Override
	public String toString() {
		return "OUT " + System.getProperty("line.separator");
	}

}
