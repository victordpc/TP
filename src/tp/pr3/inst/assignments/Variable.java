package tp.pr3.inst.assignments;

import tp.pr3.bc.ByteCode;
import tp.pr3.bc.Load;
import tp.pr3.elements.Compiler;

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
		int varIndex = compiler.indexOf(nombre);
		return new Load(varIndex);
	}

	@Override
	public Term parse(String term) {
		if (term.length() == 1) {
			char name = term.charAt(0);
			if ('a' <= name && name <= 'z')
				return new Variable(term);
		}
		return null;

	}

	@Override
	public String toString() {
		return "Variable [nombre=" + nombre + "]";
	}
}
