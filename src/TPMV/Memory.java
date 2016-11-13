package TPMV;

/**
 * Clase que representa la memoria de la maquina virtual.
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
	 * Escribe un valor en una direccion de la memoria.
	 * 
	 * @param pos
	 *            Direccion en la que se escribe.
	 * @param value
	 *            Valor a almacenar
	 * @return Exito o fracaso de la operacion.
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
	 * Lee el valor de una direccion de memoria.
	 * 
	 * @param pos
	 *            Direccion de memoria en la que se lee.
	 * @return Valor almacenado en la direccion de memoria indicada
	 */
	public Integer read(int pos) {
		Integer value;
		if (this.memory[pos] == null) {
			this.memory[pos] = 0;
			value = 0;
		} else {
			value = this.memory[pos];
		}
		return value;
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
