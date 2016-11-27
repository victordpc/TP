package ByteCode.Jumps;

import ByteCode.ByteCode;
import TPMV.CPU;

/**
 * Clase que representa la instrución {@code GOTO}, salto incondicional a la
 * dirección del programa indicado
 * 
 * @author victor
 */
public class GoTo extends Jumps {

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
		return cpu.setProgramCounter(this.posicion);
	}

	@Override
	public String toString() {
		return "GOTO " + this.posicion + System.getProperty("line.separator");
	}

	@Override
	protected boolean operador(String operador) {
		return operador.compareToIgnoreCase("GOTO") == 0;
	}

	@Override
	protected ByteCode parseAux(int val) {
		return new GoTo(val);
	}
}
