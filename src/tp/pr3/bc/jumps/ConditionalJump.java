package tp.pr3.bc.jumps;

import tp.pr3.elements.CPU;
import tp.pr3.exceptions.StackException;

/**
 * @author victor
 */
public abstract class ConditionalJump extends Jump {

	/**
	 * Constructor de la clase
	 * 
	 * @param n
	 *            posicion del programa a donde salta si se cumple la condición
	 */
	public ConditionalJump(int n) {
		super(n);
	}

	/**
	 * Función de comparación del salto
	 * 
	 * @param c
	 *            valor de la cima para comparar
	 * @param sc
	 *            valor de la subcima para comparar
	 * @param cpu
	 *            TODO
	 * @return <code>true</code> si hay que saltar, <code>false</code> en otro
	 *         caso.
	 */
	public abstract boolean compares(int c, int sc, CPU cpu);

	/**
	 * Setter para la propiedad n
	 * 
	 * @param n
	 *            valor que se le asigna
	 */
	public void setN(int n) {
		this.n = n;
	}

	@Override
	public void execute(CPU cpu) throws StackException {
		int c = cpu.pop();
		int sc = cpu.pop();
		if (compares(c, sc, cpu))
			cpu.jump(n - 1);
	}

}
