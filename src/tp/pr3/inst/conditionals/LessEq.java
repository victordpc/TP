package tp.pr3.inst.conditionals;

import tp.pr3.bc.jumps.ConditionalJump;
import tp.pr3.elements.LexicalParser;
import tp.pr3.inst.assignments.Term;

/**
 * Clase que representa una comparación menor o igual
 */
public class LessEq extends Condition {

	/**
	 * Constructor de la clase
	 */
	public LessEq() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor de la clase
	 * 
	 * @param t1
	 *            primer término
	 * @param t2
	 *            segundo término
	 */
	public LessEq(Term t1, Term t2) {
		super(t1, t2);
	}

	@Override
	protected Condition parseOp(Term t1, String op, Term t2, LexicalParser lexParser) {
		if (op == "<=")
			return new LessEq(t1, t2);
		return null;
	}

	@Override
	protected ConditionalJump compileOp() {
		// TODO Auto-generated method stub
		return null;
	}

}
