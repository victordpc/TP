package tp.pr3.inst.assignments;

import tp.pr3.bc.ByteCode;

/**
 * Clase que representa un termino de tipo variable
 */
public class Variable implements Term {
	private String nombre;

	/**
	 * Constructor de la clase
	 * 
	 * @param nombre
	 *            nombre de la variable
	 */
	public Variable(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public ByteCode compile(Compiler compiler) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Term parse(String term) {
		if (term.length() != 1)
			return null;

		char name = term.charAt(0);
		if ('a' <= name && name <= 'z')
			return new Variable(term);

		return null;

	}

	@Override
	public String toString() {
		return "Variable [nombre=" + nombre + "]";
	}
}
