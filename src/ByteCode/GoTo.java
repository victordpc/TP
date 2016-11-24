package ByteCode;

import TPMV.CPU;

/**
 * Clase que representa la instrución {@code GOTO}, salto incondicional a la
 * dirección del programa indicado
 * 
 * @author victor
 */
public class GoTo extends ByteCode {
	private int posicion;

	/**
	 * Constructor de la clase
	 */
	public GoTo() {
	}

	/**
	 * Constructor de la clase
	 * 
	 * @param posicion
	 *            dirección del programa a la que saltar
	 */
	public GoTo(int posicion) {
		this.posicion = posicion;
	}

	@Override
	public boolean execute(CPU cpu) {
		return cpu.goTo(this.posicion);
	}

	@Override
	public ByteCode parse(String[] s) {
		if (s.length == 2 && s[0].equalsIgnoreCase("GoTo")) {
			int val = Integer.parseInt(s[1]);
			return new GoTo(val);
		}
		return null;
	}
	public String toString()	{return "GOTO "+ this.posicion+System.getProperty("line.separator");}
}
