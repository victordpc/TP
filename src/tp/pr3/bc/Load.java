package tp.pr3.bc;

import tp.pr3.elements.CPU;
import tp.pr3.exceptions.StackException;

/**
 * Clase que representa la instrución <code>LOAD</code>
 * 
 */
public class Load implements ByteCode {
	private int posicion;

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
	public void execute(CPU cpu) throws StackException {
		int valor = cpu.read(this.posicion);
		cpu.push(valor);
	}

	@Override
	public ByteCode parse(String[] s) {
		if (s.length == 2 && s[0].compareToIgnoreCase("LOAD") == 0) {
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
