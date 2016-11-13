package TPMV;

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
	 * Escribe un valor en una dirección de la memoria.
	 * 
	 * @param pos
	 *            direccion en la que se escribe.
	 * @param value
	 *            valor a almacenar
	 * @return {@code true} exito de la operacion, {@code false} en otro caso
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
	 * Lee el valor de una dirección de memoria.
	 * 
	 * @param pos
	 *            dirección de memoria en la que se lee.
	 * @return valor almacenado en la dirección de memoria indicada
	 */
	public Integer read(int pos) {
		if (pos >= 0)
			return this.memory[pos];
		else
			return null;
	}

	public String toString() {
		String resultado = "Memoria: ";
		boolean isEmpty=true;
		
		for (int i = 0; i < this.memory.length; i++) {
			Integer value = this.memory[i];
			if (value != null) {
				resultado += "[" + i + "]:" + value.intValue() + " ";
				isEmpty=false;
			}
		}

		if (isEmpty) {
			resultado = "<vacia>";
		}
		
		return resultado;
	}

	private void resize(int pos) {
		int newSize = ((pos / REDIM_SIZE) + 1) * REDIM_SIZE;
		Integer auxiliar[] = new Integer[newSize];
		for (int i = 0; i < this.memory.length; i++) {
			auxiliar[i] = this.memory[i];
		}
		this.memory = auxiliar;
	}

	/**
	 * Resetea la memoria.
	 */
	public void reset() {
		this.memory = new Integer[REDIM_SIZE];
	}

}
