package tp.pr3.bc;

import tp.pr3.elements.CPU;
import tp.pr3.exceptions.StackException;

/**
 * Clase que representa la instrución <code>PUSH</code>
 *
 */
public class Push implements ByteCode {
	private int valor;

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
	public void execute(CPU cpu) throws StackException {
		cpu.push(this.valor);
	}

	@Override
	public ByteCode parse(String[] s) {
		if (s.length == 2 && s[0].compareToIgnoreCase("PUSH") == 0) {
			int val = Integer.parseInt(s[1]);
			return new Push(val);
		}
		return null;
	}

	@Override
	public String toString() {
		return "PUSH " + this.valor + System.getProperty("line.separator");
	}

}
