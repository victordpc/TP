package TPMV;

/**
 * Clase que se encarga de convertir textos en ByteCodes
 */
public class ByteCodeParser {

	/**
	 * Convierte un string recibido por parámetro a un objeto de tipo ByteCode.
	 * 
	 * @param linea
	 *            Línea de texto escrita con el usuario.
	 * @return Objeto ByteCode correspondiente a la línea escrita por el
	 *         usuario, si es un ByteCode incorrecto devuelve null.
	 */
	public static ByteCode parse(String linea) {
		ByteCode resultado = null;
		String[] instructionArray = linea.split(" ");
		String commandString = instructionArray[1].toUpperCase();

		switch (commandString) {
		case "PUSH":
		case "LOAD":
		case "STORE":
			if (instructionArray.length == 3) {
				resultado = new ByteCode(ENUM_BYTECODE.valueOf(commandString), Integer.parseInt(instructionArray[2]));
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
