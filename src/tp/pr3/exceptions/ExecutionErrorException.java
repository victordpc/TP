package tp.pr3.exceptions;

/**
 * Clase que representa ExecutionErrorException: Se usa para errores en ejecución.
 */
public class ExecutionErrorException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3277173032921398942L;

	/**
	 * Constructor de la clase
	 * 
	 * @param instr
	 *            Cadena descriptiva del error
	 */
	public ExecutionErrorException(String instr) {
		super(instr);
	}

	@Override
	public String toString() {
		String s = "ExecutionErrorException";
		String message = getLocalizedMessage();
		return (message != null) ? (s + ": " + message) : s;
	}
}
