package tp.pr3.cm;

import tp.pr3.exceptions.ArrayException;
import tp.pr3.exceptions.LexicalAnalysisException;
import tp.pr3.mv.Engine;

/**
 * Representa el comando <code>COMPILE</code>
 * 
 */
public class Compile implements Command {

	/**
	 * Constructor de la clase
	 */
	public Compile() {
		super();
	}

	@Override
	public void execute(Engine engine) throws LexicalAnalysisException, ArrayException {
		engine.executeCompile();
	}

	@Override
	public Command parse(String[] s) {
		if (s.length == 1 && s[0].equalsIgnoreCase("COMPILE"))
			return new Compile();
		return null;
	}

	@Override
	public String textHelp() {
		return "    Compile: Compila el programa cargado " + System.getProperty("line.separator");
	}

	@Override
	public String toString() {
		return "COMPILE" + System.getProperty("line.separator");
	}

}
