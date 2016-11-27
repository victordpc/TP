package ByteCode;

import TPMV.CPU;

/**
 * Clase que representa la instrución {@code LOAD}
 * 
 * @author victor
 */
public class Load extends ByteCode {
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
	public boolean execute(CPU cpu) {
		int valor = cpu.load(this.posicion);
		return cpu.push(valor);
	}

	@Override
	public ByteCode parse(String[] s) {
		if (s.length == 2 && s[0].equalsIgnoreCase("Load")) {
			int val = Integer.parseInt(s[1]);
			return new Load(val);
		}
		return null;
	}

	@Override
	public String toString() {
		return "LOAD " + this.posicion + System.getProperty("line.separator");
	}

}
