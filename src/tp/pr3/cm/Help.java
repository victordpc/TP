package tp.pr3.cm;

import tp.pr3.mv.Engine;

/**
 * Representa el comando <code>HELP</code>
 * 
 */
public class Help implements Command {

	/**
	 * Constructor de la clase
	 */
	public Help() {
		super();
	}

	@Override
	public void execute(Engine engine) {
		engine.executeHelp();
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

	@Override
	public String toString() {
		return "HELP" + System.getProperty("line.separator");
	}
}
