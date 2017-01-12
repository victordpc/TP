package tp.pr3.cm;

import tp.pr3.exceptions.ArrayException;
import tp.pr3.mv.Engine;

/**
 * Representa el comando <code>LOAD FICH</code>
 * 
 */
public class Load implements Command {

	private String fichName;

	/**
	 * Constructor de la clase
	 */
	public Load() {
		super();
	}

	/**
	 * Constructor de la clase
	 * 
	 * @param fichName
	 *            nombre del fichero a cargar
	 */
	public Load(String fichName) {
		super();
		this.fichName = fichName;
	}

	@Override
	public void execute(Engine engine) throws java.io.FileNotFoundException, ArrayException {
		engine.load(fichName);
	}

	@Override
	public Command parse(String[] s) {
		if (s.length == 2 && s[0].equalsIgnoreCase("LOAD") && s[1].equalsIgnoreCase("FICH"))
			return new Load();
		return null;
	}

	@Override
	public String textHelp() {
		return "    LOAD FICH: Carga un programa de un fichero al sistema " + System.getProperty("line.separator");
	}

	@Override
	public String toString() {
		return "LOAD FICH" + System.getProperty("line.separator");
	}

}
