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

	@Override
	public void compile(tp.pr3.elements.Compiler compiler) throws ArrayException {
		this.condition.compile(compiler);
		compiler.compile(this.ifBody);
		int jump = compiler.getSizeBcProgram();
		this.condition.cj.setN(jump);
	}

	@Override
	public Instruction lexParse(String[] words, LexicalParser lexParser) {
		if (words.length == 4 && words[0].equalsIgnoreCase("if")) {
			Condition cnd = ConditionParser.parse(words);

			if (cnd != null) {
				try {
					ParsedProgram iBody = new ParsedProgram();
					lexParser.increaseProgramCounter();
					lexParser.lexicalParser(iBody, "endif");
					lexParser.increaseProgramCounter();
					return new IfThen(cnd, iBody);
				} catch (LexicalAnalysisException e) {
					System.out.println(
							"Se ha producido un error mientras se realizaba el análisis léxico del cuerpo del If"
									+ System.getProperty("line.separator") + e.getMessage());
				}
			}
		}
		return null;
	}

}
