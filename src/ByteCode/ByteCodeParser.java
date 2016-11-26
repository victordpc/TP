package ByteCode;

import Arithmetics.Add;
import Arithmetics.Div;
import Arithmetics.Mult;
import Arithmetics.Sub;

/**
 * Clase que se encarga de convertir textos en {@code ByteCode}
 */
public class ByteCodeParser {

	private final static ByteCode[] byteCodes = { new Push(), new Load(), new Store(), new Halt(), new Out(), new Add(),
			new Div(), new Mult(), new Sub() };

	/**
	 * Convierte un texto a un objeto de tipo {@code ByteCode}.
	 * 
	 * @param linea
	 *            cadena de texto.
	 * @return {@code ByteCode} correspondiente al texto, si es incorrecto
	 *         devuelve {@code null}.
	 */
	public static ByteCode parse(String[] linea) {
		ByteCode byteCode = null;
		int i = 0;
		while (byteCode == null && i < byteCodes.length) {
			if(byteCodes[i].parse(linea) != null) {
				byteCode = byteCodes[i].parse(linea);
			}
			i++;
		}
		return byteCode;
		
		/**
		String commandString = instructionArray[1].toUpperCase();
		ENUM_BYTECODE bydeCode = ENUM_BYTECODE.valueOf(commandString);

		switch (bydeCode) {
		case PUSH:
			if (instructionArray.length == 3) {
				resultado = new ByteCode(ENUM_BYTECODE.valueOf(commandString), Integer.parseInt(instructionArray[2]));
			}
			break;
		case LOAD:
		case STORE:
			if (instructionArray.length == 3) {
				int valor = Integer.parseInt(instructionArray[2]);
				if (valor >= 0)
					resultado = new ByteCode(ENUM_BYTECODE.valueOf(commandString), valor);
			}
			break;
		case ADD:
		case SUB:
		case MUL:
		case DIV:
		case OUT:
		case HALT:
			if (instructionArray.length == 2) {
				resultado = new ByteCode(ENUM_BYTECODE.valueOf(commandString));
			}
			break;
		}

		return resultado;*/
	}
}
