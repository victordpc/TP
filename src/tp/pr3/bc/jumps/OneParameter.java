package tp.pr3.bc.jumps;

import tp.pr3.bc.ByteCode;

/**
 * Clase abstracta para los bytecode que tengan un parámetro
 */
public abstract class OneParameter extends ByteCode {
	protected int param;

	/**
	 * Constructor de la clase
	 */
	public OneParameter() {
	}

	/**
	 * Constructor de la clase
	 * 
	 * @param param
	 *            valor entero asociado al comando
	 */
	public OneParameter(int param) {
		this.param = param;
	}

	public void setJump(int param) {
		this.param = param;
	}

	@Override
	public ByteCode parse(String[] s) {
		if (s.length != 2)
			return null;
		return parseAux(s[0], s[1]);
	}

	/**
	 * Realiza el parseo específico de los comandos con un parámetro
	 * 
	 * @param com
	 *            cadena que representa el comando
	 * 
	 * @param par
	 *            valor entero asociado al comando
	 * @return <code>bytecode</code> correspondiente al salto, si es incorrecto
	 *         devuelve <code>null</code>.
	 */
	protected abstract ByteCode parseAux(String com, String par);

}
