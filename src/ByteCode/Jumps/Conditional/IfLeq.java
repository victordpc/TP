package ByteCode.Jumps.Conditional;

import ByteCode.ByteCode;

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
		super();
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
	public boolean compare() {
		return !(this.subCima <= this.cima);
	}

	@Override
	protected ByteCode parseAux(int val) {
		return new IfLeq(val);
	}

	@Override
	protected boolean operador(String operador) {
		return operador.compareToIgnoreCase("IfLeq") == 0;
	}

	@Override
	public String toString() {
		return "IFLEQ " + this.posicion + System.getProperty("line.separator");
	}

}
