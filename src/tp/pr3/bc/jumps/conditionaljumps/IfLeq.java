package tp.pr3.bc.jumps.conditionaljumps;

import tp.pr3.bc.ByteCode;
import tp.pr3.bc.jumps.ConditionalJump;
import tp.pr3.elements.CPU;

/**
 * Clase que representa la instrución <code>IFLEQ</code>, salto a la direción
 * del programa indicado si los operadores son iguales
 * 
 */
public class IfLeq extends ConditionalJump {

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
	public boolean compares(int c, int sc, CPU cpu) {
		return !(sc <= c);
	}

	@Override
	public String toString() {
		return "IFLEQ " + this.n + System.getProperty("line.separator");
	}

	@Override
	protected ByteCode parseJump(String s, int n) {
		if (s.compareToIgnoreCase("IFLEQ") == 0) {
			return new IfLeq(n);
		}
		return null;
	}

}
