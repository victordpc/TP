package ByteCode;

import TPMV.CPU;

/**
 * Clase que representa la instrución {@code HALT}
 * 
 * @author victor
 */
public class Halt extends ByteCode {

	/**
	 * Constructor de la clase
	 */
	public Halt() {
		super();
	}

	@Override
	public boolean execute(CPU cpu) {
		return cpu.halt();
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
