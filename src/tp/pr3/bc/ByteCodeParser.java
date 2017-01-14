package tp.pr3.bc;

import tp.pr3.bc.arithmetics.Add;
import tp.pr3.bc.arithmetics.Div;
import tp.pr3.bc.arithmetics.Mul;
import tp.pr3.bc.arithmetics.Sub;
import tp.pr3.bc.jumps.GoTo;
import tp.pr3.bc.jumps.conditionaljumps.IfEq;
import tp.pr3.bc.jumps.conditionaljumps.IfLe;
import tp.pr3.bc.jumps.conditionaljumps.IfLeq;
import tp.pr3.bc.jumps.conditionaljumps.IfNeq;

/**
 * Clase que se encarga de convertir textos en <code>bytecode</code>
 */
public class ByteCodeParser {
	private final static ByteCode[] instructions = { new Add(), new Div(), new Halt(), new Load(), new Mul(), new Out(),
			new Push(), new Store(), new Sub(), new GoTo(), new IfEq(), new IfLe(), new IfLeq(), new IfNeq() };

	/**
	 * Convierte un texto a un objeto de tipo <code>bytecode</code>.
	 * 
	 * @param linea
	 *            cadena de texto.
	 * 
	 * @return <code>bytecode</code> correspondiente al texto, si es incorrecto
	 *         devuelve <code>null</code>.
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
