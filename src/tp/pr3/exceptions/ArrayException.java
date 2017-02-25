package tp.pr3.exceptions;

/**
 * Clase que representa ArrayException para contemplar errores de acceso a
 * posiciones incorrectas de un array.
 */
public class ArrayException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6578143476594314922L;

	/**
	 * Constructor de la clase
	 * 
	 * @param instr
	 *            Cadena descriptiva del error
	 */
	public ArrayException(String instr) {
		super(instr);
	}

	@Override
	public String toString() {
		String s = "ArrayException";
		String message = getLocalizedMessage();
		return (message != null) ? (s + ": " + message) : s;
	}

}
