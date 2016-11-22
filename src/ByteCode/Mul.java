package ByteCode;

import TPMV.CPU;

/**
 * Clase que representa la instrución {@code MUL}
 * 
 * @author victor
 */
public class Mul extends ByteCode {

	/**
	 * Constructor de la clase
	 */
	public Mul() {
	}

	@Override
	public boolean execute(CPU cpu) {
		return cpu.mul();
	}

	@Override
	public ByteCode parse(String[] s) {
		if (s.length == 1 && s[0].equalsIgnoreCase("Mul"))
			return new Mul();
		return null;
	}

}
