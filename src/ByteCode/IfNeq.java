package ByteCode;

import TPMV.CPU;

/**
 * Clase que representa la instrución {@code IFNEQ}, salto a la direción del
 * programa indicado si los operadores son iguales
 * 
 * @author victor
 */
public class IfNeq extends ConditionalJumps {

	/**
	 * Constructor de la clase
	 */
	public IfNeq() {
	}

	/**
	 * Construcotr de la clase
	 * 
	 * @param valor
	 *            posicion del programa a donde salta si se cumple la condición
	 */
	public IfNeq(int valor) {
		super(valor);
	}

	@Override
	public boolean execute(CPU cpu) {
		return cpu.ifNeq(posicion);
	}

	@Override
	public ByteCode parse(String[] s) {
		if (s.length == 2 && s[0].equalsIgnoreCase("IfNeq")) {
			int val = Integer.parseInt(s[1]);
			return new IfNeq(val);
		}
		return null;
	}

}
