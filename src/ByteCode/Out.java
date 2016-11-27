package ByteCode;

import TPMV.CPU;

/**
 * Clase que representa la instrución {@code OUT}
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
		return "OPUT " + System.getProperty("line.separator");
	}

}
