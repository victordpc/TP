package tp.pr3.command;

import tp.pr3.exceptions.ArrayException;
import tp.pr3.exceptions.BadFormatByteCodeException;
import tp.pr3.mv.Engine;

/**
 * Clase que representa el comando <code>REPLACE</code>
 * 
 * @author victor
 */
public class Replace extends Command {

	int position;

	/**
	 * Constructor de la clase
	 */
	public Replace() {
		super();
	}

	/**
	 * Constructor de la clase
	 * 
	 * @param posicion
	 *            número de instrucción para cambiar
	 */
	public Replace(int posicion) {
		super();
		this.position = posicion;
	}

	@Override
	public boolean execute(Engine engine) throws BadFormatByteCodeException, ArrayException {
		return engine.executeReplace(this.position);
	}

	@Override
	public Command parse(String[] s) {
		if (s.length == 2 && s[0].equalsIgnoreCase("Replace")) {
			int pos = Integer.parseInt(s[1]);

			if (pos >= 0) {
				return new Replace(pos);
			}
		}
		return null;
	}

	@Override
	public String textHelp() {
		return "    REPLACE N: solicita al usuario una nueva instrucción bytecode y reemplaza la " +
				"línea N del programa bytecode por la nueva instrucción introducida por el usuario."
				+ System.getProperty("line.separator");
	}

	@Override
	public String toString() {
		return "REPLACE " + this.position + System.getProperty("line.separator");
	}
}
