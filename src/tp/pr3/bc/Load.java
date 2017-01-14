package tp.pr3.bc;

import tp.pr3.bc.jumps.OneParameter;
import tp.pr3.elements.CPU;
import tp.pr3.exceptions.StackException;

/**
 * Clase que representa la instrución <code>LOAD</code>
 * 
 */
public class Load extends OneParameter {
	private int posicion;

	/**
	 * Constructor de la clase
	 */
	public Load() {
		super();
	}

	/**
	 * Constructor de la clase
	 * 
	 * @param posicion
	 *            dirección de memoria que carga en la pila
	 */
	public Load(int posicion) {
		this.posicion = posicion;
	}

	@Override
	public boolean execute(CPU cpu) throws StackException {
		int valor = cpu.load(this.posicion);
		return cpu.push(valor);
	}

	@Override
	public String toString() {
		return "LOAD " + this.posicion + System.getProperty("line.separator");
	}

	@Override
	protected ByteCode parseAux(String com, String par) {
		if (com.compareToIgnoreCase("LOAD") == 0) {
			int val = Integer.parseInt(par);
			return new Load(val);
		}
		return null;
	}

}
