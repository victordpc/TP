package ByteCode;

import TPMV.CPU;

/**
 * Clase que representa la instrución <code>PUSH</code>
 * 
 * @author victor
 */
public class Push extends ByteCode {
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
	public boolean execute(CPU cpu) {
		return cpu.push(this.valor);
	}

	@Override
	public ByteCode parse(String[] s) {
		if (s.length == 2 && s[0].equalsIgnoreCase("Push")) {
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
