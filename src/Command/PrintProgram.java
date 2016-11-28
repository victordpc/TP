package Command;

import TPMV.Engine;

/**Clase que representa el comando {@code PrintProgram}
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
		return "    PrintProgram: Escribre el programa actual" + System.getProperty("line.separator");
	}

	public String toString() {
		return "PrintProgram" + System.getProperty("line.separator");
	}

}
