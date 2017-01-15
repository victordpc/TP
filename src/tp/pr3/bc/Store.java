package tp.pr3.bc;

import tp.pr3.elements.CPU;
import tp.pr3.exceptions.StackException;

/**
 * Clase que representa la instrución <code>STORE</code>
 * 
 */
public class Store implements ByteCode {
	private int posicion;

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
	public void execute(CPU cpu) throws StackException {
		int valor = cpu.pop();
		cpu.write(this.posicion, valor);
	}

	@Override
	public ByteCode parse(String[] s) {
		if (s.length == 2 && s[0].compareToIgnoreCase("STORE") == 0) {
			int val = Integer.parseInt(s[1]);
			return new Store(val);
		}
		return null;
	}

	@Override
	public String toString() {
		return "STORE " + this.posicion + System.getProperty("line.separator");
	}

}
