package ByteCode.Arithmetics;

import ByteCode.ByteCode;
import TPMV.CPU;

/**
 * Clase que representa la instrución {@code ADD}
 * 
 * @author victor
 */
public class Add extends Arithmetics {

	/**
	 * Constructor de la clase
	 */
	public Add() {
		super();
	}

	@Override
	public String toString() {
		return "ADD" + System.getProperty("line.separator");
	}

	@Override
	protected boolean operador(String operador) {
		return operador.compareToIgnoreCase("Add") == 0;
	}

	@Override
	protected boolean operar(CPU cpu) {
		return cpu.push(this.subCima + this.cima);
	}

	@Override
	protected ByteCode parseAux() {
		return new Add();
	}
}
