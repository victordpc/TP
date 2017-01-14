package tp.pr3.elements;

import tp.pr3.bc.ByteCode;
import tp.pr3.mv.ByteCodeProgram;
import tp.pr3.exceptions.ArrayException;
import tp.pr3.exceptions.ExecutionErrorException;
import tp.pr3.exceptions.StackException;

/**
 * Clase que contiene el procesamiento de la maquina virtual, contiene una
 * memoria y una pila de operandos.
 */
public class CPU {

	private boolean halt;
	private final Memory memory;
	private final OperandStack stack;
	private ByteCodeProgram bcProgram = null;
	private int programCounter;

	/**
	 * Constructor de la clase.
	 * 
	 * @param prog
	 *            programa de ByteCodes para cargar
	 */
	public CPU(ByteCodeProgram prog) {
		this.memory = new Memory();
		this.stack = new OperandStack();
		this.halt = false;
		this.programCounter = 0;
		this.bcProgram = prog;
	}

	/**
	 * Avanza el contador de programa
	 */
	public void avanzaPc() {
		this.programCounter++;
	}

	/**
	 * Obtiene el numero de elementos que hay actualmente en la pila
	 * 
	 * @return numero de posiciones de la pila
	 */
	public int getStackLength() {
		return this.stack.getLength();
	}

	/**
	 * Ejecuta el <code>bytecode</code> <code>HALT</code>, para la ejecución del
	 * programa.
	 * 
	 * @return <code>true</code> exito de la operacion, <code>false</code> en
	 *         otro caso
	 */
	public boolean halt() {
		this.halt = true;
		return true;
	}

	/**
	 * Devuelve el valor del atributo halt.
	 * 
	 * @return valor del atributo halt
	 */
	public boolean isHalted() {
		return this.halt;
	}

	/**
	 * Lee el valor de una dirección de memoria.
	 * 
	 * @param posicion
	 *            dirección de memoria en la que se lee.
	 * 
	 * @return valor almacenado en la dirección de memoria indicada
	 */
	public int load(int posicion) {
		return this.memory.read(posicion);
	}

	/**
	 * Ejecuta el <code>bytecode</code> <code>OUT</code>, muestra la cima de la
	 * pila.
	 * 
	 * @return <code>true</code> exito de la operacion, <code>false</code> en
	 *         otro caso
	 */
	public boolean out() {
		Integer valorPila = this.stack.getLasValue();
		if (valorPila != null)
			System.out.println("consola: " + valorPila);
		else
			System.out.println("La pila no contiene valores");
		return true;
	}

	/**
	 * Obtiene la cima de la pila.
	 * 
	 * @return valor almacenado en la cima de la pila.
	 */
	public int pop() throws StackException {
		return this.stack.pop();
	}

	/**
	 * Introduce un valor en la cima de la pila.
	 * 
	 * @param valor
	 *            valor a introducir en la pila.
	 * 
	 * @return <code>true</code> exito de la operacion, <code>false</code> en
	 *         otro caso
	 */
	public boolean push(int valor) throws StackException {
		return this.stack.push(valor);
	}

	/**
	 * Reinicia la memoria y la pila.
	 */
	public void reset() {
		this.memory.reset();
		this.stack.reset();
		this.halt = false;
		this.programCounter = 0;
	}

	/**
	 * Ejecutar el programa <code>bytecode</code> completo.
	 * 
	 * @return <code>true</code> exito de la operacion, <code>false</code> en
	 *         otro caso
	 */
	public boolean run() throws ExecutionErrorException, ArrayException {
		boolean correcto = true;
		this.reset();
        int i = 0;
		while (correcto && !halt) {
			ByteCode byteCode = null;
			try {
                byteCode = this.bcProgram.getProgram(programCounter);
				if (byteCode != null)
					correcto = byteCode.execute(this);
				else
					correcto = false;
				this.avanzaPc();
			}catch (ExecutionErrorException e) {
				throw new ExecutionErrorException("Excepcion en la ejecucion del bytecode " + byteCode.getClass().getSimpleName() + " En la posición " +i +System.getProperty("line.separator") + e.getMessage());
			}catch (ArrayException e) {
                throw new ExecutionErrorException("Excepcion en la ejecucion del bytecode " + byteCode.getClass().getSimpleName() + " En la posición " +i +System.getProperty("line.separator") + e.getMessage());
            }
			i++;
		}

		return correcto;
	}

	/**
	 * Establece el contador de programa
	 * 
	 * @param programCounter
	 *            direccion del programa a la que saltar
	 * 
	 * @return <code>true</code> exito de la operacion, <code>false</code> en
	 *         otro caso
	 */
	public boolean setProgramCounter(int programCounter) {
		if (programCounter >= 0 && programCounter < bcProgram.getLength()) {
			this.programCounter = programCounter;
			return true;
		}

		return false;
	}

	/**
	 * Introduce un valor en una poición de memoria
	 * 
	 * @param valor
	 *            valor que se introduce en memoria
	 * 
	 * @param posicion
	 *            dirección de memoria en la que se guarda.
	 * 
	 * @return <code>true</code> exito de la operacion, <code>false</code> en
	 *         otro caso
	 */
	public boolean store(int posicion, int valor) {
		return this.memory.write(posicion, valor);
	}

	@Override
	public String toString() {
		String resultado = "Estado de la CPU: " + System.getProperty("line.separator");
		resultado += this.memory.toString() + System.getProperty("line.separator");
		resultado += this.stack.toString() + System.getProperty("line.separator");
		return resultado;
	}

}
