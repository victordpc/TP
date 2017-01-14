package tp.pr3.bc.jumps.conditionaljumps;

import tp.pr3.bc.ByteCode;
import tp.pr3.bc.jumps.ConditionalJump;

/**
 * Clase que representa la instrución <code>IFLE</code>, salto a la direción del
 * programa indicado si los operadores son iguales
 * 
 */
public class IfLe extends ConditionalJump {

	/**
	 * Constructor de la clase
	 */
	public IfLe() {
		super();
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
	public boolean compare(int par1, int par2) {
		return !(par2 < par1);
	}

	@Override
	public String toString() {
		return "IFLE " + this.param + System.getProperty("line.separator");
	}

	@Override
	protected ByteCode parseAux(String com, String par) {
		if (com.compareToIgnoreCase("IFLE") == 0) {
			int val = Integer.parseInt(par);
			return new IfLe(val);
		}
		return null;
	}
}
