package ByteCode;

import TPMV.CPU;

/**
 * Clase que representa la instrución {@code IFLEQ}, salto a la direción del
 * programa indicado si los operadores son iguales
 * 
 * @author victor
 */
public class IfLeq extends ConditionalJumps {

	/**
	 * Constructor de la clase
	 */
	public IfLeq() {
	}

	/**
	 * Constructor de la clase
	 * 
	 * @param valor
	 *            posicion del programa a donde salta si se cumple la condición
	 */
	public IfLeq(int valor) {
		super(valor);
	}

	@Override
	public boolean execute(CPU cpu) {
		return cpu.ifLeq(posicion);
	}

	@Override
	public ByteCode parse(String[] s) {
		if (s.length == 2 && s[0].equalsIgnoreCase("IfLeq")) {
			int val = Integer.parseInt(s[1]);
			return new IfLeq(val);
		}
		return null;
	}

}
