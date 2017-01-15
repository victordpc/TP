package tp.pr3.exceptions;

/**
 * Clase que representa LexicalAnalysisException: Detecta errores que se pueden
 * producir en el análisis léxico, por incorreciones en el programa fuente.
 */
public class LexicalAnalysisException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3690182972557901070L;

	/**
	 * Constructor de la clase
	 * 
	 * @param instr
	 *            Cadena descriptiva del error
	 */
	public LexicalAnalysisException(String instr) {
		super(instr);
	}

	@Override
	public String toString() {
		String s = "LexicalAnalysisException";
		String message = getLocalizedMessage();
		return (message != null) ? (s + ": " + message) : s;
	}
}
