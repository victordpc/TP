package tp.pr3.inst.assignments;

import tp.pr3.bc.ByteCode;
import tp.pr3.bc.Push;
import tp.pr3.elements.Compiler;

/**
 * Clase que representa un termino de tipo numero
 */
public class Number implements Term {
	private int numero;

	/**
	 * Constructor de la clase
	 * 
	 * @param i
	 *            valor que se le asigna
	 */
	public Number(int i) {
		this.numero = i;
	}

	@Override
	public ByteCode compile(Compiler compiler) {
		return new Push(numero);
	}

	@Override
	public Term parse(String term) {
		try {
			return new Number(Integer.parseInt(term));
		} catch (NumberFormatException e) {
			return null;
		}
	}

	@Override
	public String toString() {
		return "Number [numero=" + numero + "]";
	}

}
