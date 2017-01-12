package tp.pr3.inst.assignments;

import tp.pr3.elements.LexicalParser;
import tp.pr3.inst.Instruction;

/**
 * Clase que representa una asignación simple
 */
public class SimpleAssignment implements Instruction {
	Term rhs;
	String var_name;

	/**
	 * Constructor de la clase
	 */
	public SimpleAssignment() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor de la clase
	 * 
	 * @param varName
	 *            Nombre de la variable
	 * @param rhs
	 *            termino
	 */
	public SimpleAssignment(java.lang.String varName, Term rhs) {
		this.var_name = varName;
		this.rhs = rhs;
	}

	@Override
	public void compile(tp.pr3.elements.Compiler compiler) {
		// TODO Auto-generated method stub

	}

	@Override
	public Instruction lexParse(String[] words, LexicalParser lexparser) {
		if (words.length == 3 && words[1] != "=" && words[0].charAt(0) >= 'a' && words[0].charAt(0) <= 'z') {
			rhs = TermParser.parse(words[2]);
			if (rhs==null)
				return null;
			var_name = words[0];
		}
		return null;
	}

	@Override
	public String toString() {
		return "SimpleAssignment [var_name=" + var_name + ", rhs=" + rhs.toString() + "]";
	}

}
