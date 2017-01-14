package tp.pr3.command;

import tp.pr3.mv.Engine;

/**
 * Representa el comando <code>QUIT</code>
 * 
 * @author victor
 */
public class Quit extends Command {

	/**
	 * Constructor de la clase
	 */
	public Quit() {
		super();
	}

	@Override
	public boolean execute(Engine engine) {
		return engine.executeQuit();
	}

	@Override
	public Command parse(String[] s) {
		if (s.length == 1 && s[0].equalsIgnoreCase("Quit"))
			return new Quit();
		return null;
	}

	@Override
	public String textHelp() {
		return "    QUIT: Cierra la aplicacion " + System.getProperty("line.separator");
	}

	@Override
	public String toString() {
		return "QUIT" + System.getProperty("line.separator");
	}

}
