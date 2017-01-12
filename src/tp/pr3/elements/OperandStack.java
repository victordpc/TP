package tp.pr3.elements;

import tp.pr3.exceptions.StackException;

/**
 * Clase que representa una pila de valores enteros.
 */
public class OperandStack {

	private int contador;
	private int stack[];
	private int STACK_SIZE = 1000;

	/**
	 * Constructor de la clase.
	 */
	public OperandStack() {
		this.stack = new int[STACK_SIZE];
		this.contador = 0;
	}

	/**
	 * Comprueba si la pila esta vacia
	 * 
	 * @return <code>true</code> si la pila esta vacia, <code>false</code> en
	 *         otro caso
	 */
	public boolean emptyStack() {
		return contador == 0;
	}

	/**
	 * Saca el valor de la cima de la pila y lo devuelve.
	 * 
	 * @return valor en la cima de la pila.
	 * @throws StackException
	 *             si la pila esta vacía
	 */
	public int pop() throws StackException {
		if (this.contador > 0)
			return this.stack[--this.contador];
		else
			throw new StackException("No existen valores en la pila");
	}

	/**
	 * Introduce un valor en cima de la pila.
	 * 
	 * @param operando
	 *            valor que introduce
	 * 
	 * @return <code>true</code> exito de la operacion, <code>false</code> en
	 *         otro caso
	 * @throws StackException
	 *             pila llena
	 */
	public boolean push(int operando) throws StackException {
		if (!this.stackOverflow()) {
			this.stack[this.contador++] = operando;
			return true;
		}
		throw new StackException("Pila de operandos llena.");
	}

	/**
	 * Resetea la pila.
	 */
	public void reset() {
		this.contador = 0;
	}

	/**
	 * Comprueba si la pila esta desbordada
	 * 
	 * @return <code>true</code> si la pila esta desbordada, <code>false</code>
	 *         en otro caso
	 */
	public boolean stackOverflow() {
		return this.contador >= this.stack.length;
	}

	@Override
	public String toString() {
		String resultado = "Pila: ";
		if (this.contador == 0) {
			return resultado += "<vacia>";
		} else {
			for (int i = 0; i < this.contador; i++) {
				resultado += this.stack[i] + " ";
			}
			return resultado;
		}
	}

}
