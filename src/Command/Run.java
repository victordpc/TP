package Command;

import TPMV.Engine;

/**
 * Clase que representa el comando {@code RUN}
 * 
 * @author victor
 */
public class Run extends Command {

	/**
	 * Constructor de la clase
	 */
	public Run() {
		super();
	}

	@Override
	public boolean execute(Engine engine) {
		return engine.excuteCommandRun();
	}

	@Override
	public Command parse(String[] s) {
		if (s.length == 1 && s[0].equalsIgnoreCase("Run"))
			return new Run();
		return null;
	}

	@Override
	public String textHelp() {
		return "    RUN: Ejecuta el programa " + System.getProperty("line.separator");
	}

	@Override
	public String toString() {
		return "RUN" + System.getProperty("line.separator");
	}
}
