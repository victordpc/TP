package tp.pr3.bc.jumps.conditionaljumps;

import tp.pr3.bc.ByteCode;
import tp.pr3.bc.jumps.ConditionalJump;

/**
 * Clase que representa la instrución <code>IFNEQ</code>, salto a la direción
 * del programa indicado si los operadores son iguales
 * 
 */
public class IfNeq extends ConditionalJump {

	/**
	 * Constructor de la clase
	 */
	public IfNeq() {
		super();
	}

	/**
	 * Constructor de la clase
	 * 
	 * @param valor
	 *            posición del programa a donde salta
	 */
	public IfNeq(int valor) {
		super(valor);
	}

	@Override
	public boolean compare(int par1, int par2) {
		return !(par2 != par1);
	}

	@Override
	public String toString() {
		return "IFNEQ " + this.param + System.getProperty("line.separator");
	}

	@Override
	protected ByteCode parseAux(String com, String par) {
		if (com.compareToIgnoreCase("IFNEQ") == 0) {
			int val = Integer.parseInt(par);
			return new IfNeq(val);
		}
		return null;
	}

}
