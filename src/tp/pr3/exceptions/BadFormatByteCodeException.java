package tp.pr3.exceptions;

/**
 * Clase que representa BadFormatByteCodeException: Se utiliza para detectar que un
 * posible bytecode no se ajusta a la sintaxis especificada.
 */
public class BadFormatByteCodeException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2839607052729549785L;

	/**
	 * Constructor de la clase
	 * 
	 * @param instr
	 *            Cadena descriptiva del error
	 */
	public BadFormatByteCodeException(String instr) {
		super(instr);
	}

	@Override
	public String toString() {
		String s = "BadFormatByteCodeException";
		String message = getLocalizedMessage();
		return (message != null) ? (s + ": " + message) : s;
	}
}
