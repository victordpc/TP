package ByteCode;

import java.util.Arrays;

import Arithmetics.*;
import ConditionalJumps.*;

/**
 * Clase que se encarga de convertir textos en {@code ByteCode}
 */
public class ByteCodeParser {

	private final static ByteCode[] byteCodes = { new Push(), new Load(), new Store(), new Halt(), new Out(), new Add(),
			new Div(), new Mult(), new Sub(), new IFEQ(), new IFLE(), new IFLEQ(), new IFNEQ(), new GoTo() };

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
		if(byteCode == null){
			System.out.println("BYTECODE MAL " +Arrays.toString(linea));
		}
		return byteCode;
	}
}
