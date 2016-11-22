package ByteCode;

import TPMV.CPU;

/**
 * Clase que representa la instrución {@code IFLE}, salto a la direción del
 * programa indicado si los operadores son iguales
 * 
 * @author victor
 *
 */
public class IfLe extends ConditionalJumps {

	/**
	 * Constructor de la clase
	 */
	public IfLe() {
	}

	/**
	 * Constructor de la clase
	 * 
	 * @param valor
	 *            posicion del programa a donde salta si se cumple la condición
	 */
	public IfLe(int valor) {
		super(valor);
	}

	@Override
	public boolean execute(CPU cpu) {
		return cpu.ifLe(posicion);
	}

	@Override
	public ByteCode parse(String[] s) {
		if (s.length == 2 && s[0].equalsIgnoreCase("IfLe")) {
			int val = Integer.parseInt(s[1]);
			return new IfLe(val);
		}
		return null;
	}

}
