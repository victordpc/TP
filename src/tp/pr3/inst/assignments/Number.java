package tp.pr3.inst.assignments;

import tp.pr3.bc.ByteCode;

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
		// TODO Auto-generated method stub
		return null;
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
