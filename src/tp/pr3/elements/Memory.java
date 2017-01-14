package tp.pr3.elements;

/**
 * Clase que representa la memoria de la máquina virtual.
 */
public class Memory {

	private Integer[] memory;
	private final int REDIM_SIZE = 1000;

	/**
	 * Constructor de la clase.
	 */
	public Memory() {
		this.memory = new Integer[REDIM_SIZE];
	}

	/**
	 * Lee el valor de una dirección de memoria.
	 * 
	 * @param pos
	 *            dirección de memoria en la que se lee.
	 * 
	 * @return valor almacenado en la dirección de memoria indicada
	 */
	public int read(int pos) {
		if (pos >= 0)
			if (this.memory[pos] != null)
				return this.memory[pos];

		return 0;
	}

	/**
	 * Resetea la memoria.
	 */
	public void reset() {
		this.memory = new Integer[REDIM_SIZE];
	}

	@Override
	public String toString() {
		String resultado = "Memoria: ";
		boolean isEmpty = true;

		for (int i = 0; i < this.memory.length; i++) {
			Integer value = this.memory[i];
			if (value != null) {
				resultado += "[" + i + "]:" + value.intValue() + " ";
				isEmpty = false;
			}
		}

		if (isEmpty) {
			resultado += "<vacia>";
		}

		return resultado;
	}

	/**
	 * Escribe un valor en una dirección de la memoria.
	 * 
	 * @param pos
	 *            direccion en la que se escribe.
	 * 
	 * @param value
	 *            valor a almacenar
	 * 
	 * @return <code>true</code> exito de la operacion, <code>false</code> en
	 *         otro caso
	 */
	public boolean write(int pos, int value) {
		boolean result = false;
		if (pos >= 0) {
			if (this.memory.length < pos) {
				resize(pos);
			}
			this.memory[pos] = value;
			result = true;
		}
		return result;
	}

	/**
	 * Redimensiona la memoria
	 * 
	 * @param pos
	 *            tamaño objetivo de la memoria, para redimensionar se aplica la
	 *            formula: (tamaño final) = [ pos / (tamaño inicial) ] * (tamaño
	 *            inicial)
	 */
	private void resize(int pos) {
		int newSize = ((pos / REDIM_SIZE) + 1) * REDIM_SIZE;
		Integer auxiliar[] = new Integer[newSize];
		for (int i = 0; i < this.memory.length; i++) {
			auxiliar[i] = this.memory[i];
		}
		this.memory = auxiliar;
	}
}
