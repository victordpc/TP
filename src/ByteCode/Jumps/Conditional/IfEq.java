package ByteCode.Jumps.Conditional;

import ByteCode.ByteCode;

/**
 * Clase que representa la instrución <code>IFEQ</code>, salto a la direción del
 * programa indicado si los operadores son iguales
 * 
 * @author victor
 */
public class IfEq extends Conditional {

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
	public boolean compare() {
		return !(this.subCima == this.cima);
	}

	@Override
	public String toString() {
		return "IFEQ " + this.posicion + System.getProperty("line.separator");
	}

	@Override
	protected boolean operador(String operador) {
		return operador.compareToIgnoreCase("IfEq") == 0;
	}

	@Override
	protected ByteCode parseAux(int val) {
		return new IfEq(val);
	}

}
