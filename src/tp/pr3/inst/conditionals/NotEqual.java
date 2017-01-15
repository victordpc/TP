package tp.pr3.inst.conditionals;

import tp.pr3.bc.jumps.ConditionalJump;
import tp.pr3.bc.jumps.conditionaljumps.IfNeq;
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
	}

	/**
	 * Constructor de la clase
	 * 
	 * @param t1 primer termino 
	 * @param t2 segundo termino
	 */
	public NotEqual(Term t1, Term t2) {
		super(t1, t2);
	}

	@Override
	protected ConditionalJump compileOp() {
		return new IfNeq(0);
	}

	@Override
	protected Condition parseOp(Term t1, String op, Term t2, LexicalParser lexParser) {
		if (op.equalsIgnoreCase("!=")) {
			lexParser.increaseProgramCounter();
			return new NotEqual(t1, t2);
		}
		return null;
	}
}
