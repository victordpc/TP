package tp.pr3.exceptions;

/**
 * Clase que representa StackException: Detecta errores que se producen en la
 * pila de operandos al ejecutar un bytecode.
 */
public class StackException extends ExecutionErrorException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8851673699954375903L;

	/**
	 * Constructor de la clase
	 * 
	 * @param instr
	 *            Cadena descriptiva del error
	 */
	public StackException(String instr) {
		super(instr);
	}

	@Override
	public String toString() {
		String s = "StackException";
		String message = getLocalizedMessage();
		return (message != null) ? (s + ": " + message) : s;
	}

}
