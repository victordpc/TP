package tp.pr3.bc.jumps.conditionaljumps;

import tp.pr3.bc.ByteCode;
import tp.pr3.bc.jumps.ConditionalJump;

/**
 * Clase que representa la instrución <code>IFEQ</code>, salto a la direción del
 * programa indicado si los operadores son iguales
 * 
 */
public class IfEq extends ConditionalJump {

	/**
	 * Constructor de la clase
	 */
	public IfEq() {
		super();
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
	public boolean compare(int par1, int par2) {
		return !(par2 == par1);
	}

	@Override
	public String toString() {
		return "IFEQ " + this.param + System.getProperty("line.separator");
	}

	@Override
	protected ByteCode parseAux(String com, String par) {
		if (com.compareToIgnoreCase("IFEQ") == 0) {
			int val = Integer.parseInt(par);
			return new IfEq(val);
		}
		return null;
	}

}
