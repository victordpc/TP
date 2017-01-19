package tp.pr3.elements;

import tp.pr3.bc.ByteCode;
import tp.pr3.exceptions.ArrayException;
import tp.pr3.exceptions.ExecutionErrorException;
import tp.pr3.exceptions.StackException;
import tp.pr3.mv.ByteCodeProgram;

/**
 * Clase que contiene el procesamiento de la maquina virtual, contiene una
 * memoria y una pila de operandos.
 */
public class CPU {

	private ByteCodeProgram bcProgram = null;
	private boolean halt;
	private final Memory memory;
	private int programCounter;
	private final OperandStack stack;

	/**
	 * Constructor de la clase.
	 * 
	 * @param prog
	 *            programa de ByteCodes para cargar
	 */
	public CPU(ByteCodeProgram prog) {
		memory = new Memory();
		stack = new OperandStack();
		this.halt = false;
		this.programCounter = 0;
		this.bcProgram = prog;
	}

	/**
	 * Añade un ByteCode al programa
	 * 
	 * @param bc
	 *            ByteCode a añadir
	 * @param pos
	 *            posicion donde se añade
	 * @throws ArrayException
	 *             para contemplar errores de acceso a posiciones incorrectas de
	 *             un array
	 */
	public void addByteCode(ByteCode bc, int pos) throws ArrayException {

	}

	/**
	 * Comprueba si la pila esta vacia
	 * 
	 * @return <code>true</code> si la pila esta vacia, <code>false</code> en
	 *         otro caso
	 */
	public boolean emptyStack() {
		return this.stack.emptyStack();
	}

	/**
	 * Ejecuta el <code>ByteCode</code> <code>HALT</code>, para la ejecución del
	 * programa.
	 */
	public void finish() {
		this.halt = true;
	}

	/**
	 * Vacía la memoria y la pila de operandos
	 */
	public void initialize() {
		this.memory.empty();
		this.stack.reset();
	}

	/**
	 * Establece el contador de programa
	 * 
	 * @param n
	 *            direccion del programa a la que saltar
	 */
	public void jump(int n) {
		this.programCounter = n;
	}

	/**
	 * Avanza el contador de programa
	 */
	public void next() {
		this.programCounter++;
	}

	/**
	 * Ejecuta el <code>ByteCode</code> <code>OUT</code>, muestra la cima de la
	 * pila.
	 * 
	 * @throws StackException
	 *             Detecta errores que se producen en la pila de operandos al
	 *             ejecutar un bytecode
	 */
	public void out() throws StackException {
		int valorPila = this.stack.pop();
		System.out.println("El ultimo valor en la pila es: " + valorPila + System.getProperty("line.separator"));
	}

	/**
	 * Obtiene la cima de la pila.
	 * 
	 * @return valor almacenado en la cima de la pila.
	 * @throws StackException
	 *             pila vacía
	 */
	public int pop() throws StackException {
		return this.stack.pop();
	}

	/**
	 * Introduce un valor en la cima de la pila.
	 * 
	 * @param valor
	 *            valor a introducir en la pila.
	 * @throws StackException
	 *             pila llena
	 */
	public void push(int valor) throws StackException {
		this.stack.push(valor);
	}

	/**
	 * Lee el valor de una dirección de memoria.
	 * 
	 * @param pos
	 *            dirección de memoria en la que se lee.
	 * 
	 * @return valor almacenado en la dirección de memoria indicada
	 */
	public Integer read(int pos) {
		return this.memory.read(pos);
	}

	/**
	 * Reinicia la memoria y la pila.
	 */
	public void reset() {
		initialize();
		this.halt = false;
		this.programCounter = 0;
	}

	/**
	 * Ejecutar el programa <code>ByteCode</code> completo.
	 * 
	 * @return <code>true</code> exito de la operacion, <code>false</code> en
	 *         otro caso
	 * @throws ExecutionErrorException
	 *             fallo en la ejecución del programa
	 */
	public boolean run() throws ExecutionErrorException {
		boolean correcto = true;
		this.reset();
		int i = 0;
		while (correcto && !halt) {
			ByteCode byteCode = null;
			try {
				byteCode = this.bcProgram.getInst(programCounter);
				if (byteCode != null)
					byteCode.execute(this);
				else
					correcto = false;
				this.next();
			}catch (ExecutionErrorException e) {
				throw new ExecutionErrorException("Excepcion en la ejecucion del bytecode " + byteCode.getClass().getSimpleName() + " En la posición " +i +System.getProperty("line.separator") + e.getMessage());
			}catch (ArrayException e) {
                throw new ExecutionErrorException("Excepcion en la ejecucion del bytecode " + byteCode.getClass().getSimpleName() + " En la posición " +i +System.getProperty("line.separator") + e.getMessage());
            }
		}
		return correcto;
	}

	/**
	 * Comprueba si la pila esta desbordada
	 * 
	 * @return <code>true</code> si la pila esta desbordada, <code>false</code>
	 *         en otro caso
	 */
	public boolean stackOverflow() {
		return this.stack.stackOverflow();
	}

	@Override
	public String toString() {
		String resultado = "Estado de la CPU: " + System.getProperty("line.separator");
		resultado += this.memory.toString() + System.getProperty("line.separator");
		resultado += this.stack.toString() + System.getProperty("line.separator");
		resultado += this.bcProgram.toString() + System.getProperty("line.separator");
		return resultado;
	}

	/**
	 * Introduce un valor en una poición de memoria
	 * 
	 * @param value
	 *            valor que se introduce en memoria
	 * 
	 * @param pos
	 *            dirección de memoria en la que se guarda.
	 */
	public void write(int pos, int value) {
		this.memory.write(pos, value);
	}

}
