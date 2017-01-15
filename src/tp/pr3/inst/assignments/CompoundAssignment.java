package tp.pr3.inst.assignments;

import tp.pr3.bc.Store;
import tp.pr3.bc.arithmetics.Add;
import tp.pr3.bc.arithmetics.Arithmetics;
import tp.pr3.bc.arithmetics.Div;
import tp.pr3.bc.arithmetics.Mul;
import tp.pr3.bc.arithmetics.Sub;
import tp.pr3.elements.LexicalParser;
import tp.pr3.exceptions.ArrayException;
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
	public void compile(tp.pr3.elements.Compiler compiler) throws ArrayException {
		compiler.addByteCode(this.term1.compile(compiler));
		compiler.addByteCode(this.term2.compile(compiler));

		Arithmetics op = null;
		switch (operator) {
		case "+":
			op = new Add();
			break;
		case "-":
			op = new Sub();
			break;
		case "*":
			op = new Mul();
			break;
		case "/":
			op = new Div();
			break;
		}

		compiler.addByteCode(op);
		compiler.addByteCode(new Store(compiler.indexOf(this.var_name)));
	}

	@Override
	public Instruction lexParse(String[] words, LexicalParser lexParser) {
		if (words.length == 5 && words[0].charAt(0) >= 'a' && words[0].charAt(0) <= 'z' && words[1] != "="
				&& !(words[3].charAt(0) != '+' && words[3].charAt(0) != '/' && words[3].charAt(0) != '*'
						&& words[3].charAt(0) != '-')) {
			Term t1 = TermParser.parse(words[2]);
			if (t1 == null)
				return null;
			Term t2 = TermParser.parse(words[4]);
			if (t2 == null)
				return null;

			String operator = words[3];

			String var = words[0];
			lexParser.increaseProgramCounter();
			return new CompoundAssignment(var, operator, t1, t2);
		}
		return null;
	}

	@Override
	public String toString() {
		return "CompoundAssignment [var_name=" + var_name + ", term1=" + term1.toString() + ", operator=" + operator
				+ ", term2=" + term2.toString() + "]";
	}

}
