package tp.pr3.inst.conditionals;

import tp.pr3.bc.jumps.ConditionalJump;
import tp.pr3.elements.LexicalParser;
import tp.pr3.inst.assignments.Term;

/**
 * Clase que representa una condición de desigualdad
 */
public class NotEqual extends Condition {

	/**
	 * Constructor de la clase
	 */
	public NotEqual() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor de la clase
	 * 
	 * @param t1
	 * @param t2
	 */
	public NotEqual(Term t1, Term t2) {
		super(t1, t2);
	}

	@Override
	protected Condition parseOp(Term t1, String op, Term t2, LexicalParser lexParser) {
		if (op == "!=")
			return new NotEqual(t1, t2);
		return null;
	}

	@Override
	protected ConditionalJump compileOp() {
		// TODO Auto-generated method stub
		return null;
	}
}
