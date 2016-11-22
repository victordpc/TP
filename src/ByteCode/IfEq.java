package ByteCode;

import TPMV.CPU;

/**
 * Clase que representa la instrución {@code IFEQ}, salto a la direción del
 * programa indicado si los operadores son iguales
 * 
 * @author victor
 */
public class IfEq extends ConditionalJumps {
	private int posicion;

	/**
	 * Constructor de la clase
	 */
	public IfEq() {
	}

	/**
	 * Constructor de la clase
	 * 
	 * @param valor
	 *            posicion del programa a donde salta si se cumple la condición
	 */
	public IfEq(int valor) {
		super(valor);
	}

	@Override
	public boolean execute(CPU cpu) {
		return cpu.ifEq(posicion);
	}

	@Override
	public ByteCode parse(String[] s) {
		if (s.length == 2 && s[0].equalsIgnoreCase("GoTo")) {
			int val = Integer.parseInt(s[1]);
			return new GoTo(val);
		}
		return null;
	}

}
