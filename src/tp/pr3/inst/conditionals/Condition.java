package tp.pr3.inst.conditionals;

import tp.pr3.bc.jumps.ConditionalJump;
import tp.pr3.elements.Compiler;
import tp.pr3.elements.LexicalParser;
import tp.pr3.exceptions.ArrayException;
import tp.pr3.inst.assignments.Term;
import tp.pr3.inst.assignments.TermParser;

/**
 * Clase abstracta que representa una condicion
 */
public abstract class Condition {
	protected ConditionalJump condition;
	private Term term1;
	private Term term2;

	/**
	 * Constructor de la clase
	 */
	public Condition() {
	}

	/**
	 * Constructor de la clase
	 * 
	 * @param t1
	 *            Primer término
	 * @param t2
	 *            Segundo término
	 */
	public Condition(Term t1, Term t2) {
		this.term1 = t1;
		this.term2 = t2;
	}

	/**
	 * Compila la condición
	 * 
	 * @param compiler
	 *            Compilador usado
	 * @throws ArrayException
	 *             para contemplar errores de acceso a posiciones incorrectas de
	 *             un array
	 */
	public void compile(Compiler compiler) throws ArrayException {
	}

	/**
	 * Operación de parseo propia de la condición
	 * 
	 * @param t1
	 *            primer termino
	 * @param op
	 *            operador
	 * @param t2
	 *            segundo término
	 * @param parser
	 *            parseador usado
	 * @return Condición
	 */
	protected abstract Condition parseOp(Term t1, java.lang.String op, Term t2, LexicalParser lexParser);

	/**
	 * Parsea una condicion
	 * 
	 * @param t1
	 *            primer termino
	 * @param op
	 *            operador
	 * @param t2
	 *            segundo término
	 * @param parser
	 *            parseador usado
	 * @return Condición
	 */
	public Condition parse(String t1, String op, String t2, LexicalParser parser) {
		this.term1 = TermParser.parse(t1);
		if (term1 == null)
			return null;
		
		this.term2 = TermParser.parse(t2);
		if (term2 == null)
			return null;

		return parseOp(term1, op, term2, parser);
	}

	/**
	 * Compila la condición propia de la clase
	 */
	protected abstract ConditionalJump compileOp();
}
