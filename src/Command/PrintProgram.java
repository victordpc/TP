package command;

import tp.pr3.command.Command;
import tp.pr3.mv.Engine;

/**
 * Clase que representa el comando <code>PrintProgram</code>
 * 
 * @author victor
 *
 */
public class PrintProgram extends Command {

	/**
	 * Constructor por defecto de la clase
	 */
	public PrintProgram() {
		super();
	}

	@Override
	public boolean execute(Engine engine) {
		engine.printProgram();
		return true;
	}

	@Override
	public Command parse(String[] s) {
		if (s.length == 1 && s[0].equalsIgnoreCase("PrintProgram"))
			return new PrintProgram();
		return null;
	}

	@Override
	public String textHelp() {
		return "    PRINTPROGRAM: Escribre el programa actual" + System.getProperty("line.separator");
	}

	@Override
	public String toString() {
		return "PrintProgram" + System.getProperty("line.separator");
	}

}
