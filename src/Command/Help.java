package Command;

import TPMV.Engine;

/**
 * Representa el comando {@code HELP}
 * 
 * @author victor
 */
public class Help extends Command {

	/**
	 * Constructor de la clase
	 */
	public Help() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(Engine engine) {
		return Engine.executeHelp();
	}

	@Override
	public Command parse(String[] s) {
		if (s.length == 1 && s[0].equalsIgnoreCase("Help"))
			return new Help();
		return null;
	}

	@Override
	public String textHelp() {
		return "    HELP: Muestra esta ayuda " + System.getProperty("line.separator");
	}

	public String toString() {
		return "HELP" + System.getProperty("line.separator");
	}
}
