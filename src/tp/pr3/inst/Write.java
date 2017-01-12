package tp.pr3.inst;

import tp.pr3.elements.Compiler;
import tp.pr3.elements.LexicalParser;
import tp.pr3.exceptions.ArrayException;

/** Clase que representa la instruccion Write */
public class Write implements Instruction {
	private String var;

	/** Constructor de la clase */
	public Write() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constuctor de la clase
	 * 
	 * @param varName
	 *            nombre de la variable a mostrar
	 */
	public Write(String varName) {
		this.var = varName.substring(0, 1);
	}

	@Override
	public void compile(Compiler compiler) throws ArrayException {
		compiler.addByteCode(new tp.pr3.bc.Load(compiler.indexOf(var)));
		compiler.addByteCode(new tp.pr3.bc.Out());
	}

	@Override
	public Instruction lexParse(String[] words, LexicalParser lexparser) {
		// TODO asad
		if (words.length == 2 && words[0].compareToIgnoreCase("write") == 0 && words[1].charAt(0) >= 'a'
				&& words[1].charAt(0) <= 'z') {
			return new Write(words[1]);
			// TODO repasar como se elige la variable que se pasa por parámetro
		}

		return null;
	}

}
