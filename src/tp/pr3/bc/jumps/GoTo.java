package tp.pr3.bc.jumps;

import tp.pr3.bc.ByteCode;
import tp.pr3.elements.CPU;

/**
 * Clase que representa la instrución <code>GOTO</code>, salto incondicional a
 * la dirección del programa indicado
 *
 */
public class GoTo extends OneParameter {

	/**
	 * Constructor de la clase
	 */
	public GoTo() {
		super();
	}

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
	public boolean execute(CPU cpu) {
		return cpu.setProgramCounter(this.param - 1);
	}

	@Override
	public String toString() {
		return "GOTO " + this.param + System.getProperty("line.separator");
	}

	@Override
	protected ByteCode parseAux(String com, String par) {
		if (com.compareToIgnoreCase("GOTO") == 0) {
			int val = Integer.parseInt(par);
			return new GoTo(val);
		}
		return null;
	}
}
