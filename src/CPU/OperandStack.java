package CPU;

/**
 * Clase que representa una pila de valores enteros.
 */
public class OperandStack {

	private int stack[];
	private int contador;
	private int STACK_SIZE = 1000;

	/**
	 * Constructor de la clase.
	 */
	public OperandStack() {
		this.stack = new int[STACK_SIZE];
		this.contador = 0;
	}

	/**
	 * Devuelve el número de elementos almacenados en la pila.
	 * 
	 * @return número de elementos en la pila.
	 */
	public int getLength() {
		return this.stack.length;
	}

	/**
	 * Introduce un valor en cima de la pila.
	 * 
	 * @param operando
	 *            valor que introduce
	 * @return {@code true} exito de la operacion, {@code false} en otro caso
	 */
	public boolean push(int operando) {
		if (this.contador < this.stack.length) {
			this.stack[this.contador++] = operando;
			return true;
		} else
			return false;
	}

	/**
	 * Saca el valor de la cima de la pila y lo devuelve.
	 * 
	 * @return valor en la cima de la pila.
	 */
	public int pop() {
		if (this.contador > 0) {
			return this.stack[--this.contador];
		}
		return 0;
	}

	public String toString() {
		String resultado = "Pila: ";
		if (this.contador == 0) {
			return resultado + "<vacia>";
		} else {
			for (int i = 0; i < this.contador; i++) {
				resultado += this.stack[i] + " ";
			}
			return resultado;
		}
	}

	/**
	 * Resetea la pila.
	 */
	public void reset() {
		this.contador = 0;
	}
	
	public int getContador() {
		return this.contador;
	}
}
