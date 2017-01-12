package tp.pr3.inst.assignments;

import tp.pr3.elements.LexicalParser;
import tp.pr3.inst.Instruction;

/**
 * Clase que representa instrucciones compuestas
 */
public class CompoundAssignment implements Instruction {
	String operator;
	Term term1;
	Term term2;
	String var_name;

	/**
	 * Constructor de la clase
	 */
	public CompoundAssignment() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor de la clase
	 * 
	 * @param varName
	 *            Nombre de la variable
	 * @param operator
	 *            Operador
	 * @param t1
	 *            primer termino
	 * @param t2
	 *            segundo termino
	 */
	public CompoundAssignment(String varName, String operator, Term t1, Term t2) {
		this.var_name = varName;
		this.operator = operator;
		this.term1 = t1;
		this.term2 = t2;
	}

	@Override
	public void compile(tp.pr3.elements.Compiler compiler) {
		// TODO Auto-generated method stub

	}

	@Override
	public Instruction lexParse(String[] words, LexicalParser lexparser) {
		if (words.length == 3 && words[1] != "=" && words[0].charAt(0) >= 'a' && words[0].charAt(0) <= 'z'
				&& !(words[3].charAt(0) != '+' && words[3].charAt(0) != '/' && words[3].charAt(0) != '*'
						&& words[3].charAt(0) != '-')) {
			Term t1 = TermParser.parse(words[2]);
			if (t1 == null)
				return null;
			Term t2 = TermParser.parse(words[4]);
			if (t2 == null)
				return null;
			return new CompoundAssignment(words[0], words[3], t1, t2);
		}
		return null;
	}

	@Override
	public String toString() {
		return "CompoundAssignment [var_name=" + var_name + ", term1=" + term1 + ", operator=" + operator + ", term2="
				+ term2 + "]";
	}

}
