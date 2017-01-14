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
	 * Obtiene el valor almacenado en la cima de la pila.
	 * 
	 * @return valor en la cima de la pila
	 */
	public Integer getLasValue() {
		if (this.contador > 0)
			return this.stack[--this.contador];
		else
			return null;
	}

	/**
	 * Devuelve el número de elementos almacenados en la pila.
	 * 
	 * @return número de elementos en la pila.
	 */
	public int getLength() {
		return contador;
	}

	/**
	 * Saca el valor de la cima de la pila y lo devuelve.
	 * 
	 * @return valor en la cima de la pila.
	 */
	public int pop() throws StackException {
		int valor = 0;
		if (this.contador > 0) {
            valor = this.stack[--this.contador];
        }else {
		    throw new StackException("Tamaño de pila insuficiente");
        }
		return valor;
	}

	/**
	 * Introduce un valor en cima de la pila.
	 * 
	 * @param operando
	 *            valor que introduce
	 * 
	 * @return <code>true</code> exito de la operacion, <code>false</code> en
	 *         otro caso
	 */
	public boolean push(int operando) throws StackException {
		if (this.contador < this.stack.length) {
			this.stack[this.contador++] = operando;
			return true;
		}else {
			throw new StackException("Stack Overflow exception");
		}
	}

	/**
	 * Resetea la pila.
	 */
	public void reset() {
		this.contador = 0;
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
