package tp.pr3.inst.conditionals;

import tp.pr3.elements.LexicalParser;
import tp.pr3.exceptions.LexicalAnalysisException;
import tp.pr3.inst.Instruction;
import tp.pr3.mv.ParsedProgram;

/**
 * Clase que representa un bloque While
 */
public class While implements Instruction {
	Condition condition;
	ParsedProgram whileBody;

	/**
	 * Constructor de la clase
	 */
	public While() {
		// TODO Auto-generated constructor stub
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
	public void compile(tp.pr3.elements.Compiler compiler) {
		// TODO Auto-generated method stub
	}

	@Override
	public Instruction lexParse(String[] words, LexicalParser lexparser) {
		if (words[0].equalsIgnoreCase("while")) {
			Condition cnd = ConditionParser.parse(words);
			ParsedProgram wBody = null;
			if (cnd != null) {
				try {
					wBody = new ParsedProgram();
					lexparser.lexicalParser(wBody, "endwhile");
					return new While(cnd, wBody);
				} catch (LexicalAnalysisException e) {
					System.err.println("Se ha producido un error mientras se realizaba el "
							+ "análisis léxico del cuerpo en el bucle While");
				}
			}
		}
		return null;
	}

}
