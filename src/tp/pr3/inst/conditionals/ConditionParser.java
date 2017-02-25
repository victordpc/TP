package tp.pr3.inst.conditionals;

import tp.pr3.elements.LexicalParser;

/**
 * Clase que se encarga de convertir textos en condiciones
 */
public class ConditionParser {

	private final static Condition[] conditions = { new Equal(), new Less(), new LessEq(), new NotEqual() };

	/**
	 * Convierte un texto a un objeto de tipo <code>ByteCode</code>.
	 * 
	 * @param linea
	 *            cadena de texto.
	 * 
	 * @return <code>ByteCode</code> correspondiente al texto, si es incorrecto
	 *         devuelve <code>null</code>.
	 */
	public static Condition parse(String[] linea) {
		LexicalParser lParser = new LexicalParser();
		for (Condition con : conditions) {
			Condition ins = con.parse(linea[1], linea[2], linea[3], lParser);

			if (ins != null)
				return ins;
		}
		return null;
	}

	/**
	 * Constructor de la clase
	 */
	public ConditionParser() {
	}

}
