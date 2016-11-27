package ByteCode;

import ByteCode.Arithmetics.Add;
import ByteCode.Arithmetics.Div;
import ByteCode.Arithmetics.Mul;
import ByteCode.Arithmetics.Sub;
import ByteCode.Jumps.GoTo;
import ByteCode.Jumps.Conditional.IfEq;
import ByteCode.Jumps.Conditional.IfLe;
import ByteCode.Jumps.Conditional.IfLeq;
import ByteCode.Jumps.Conditional.IfNeq;

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
