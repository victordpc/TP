package tp.pr3.bc.jumps;

import tp.pr3.bc.ByteCode;
import tp.pr3.elements.CPU;

/**
 * Clase que representa la instrución <code>GOTO</code>, salto incondicional a
 * la dirección del programa indicado
 *
 */
public class GoTo extends Jump {

	/**
	 * Constructor de la clase
	 * 
	 * @param posicion
	 *            dirección del programa a la que saltar
	 */
	public GoTo(int posicion) {
		super(posicion);
	}

	@Override
	public void execute(CPU cpu) {
		cpu.jump(this.n - 1);
	}

	@Override
	public String toString() {
		return "GOTO " + this.n + System.getProperty("line.separator");
	}

	@Override
	protected ByteCode parseJump(String s, int n) {
		if (s.compareToIgnoreCase("GOTO") == 0) {
			return new GoTo(n);
		}
		return null;
	}
}
