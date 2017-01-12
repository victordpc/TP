package tp.pr3.inst.conditionals;

import tp.pr3.elements.LexicalParser;
import tp.pr3.exceptions.ArrayException;
import tp.pr3.exceptions.LexicalAnalysisException;
import tp.pr3.inst.Instruction;
import tp.pr3.mv.ParsedProgram;

/**
 * Clase que representa un bloque if
 */
public class IfThen implements Instruction {
	Condition condition;
	ParsedProgram ifBody;

	/**
	 * Constructor de la clase
	 */
	public IfThen() {
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
	public IfThen(Condition cd, ParsedProgram pP) {
		this.condition = cd;
		this.ifBody = pP;
	}

	public void compile(tp.pr3.elements.Compiler compiler) throws ArrayException {
		this.condition.compile(compiler);
		compiler.compile(this.ifBody);
		// TODO: revisar
		// this.condition.setJump(compiler.getProgramCounter());
	}

	@Override
	public Instruction lexParse(String[] words, LexicalParser lexparser) {
		if (words[0].equalsIgnoreCase("if")) {
			Condition cnd = ConditionParser.parse(words);
			ParsedProgram iBody = null;
			if (cnd != null) {
				try {
					iBody = new ParsedProgram();
					lexparser.lexicalParser(iBody, "endif");
					return new IfThen(cnd, iBody);
				} catch (LexicalAnalysisException e) {
					System.err.println(
							"Se ha producido un error mientras se realizaba el análisis léxico del cuerpo del If");
				}
			}
		}
		return null;
	}

}
