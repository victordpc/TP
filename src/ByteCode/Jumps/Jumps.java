package ByteCode.Jumps;

import ByteCode.ByteCode;

/**
 * @author victor
 *
 */
public abstract class Jumps extends ByteCode {
	protected int posicion;

	/**
	 * Constructor de la clase
	 */
	public Jumps() {
	}

	/**
	 * Constructor de la clase
	 * 
	 * @param valor
	 *            posicion del programa a donde salta si se cumple la condiciÃ³n
	 */
	public Jumps(int valor) {
		this.posicion = valor;
	}

	@Override
	public ByteCode parse(String[] s) {
		if (s.length == 2 && operador(s[0])) {
			int val = Integer.parseInt(s[1]);
			return parseAux(val);
		}
		return null;
	}

	/**
	 * Comprueba si el texto es un operador de salto válido
	 * 
	 * @param operador
	 *            texto del operador
	 * @return {@code true} si es un operador de salto, {@code false} en otro
	 *         caso
	 */
	protected abstract boolean operador(String operador);

	/**
	 * Realiza el parseo específico del salto
	 * 
	 * @param val
	 *            posicion del programa a donde salta si se cumple la condiciÃ³n
	 * @return {@code ByteCode} correspondiente al salto, si es incorrecto
	 *         devuelve {@code null}.
	 */
	protected abstract ByteCode parseAux(int val);

}
