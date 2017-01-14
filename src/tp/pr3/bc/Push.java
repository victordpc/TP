package tp.pr3.bc;

import tp.pr3.bc.jumps.OneParameter;
import tp.pr3.elements.CPU;
import tp.pr3.exceptions.StackException;

/**
 * Clase que representa la instrución <code>PUSH</code>
 *
 */
public class Push extends OneParameter {
	private int valor;

	/**
	 * Constructor de la clase
	 */
	public Push() {
		super();
	}

	/**
	 * Constructor de la clase
	 * 
	 * @param valor
	 *            valor con el que se crea la instrucción para cargar en la pila
	 */
	public Push(int valor) {
		this.valor = valor;
	}

	@Override
	public boolean execute(CPU cpu) throws StackException {
		return cpu.push(this.valor);
	}

	@Override
	public String toString() {
		return "PUSH " + this.valor + System.getProperty("line.separator");
	}

	@Override
	protected ByteCode parseAux(String com, String par) {
		if (com.compareToIgnoreCase("PUSH") == 0) {
			int val = Integer.parseInt(par);
			return new Push(val);
		}
		return null;
	}

}
