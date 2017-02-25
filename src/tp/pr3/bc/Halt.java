package tp.pr3.bc;

import tp.pr3.elements.CPU;

/**
 * Clase que representa la instrución <code>HALT</code>
 * 
 * @author victor
 */
public class Halt implements ByteCode {

	/**
	 * Constructor de la clase
	 */
	public Halt() {
		super();
	}

	@Override
	public void execute(CPU cpu) {
		cpu.finish();
	}

	@Override
	public ByteCode parse(String[] s) {
		if (s.length == 1 && s[0].equalsIgnoreCase("Halt"))
			return new Halt();
		return null;
	}

	@Override
	public String toString() {
		return "HALT" + System.getProperty("line.separator");
	}
}
