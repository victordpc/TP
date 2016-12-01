package ByteCode.Arithmetics;

import ByteCode.ByteCode;
import TPMV.CPU;

/**
 * Clase que representa la instrución {@code SUB}
 * 
 * @author victor
 */
public class Sub extends Arithmetics {

	/**
	 * Constructor de la clase
	 */
	public Sub() {
		super();
	}

	@Override
	public String toString() {
		return "SUB" + System.getProperty("line.separator");
	}

	@Override
	protected boolean operador(String operador) {
		return operador.compareToIgnoreCase("Sub") == 0;
	}

	@Override
	protected boolean operar(CPU cpu) {
		return cpu.push(this.subCima - this.cima);
	}

	@Override
	protected ByteCode parseAux() {
		return new Sub();
	}

}
