package ByteCode.Arithmetics;

import ByteCode.ByteCode;
import TPMV.CPU;

/**
 * Clase que representa la instrución {@code MUL}
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
	protected ByteCode parseAux() {
		return new Mul();
	}

	@Override
	protected boolean operador(String operador) {
		return operador.compareToIgnoreCase("Mul") == 0;
	}

	@Override
	protected boolean operar(CPU cpu) {
		return cpu.push(this.cima * this.subCima);
	}

	@Override
	public String toString() {
		return "MUL" + System.getProperty("line.separator");
	}

}
