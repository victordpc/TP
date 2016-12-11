package ByteCode.Jumps.Conditional;

import ByteCode.Jumps.Jumps;
import TPMV.CPU;

/**
 * @author victor
 */
public abstract class Conditional extends Jumps {
	int cima;
	int subCima;

	/**
	 * Constructor de la clase
	 */
	public Conditional() {
	}

	/**
	 * Constructor de la clase
	 * 
	 * @param valor
	 *            posicion del programa a donde salta si se cumple la condiciÃ³n
	 */
	public Conditional(int valor) {
		super(valor);
	}

	/**
	 * Función de comparación del salto
	 * 
	 * @return {@code true} si hay que saltar, {@code false} en otro caso.
	 */
	public abstract boolean compare();

	@Override
	public boolean execute(CPU cpu) {
		if (cpu.getStackLength() >= 2) {
			this.cima = cpu.pop();
			this.subCima = cpu.pop();
			if (compare())
				cpu.setProgramCounter(posicion - 1);
			return true;
		}
		return false;
	}

}
