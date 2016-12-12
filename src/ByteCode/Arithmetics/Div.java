package ByteCode.Arithmetics;

import ByteCode.ByteCode;
import TPMV.CPU;

/**
 * Clase que representa la instrución <code>DIV</code>
 * 
 * @author victor
 */
public class Div extends Arithmetics {

	/**
	 * Constructor de la clase
	 */
	public Div() {
		super();
	}

	@Override
	public String toString() {
		return "DIV" + System.getProperty("line.separator");
	}

	@Override
	protected boolean operador(String operador) {
		return operador.compareToIgnoreCase("Div") == 0;
	}

	@Override
	protected boolean operar(CPU cpu) {
		if (this.subCima != 0) {
			return cpu.push(this.subCima / this.cima);
		}
		return false;
	}

	@Override
	protected ByteCode parseAux() {
		return new Div();
	}

}
