package tp.pr3.inst.assignments;

/**
 * Clase que se encarga de convertir textos en <code>Term</code>
 */
public class TermParser {

	private final static Term[] coleccion = { new Number(0), new Variable("") };

	/**
	 * Convierte un texto a un objeto de tipo <code>Term</code>.
	 * 
	 * @param term
	 *            cadena de texto.
	 * 
	 * @return <code>Term</code> correspondiente al texto, si es incorrecto
	 *         devuelve <code>null</code>.
	 */
	public static Term parse(String term) {
		Term instructionParsed;
		for (Term ins : coleccion) {
			instructionParsed = ins.parse(term);
			if (instructionParsed != null)
				return instructionParsed;
		}
		return null;
	}

	/**
	 * Constructor de la clase
	 */
	public TermParser() {
	}
}
