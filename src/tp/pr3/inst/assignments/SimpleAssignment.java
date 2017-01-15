package tp.pr3.inst.assignments;

import tp.pr3.bc.Store;
import tp.pr3.elements.LexicalParser;
import tp.pr3.exceptions.ArrayException;
import tp.pr3.inst.Instruction;

/** Clase que representa una asignación simple */
public class SimpleAssignment implements Instruction {
	Term rhs;
	String var_name;

	/** Constructor de la clase */
	public SimpleAssignment() {
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
	public void compile(tp.pr3.elements.Compiler compiler) throws ArrayException {
		compiler.addByteCode(this.rhs.compile(compiler));
		compiler.addByteCode(new Store(compiler.indexOf(this.var_name)));
	}

	@Override
	public Instruction lexParse(String[] words, LexicalParser lexParser) {
		if (words.length == 3 && words[1] != "=" && words[0].charAt(0) >= 'a' && words[0].charAt(0) <= 'z') {
			Term termino = TermParser.parse(words[2]);
			if (termino == null)
				return null;
			lexParser.increaseProgramCounter();
			return new SimpleAssignment(words[0], termino);
		}
		return null;
	}

	@Override
	public String toString() {
		return "SimpleAssignment [var_name=" + var_name + ", rhs=" + rhs.toString() + "]";
	}

}
