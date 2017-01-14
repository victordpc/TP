package tp.pr3.bc.jumps;

import tp.pr3.elements.CPU;
import tp.pr3.exceptions.StackException;

/**
 * @author victor
 */
public abstract class ConditionalJump extends OneParameter {

	/**
	 * Constructor de la clase
	 */
	public ConditionalJump() {
	}

	/**
	 * Constructor de la clase
	 * 
	 * @param valor
	 *            posicion del programa a donde salta si se cumple la condición
	 */
	public ConditionalJump(int valor) {
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
	public boolean execute(CPU cpu) throws StackException {
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
