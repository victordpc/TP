
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
		return this.stack.length;
	}

	/**
	 * Introduce un valor en cima de la pila.
	 * 
	 * @param operando
	 *            Valor que introduce
	 * @return Exito o fracaso de la operacion.
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
	 * @return Valor en la cima de la pila.
	 */
	public int pop() {
		if (this.contador > 0)
			return this.stack[--this.contador];
		else
			return this.stack[0];
	}

	/**
	 * Obtiene el valor almacenado en la cima de la pila.
	 * 
	 * @return Valor en la cima de la pila
	 */
	public int getLastPosition() {
		if (this.contador > 0)
			return this.stack[this.contador - 1];
		else
			return this.stack[0];

	}

	public String toString() {
		if (this.stack.length == 0) {
			return "<vacia>";
		} else {
			String resultado = "Pila: ";
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
}
