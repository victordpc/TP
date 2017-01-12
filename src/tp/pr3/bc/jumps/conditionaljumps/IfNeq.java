package tp.pr3.bc.jumps.conditionaljumps;

import tp.pr3.bc.ByteCode;
import tp.pr3.bc.jumps.ConditionalJump;
import tp.pr3.elements.CPU;

/**
 * Clase que representa la instrución <code>IFNEQ</code>, salto a la direción
 * del programa indicado si los operadores son iguales
 * 
 */
public class IfNeq extends ConditionalJump {

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
	public boolean compares(int c, int sc, CPU cpu) {
		return !(sc != c);
	}

	@Override
	public String toString() {
		return "IFNEQ " + this.n + System.getProperty("line.separator");
	}

	@Override
	protected ByteCode parseJump(String s, int n) {
		if (s.compareToIgnoreCase("IFNEQ") == 0) {
			return new IfNeq(n);
		}
		return null;
	}

}
