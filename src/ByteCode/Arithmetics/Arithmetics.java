package ByteCode.Arithmetics;

import ByteCode.ByteCode;
import TPMV.CPU;

/**
 * @author victor
 *
 */
public abstract class Arithmetics extends ByteCode {
	protected int cima;
	protected int subCima;

	/**
	 * Constructor de la clase
	 */
	public Arithmetics() {
		super();
	}

	@Override
	public boolean execute(CPU cpu) {
		if (cpu.getStackLength() >= 2) {
			this.cima = cpu.pop();
			this.subCima = cpu.pop();

			return operar(cpu);
		}
		return false;
	}

	@Override
	public ByteCode parse(String[] s) {
		if (s.length == 1 && operador(s[0])) {
			return parseAux();
		}
		return null;
	}

	/**
	 * Comprueba si el texto es un operador aritmetico válido
	 * 
	 * @param operador
	 *            texto del operador
	 * @return <code>true</code> si es un operador aritmetico, <code>false</code> en otro
	 *         caso
	 */
	protected abstract boolean operador(String operador);

	protected abstract boolean operar(CPU cpu);

	/**
	 * Realiza el parseo específico del salto
	 * 
	 * @return <code>ByteCode</code> correspondiente a la operación, si es incorrecto
	 *         devuelve <code>null</code>.
	 */
	protected abstract ByteCode parseAux();
}
