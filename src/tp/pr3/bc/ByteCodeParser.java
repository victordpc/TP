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
 * Clase que se encarga de convertir textos en <code>ByteCode</code>
 */
public class ByteCodeParser {
	private final static ByteCode[] bytecodes = { new Add(), new Div(), new Halt(), new Load(0), new Mul(), new Out(),
			new Push(0), new Store(0), new Sub(), new GoTo(0), new IfEq(0), new IfLe(0), new IfLeq(0), new IfNeq(0) };

	/**
	 * Constructor de la clase
	 */
	public ByteCodeParser() {
	}

	/**
	 * Convierte un texto a un objeto de tipo <code>ByteCode</code>.
	 * 
	 * @param line
	 *            cadena de texto.
	 * 
	 * @return <code>ByteCode</code> correspondiente al texto, si es incorrecto
	 *         devuelve <code>null</code>.
	 */
	public static ByteCode parse(String line) {
		String[] instructionArray = line.split(" ");

		for (ByteCode instruccion : bytecodes) {
			ByteCode ins = instruccion.parse(instructionArray);

			if (ins != null)
				return ins;
		}
		return null;
	}
}
