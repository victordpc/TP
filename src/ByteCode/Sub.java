package ByteCode;

import TPMV.CPU;

/**
 * Clase que representa la instrución {@code SUB}
 * 
 * @author victor
 */
public class Sub extends ByteCode {

	/**
	 * Constructor de la clase
	 */
	public Sub() {
	}

	@Override
	public boolean execute(CPU cpu) {
		return cpu.sub();
	}

	@Override
	public ByteCode parse(String[] s) {
		if (s.length == 1 && s[0].equalsIgnoreCase("Sub"))
			return new Sub();
		return null;
	}

}
