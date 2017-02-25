package tp.pr3.bc.jumps.conditionaljumps;

import tp.pr3.bc.ByteCode;
import tp.pr3.bc.jumps.ConditionalJump;
import tp.pr3.elements.CPU;

/**
 * Clase que representa la instrución <code>IFEQ</code>, salto a la direción del
 * programa indicado si los operadores son iguales
 * 
 */
public class IfEq extends ConditionalJump {

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
	public boolean compares(int c, int sc, CPU cpu) {
		return !(sc == c);
	}

	@Override
	public String toString() {
		return "IFEQ " + this.n + System.getProperty("line.separator");
	}

	@Override
	protected ByteCode parseJump(String s, int n) {
		if (s.compareToIgnoreCase("IFEQ") == 0) {
			return new IfEq(n);
		}
		return null;
	}

}
