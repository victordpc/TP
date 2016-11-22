package ByteCode;

/**
 * @author victor
 */
public abstract class ConditionalJumps extends ByteCode {
	protected int posicion;

	/**
	 * Constructor de la clase
	 */
	public ConditionalJumps() {
	}

	/**
	 * Constructor de la clase
	 * 
	 * @param valor
	 *            posicion del programa a donde salta si se cumple la condición
	 */
	public ConditionalJumps(int valor) {
		this.posicion = valor;
	}
}
