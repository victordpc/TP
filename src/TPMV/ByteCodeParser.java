package TPMV;

/**
 * Clase que se encarga de convertir textos en {@code ByteCode}
 */
public class ByteCodeParser {

	/**
	 * Convierte un texto a un objeto de tipo {@code ByteCode}.
	 * 
	 * @param linea
	 *            cadena de texto.
	 * @return {@code ByteCode} correspondiente al texto, si es incorrecto
	 *         devuelve {@code null}.
	 */
	public static ByteCode parse(String linea) {
		ByteCode resultado = null;
		String[] instructionArray = linea.split(" ");
		String commandString = instructionArray[1].toUpperCase();

		switch (commandString) {
		case "PUSH":
			if (instructionArray.length == 3) {
				resultado = new ByteCode(ENUM_BYTECODE.valueOf(commandString), Integer.parseInt(instructionArray[2]));
			}
			break;
		case "LOAD":
		case "STORE":
			if (instructionArray.length == 3) {
				int valor = Integer.parseInt(instructionArray[2]);
				if (valor >= 0)
					resultado = new ByteCode(ENUM_BYTECODE.valueOf(commandString), valor);
			}
			break;
		case "ADD":
		case "SUB":
		case "MUL":
		case "DIV":
		case "OUT":
		case "HALT":
			if (instructionArray.length == 2) {
				resultado = new ByteCode(ENUM_BYTECODE.valueOf(commandString));
			}
			break;
		}

		return resultado;
	}
}
