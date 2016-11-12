package TPMV;

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
	 * Devuelve el numero de elementos almacenados en la pila.
	 * 
	 * @return Numero de elementos en la pila.
	 */
	public int getLength() {
		return stack.length;
	}

	/**
	 * Introduce un valor en cima de la pila.
	 * 
	 * @param operando
	 *            Valor que introduce
	 * @return Éxito o fracaso de la operación.
	 */
	public boolean push(int operando) {
		if (contador < this.stack.length) {
			this.stack[contador++] = operando;
			return true;
		} else
			return false;
	}

	/**
	 * Saca el valor de la cima de la pila y lo devuelve.
	 * 
	 * @return Valor en la cima de la pila.
	 */
	public int pop() {
		if (contador > 0)
			return this.stack[--contador];
		else
			return this.stack[0];
	}

	/**
	 * Obtiene el valor almacenado en la cima de la pila.
	 * 
	 * @return Valor en la cima de la pila
	 */
	public int getLastPosition() {
		if (contador > 0)
			return stack[contador - 1];
		else
			return stack[0];

	}

	public String toString() {
		if (this.stack.length == 0) {
			return "<vacía>";
		} else {
			String resultado = "";
			for (int i = 0; i < contador; i++) {
				resultado += this.stack[i] + " ";
			}
			return resultado;
		}
	}

	/**
	 * Resetea la pila.
	 */
	public void reset() {
		contador = 0;
	}
}
