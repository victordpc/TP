package tp.pr3.bc.jumps.conditionaljumps;

import tp.pr3.bc.ByteCode;
import tp.pr3.bc.jumps.ConditionalJump;

/**
 * Clase que representa la instrución <code>IFLEQ</code>, salto a la direción
 * del programa indicado si los operadores son iguales
 * 
 */
public class IfLeq extends ConditionalJump {

	/**
	 * Constructor de la clase
	 */
	public IfLeq() {
		super();
	}

	/**
	 * Constructor de la clase
	 * 
	 * @param valor
	 *            posición del programa a donde salta
	 */
	public IfLeq(int valor) {
		super(valor);
	}

	@Override
	public boolean compare(int par1, int par2) {
		return !(par2 <= par1);
	}

	@Override
	public String toString() {
		return "IFLEQ " + this.param + System.getProperty("line.separator");
	}

	@Override
	protected ByteCode parseAux(String com, String par) {
		if (com.compareToIgnoreCase("IFLEQ") == 0) {
			int val = Integer.parseInt(par);
			return new IfLeq(val);
		}
		return null;
	}

}
