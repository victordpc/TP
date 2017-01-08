package bytecode;

import bytecode.arithmetics.Add;
import bytecode.arithmetics.Div;
import bytecode.arithmetics.Mul;
import bytecode.arithmetics.Sub;
import bytecode.oneparameter.GoTo;
import bytecode.oneparameter.Load;
import bytecode.oneparameter.Push;
import bytecode.oneparameter.Store;
import bytecode.oneparameter.conditional.IfEq;
import bytecode.oneparameter.conditional.IfLe;
import bytecode.oneparameter.conditional.IfLeq;
import bytecode.oneparameter.conditional.IfNeq;

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
