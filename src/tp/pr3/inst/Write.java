package tp.pr3.inst;

import tp.pr3.bc.Out;
import tp.pr3.elements.Compiler;
import tp.pr3.elements.LexicalParser;
import tp.pr3.exceptions.ArrayException;
import tp.pr3.inst.assignments.Variable;

/** Clase que representa la instruccion Write */
public class Write implements Instruction {
	private Variable var;

	/** Constructor de la clase */
	public Write() {
	}

	/**
	 * Constuctor de la clase
	 * 
	 * @param varName
	 *            nombre de la variable a mostrar
	 */
	public Write(String varName) {
		this.var = new Variable(varName);
	}

	@Override
	public void compile(Compiler compiler) throws ArrayException {
		compiler.addByteCode(this.var.compile(compiler));
		compiler.addByteCode(new Out());
	}

	@Override
	public Instruction lexParse(String[] words, LexicalParser lexParser) {
		if (words.length == 2 && words[0].compareToIgnoreCase("write") == 0 && words[1].charAt(0) >= 'a'
				&& words[1].charAt(0) <= 'z') {
			lexParser.increaseProgramCounter();
			return new Write(words[1]);
		}
		return null;
	}

}
