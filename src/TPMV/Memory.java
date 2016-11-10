package TPMV;

public class Memory {

	private Integer[] memory;
	private final int REDIM_SIZE = 1000;
	private boolean isEmpty;

	public Memory() {
		memory = new Integer[REDIM_SIZE];
		this.isEmpty = true;
	}

	public boolean write(int pos, int value) {
		boolean result = false;
		if (pos >= 0) {
			if (this.memory.length < pos) {
				resize(pos);
			}
			this.memory[pos] = value;
			result = true;
			this.isEmpty = false;
		}
		return result;
	}

	public Integer read(int pos) {
		Integer value;
		if (memory[pos] == null) {
			memory[pos] = 0;
			value = 0;
		} else {
			value = memory[pos];
		}
		return value;
	}

	public String toString() {
		String resultado = "";
		if (this.isEmpty) {
			resultado = "<vacía>";
		} else {
			for (int i = 0; i < this.memory.length; i++) {
				Integer value = this.memory[i];
				if (value != null) {
					resultado += "[" + i + "]:" + value.intValue() + " ";
				}
			}
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

	public void reset() {
		memory = new Integer[REDIM_SIZE];
	}

}
