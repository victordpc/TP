package ByteCode;

import TPMV.CPU;

/**
 * Clase que representa la instrución {@code STORE}
 * 
 * @author victor
 */
public class Store extends ByteCode {
	private int posicion;

	/**
	 * Constructor de la clase
	 */
	public Store() {
	}

	/**
	 * Constructor de la clase
	 * 
	 * @param valor
	 *            posición de memoria donde guarda la cima de la pila
	 */
	public Store(int valor) {
		this.posicion = valor;
	}

	@Override
	public boolean execute(CPU cpu) {
		return cpu.store(this.posicion);
	}

	@Override
	public ByteCode parse(String[] s) {
		if (s.length == 2 && s[0].equalsIgnoreCase("Store")) {
			int val = Integer.parseInt(s[1]);
			return new Store(val);
		}
		return null;
	}

}
