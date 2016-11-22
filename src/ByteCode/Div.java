package ByteCode;

import TPMV.CPU;

/**
 * Clase que representa la instrución {@code DIV}
 * 
 * @author victor
 */
public class Div extends ByteCode {

	/**
	 * Constructor de la clase
	 */
	public Div() {
	}

	@Override
	public boolean execute(CPU cpu) {
		return cpu.div();
	}

	@Override
	public ByteCode parse(String[] s) {
		if (s.length == 1 && s[0].equalsIgnoreCase("Div"))
			return new Div();
		return null;
	}

}
