package tp.pr3.inst.conditionals;

import tp.pr3.bc.jumps.GoTo;
import tp.pr3.elements.LexicalParser;
import tp.pr3.exceptions.ArrayException;
import tp.pr3.exceptions.LexicalAnalysisException;
import tp.pr3.inst.Instruction;
import tp.pr3.mv.ParsedProgram;

/**
 * Clase que representa un bloque While
 */
public class While implements Instruction {
	private Condition condition;
	private ParsedProgram whileBody;

	/**
	 * Constructor de la clase
	 */
	public While() {
	}

	/**
	 * Constructor de la clase
	 * 
	 * @param cd
	 *            condición de comparacion
	 * @param pP
	 *            cuerpo del bloque
	 */
	public While(Condition cd, ParsedProgram pP) {
		this.condition = cd;
		this.whileBody = pP;
	}

	@Override
	public void compile(tp.pr3.elements.Compiler compiler) throws ArrayException {
		int bucle = compiler.getSizeBcProgram();
		this.condition.compile(compiler);
		compiler.compile(this.whileBody);
		compiler.addByteCode(new GoTo(bucle));
		int jump = compiler.getSizeBcProgram();
		this.condition.cj.setN(jump);
	}

	@Override
	public Instruction lexParse(String[] words, LexicalParser lexParser) {
		if (words.length == 4 && words[0].equalsIgnoreCase("while")) {
			Condition cnd = ConditionParser.parse(words);
			ParsedProgram wBody = null;
			if (cnd != null) {
				try {
					wBody = new ParsedProgram();
					lexParser.increaseProgramCounter();
					lexParser.lexicalParser(wBody, "endwhile");
					lexParser.increaseProgramCounter();
					return new While(cnd, wBody);
				} catch (LexicalAnalysisException e) {
					System.err.println("Se ha producido un error mientras se realizaba el "
							+ "análisis léxico del cuerpo en el bucle While");
				}
			}
		}
		return null;
	}

	@Override
	public String toString() {
		return "While [condition=" + condition.toString() + ", whileBody=" + whileBody.toString() + "]";
	}

}
