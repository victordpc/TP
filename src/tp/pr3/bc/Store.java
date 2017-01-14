package tp.pr3.bc;

import tp.pr3.bc.jumps.OneParameter;
import tp.pr3.elements.CPU;
import tp.pr3.exceptions.StackException;

/**
 * Clase que representa la instrución <code>STORE</code>
 * 
 */
public class Store extends OneParameter {
	private int posicion;

	/**
	 * Constructor de la clase
	 */
	public Store() {
		super();
	}

	/**
	 * Constructor de la clase
	 * 
	 * @param valor
	 *            posición de memoria donde guardar la cima de la pila
	 */
	public Store(int valor) {
		this.posicion = valor;
	}

	@Override
	public boolean execute(CPU cpu) throws StackException {
		int valor = cpu.pop();
		return cpu.store(this.posicion, valor);

	}

	@Override
	public String toString() {
		return "STORE " + this.posicion + System.getProperty("line.separator");
	}

	@Override
	protected ByteCode parseAux(String com, String par) {
		if (com.compareToIgnoreCase("STORE") == 0) {
			int val = Integer.parseInt(par);
			return new Store(val);
		}
		return null;
	}

}
