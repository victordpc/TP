package bytecode.oneparameter.conditional;

import bytecode.oneparameter.OneParameter;
import tpmv.CPU;

/**
 * @author victor
 */
public abstract class Conditional extends OneParameter {

	/**
	 * Constructor de la clase
	 */
	public Conditional() {
	}

	/**
	 * Constructor de la clase
	 * 
	 * @param valor
	 *            posicion del programa a donde salta si se cumple la condición
	 */
	public Conditional(int valor) {
		super(valor);
	}

	/**
	 * Función de comparación del salto
	 * 
	 * @param par1
	 *            valor de la cima para comparar
	 * @param par2
	 *            valor de la subcima para comparar
	 * 
	 * @return <code>true</code> si hay que saltar, <code>false</code> en otro
	 *         caso.
	 */
	public abstract boolean compare(int par1, int par2);

	@Override
	public boolean execute(CPU cpu) {
		if (cpu.getStackLength() >= 2) {
			int c = cpu.pop();
			int sc = cpu.pop();
			if (compare(c, sc))
				cpu.setProgramCounter(param - 1);
			return true;
		}
		return false;
	}

}
