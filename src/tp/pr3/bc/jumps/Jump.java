package tp.pr3.bc.jumps;

import tp.pr3.bc.ByteCode;

/**
 * Clase abstracta para los ByteCode que tengan un parámetro
 */
public abstract class Jump implements ByteCode {
	protected int n;

	/**
	 * Constructor de la clase
	 * 
	 * @param param
	 *            valor entero asociado al comando
	 */
	public Jump(int param) {
		this.n = param;
	}

	@Override
	public ByteCode parse(String[] s) {
		try {
			if (s.length != 2)
				return null;
			return parseJump(s[0], Integer.parseInt(s[1]));
		} catch (NumberFormatException e) {
			return null;
		}
	}

	@Override
	public String toString() {
		return "Jump [n=" + n + "]" + System.getProperty("line.separator");
	}

	/**
	 * Realiza el parseo específico de los comandos con un parámetro
	 * 
	 * @param s
	 *            cadena que representa el comando
	 * 
	 * @param n
	 *            valor entero asociado al comando
	 * @return <code>ByteCode</code> correspondiente al salto, si es incorrecto
	 *         devuelve <code>null</code>.
	 */
	protected abstract ByteCode parseJump(String s, int n);

}
