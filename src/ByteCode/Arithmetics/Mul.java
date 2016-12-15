package ByteCode.Arithmetics;

import ByteCode.ByteCode;
import TPMV.CPU;

/**
 * Clase que representa la instrución <code>MUL</code>
 * 
 * @author victor
 */
public class Mul extends Arithmetics {

	/**
	 * Constructor de la clase
	 */
	public Mul() {
		super();
	}

	@Override
	public String toString() {
		return "MUL" + System.getProperty("line.separator");
	}

	@Override
	protected boolean operador(String operador) {
		return operador.compareToIgnoreCase("Mul") == 0;
	}

	@Override
	protected boolean operar(CPU cpu) {
		return cpu.push(this.subCima * this.cima);
	}

	@Override
	protected ByteCode parseAux() {
		return new Mul();
	}

}
