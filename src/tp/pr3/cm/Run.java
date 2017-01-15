package tp.pr3.cm;

import tp.pr3.exceptions.ArrayException;
import tp.pr3.exceptions.ExecutionErrorException;
import tp.pr3.mv.Engine;

/**
 * Clase que representa el comando <code>RUN</code>
 * 
 * @author victor
 */
public class Run implements Command {

	/**
	 * Constructor de la clase
	 */
	public Run() {
		super();
	}

	@Override
	public void execute(Engine engine) throws ExecutionErrorException, ArrayException {
		engine.excuteRun();
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
