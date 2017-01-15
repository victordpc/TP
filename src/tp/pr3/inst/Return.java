package tp.pr3.inst;

import tp.pr3.bc.Halt;
import tp.pr3.elements.LexicalParser;
import tp.pr3.exceptions.ArrayException;

/**
 * Clase que representa la instruccion Return
 */
public class Return implements Instruction {

	/**
	 * Constructor de la clase
	 */
	public Return() {
	}

	@Override
	public void compile(tp.pr3.elements.Compiler compiler) throws ArrayException {
		compiler.addByteCode(new Halt());
	}

	@Override
	public Instruction lexParse(String[] words, LexicalParser lexParser) {
		if (words.length == 1 && words[0].compareToIgnoreCase("Return") == 0) {
			lexParser.increaseProgramCounter();
			return new Return();
		}
		return null;
	}

}
