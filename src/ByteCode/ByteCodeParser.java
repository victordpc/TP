package ByteCode;

/**
 * Clase que se encarga de convertir textos en {@code ByteCode}
 */
public class ByteCodeParser {
	private final static ByteCode[] instructions = { new Add(), new Div(), new Halt(), new Load(), new Mul(), new Out(),
			new Push(), new Store(), new Sub(), new GoTo(),new IfEq(), new IfLe(), new IfLeq(), new IfNeq() };

	/**
	 * Convierte un texto a un objeto de tipo {@code ByteCode}.
	 * 
	 * @param linea
	 *            cadena de texto.
	 * @return {@code ByteCode} correspondiente al texto, si es incorrecto
	 *         devuelve {@code null}.
	 */
	public static ByteCode parse(String linea) {
		String[] instructionArray = linea.split(" ");

		for (ByteCode instruccion : instructions) {
			ByteCode ins = instruccion.parse(instructionArray);

			if (ins != null)
				return ins;
		}
		return null;
	}
}
