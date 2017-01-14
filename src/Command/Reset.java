package command;

import tp.pr3.command.Command;
import tp.pr3.mv.Engine;

/**
 * Clase que representa el comando <code>RESET</code>
 * 
 * @author victor
 *
 */
public class Reset extends Command {

	/**
	 * Constructor de la clase
	 */
	public Reset() {
		super();
	}

	@Override
	public boolean execute(Engine engine) {
		return engine.executeReset();
	}

	@Override
	public Command parse(String[] s) {
		if (s.length == 1 && s[0].equalsIgnoreCase("Reset"))
			return new Reset();
		return null;
	}

	@Override
	public String textHelp() {
		return "    RESET: Vacia el programa actual " + System.getProperty("line.separator");
	}

	@Override
	public String toString() {
		return "RESET" + System.getProperty("line.separator");
	}
}
