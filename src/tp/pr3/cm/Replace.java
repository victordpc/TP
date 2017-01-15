package tp.pr3.cm;

import tp.pr3.exceptions.ArrayException;
import tp.pr3.exceptions.BadFormatByteCodeException;
import tp.pr3.mv.Engine;

/**
 * Clase que representa el comando <code>REPLACEBC N</code>
 * 
 * @author victor
 */
public class Replace implements Command {

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
	public void execute(Engine engine) throws BadFormatByteCodeException, ArrayException {
		engine.executeReplace(this.position);
	}

	@Override
	public Command parse(String[] s) {
		if (s.length == 2 && s[0].equalsIgnoreCase("ReplaceBC")) {
			int pos = Integer.parseInt(s[1]);

			if (pos >= 0) {
				return new Replace(pos);
			}
		}
		return null;
	}

	@Override
	public String textHelp() {
		return "    REPLACEBC N: Sustituye la instruccion N por la solicitada al usuario"
				+ System.getProperty("line.separator");
	}

	@Override
	public String toString() {
		return "REPLACEBC " + this.position + System.getProperty("line.separator");
	}
}
