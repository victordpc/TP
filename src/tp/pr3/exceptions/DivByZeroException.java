package tp.pr3.exceptions;

/**
 * Clase que representa DivisionByZero: Detecta divisiones por cero
 */
public class DivByZeroException extends ExecutionErrorException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7190572635020819056L;

	/**
	 * Constructor de la clase
	 * 
	 * @param instr
	 *            Cadena descriptiva del error
	 */
	public DivByZeroException(String instr) {
		super(instr);
	}

	@Override
	public String toString() {
		String s = "DivisionByZeroException";
		String message = getLocalizedMessage();
		return (message != null) ? (s + ": " + message) : s;
	}
}
