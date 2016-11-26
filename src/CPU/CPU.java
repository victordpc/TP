package CPU;

import ByteCode.ByteCode;
import ByteCode.ByteCodeProgram;

/**
 * Clase que contiene el procesamiento de la maquina virtual, contiene una
 * memoria y una pila de operandos.
 */
public class CPU {

	private final Memory memory;
	private final OperandStack stack;
	private boolean halt;
	private ByteCodeProgram byteCodeProgram;
	private int programCounter;

	/**
	 * Constructor de la clase.
	 */
	public CPU() {
		this.memory = new Memory();
		this.stack = new OperandStack();
		this.halt = false;
		this.programCounter = 0;
	}

	public boolean push(int value) {
		return this.stack.push(value);
	}

	public boolean store(int value) {
		if (this.stack.getLength() >= 1) {
			return this.memory.write(value, this.stack.pop());
		}
		return false;
	}

	public boolean load(int value) {
		int valor = this.memory.read(value);
		return this.stack.push(valor);
	}

	public int pop() {
		return this.stack.pop();
	}

	public int read(int position) {
		return this.memory.read(position);
	}

	public boolean write(int position) {
		return this.memory.write(position, this.stack.pop());
	}

	public void goTo(int n) {
		this.programCounter = n;
	}

	public int numeroValoresEnPila() {
		return this.stack.getContador();
	}

	public boolean replace(int position, ByteCode newByteCode) {
		byteCodeProgram.replace(position, newByteCode);
		System.out.println(byteCodeProgram.toString() + System.getProperty("line.separator"));
		return true;
	}

	public boolean run() {
		boolean success = true;
		boolean seguir = true;
		while (seguir && success && !this.isHalted()) {
			ByteCode byteCode = this.byteCodeProgram.getProgram(programCounter);
			programCounter++;
			if (byteCode != null) {
				success = byteCode.execute(this);
				if(!success) {
					System.out.println("Falla " +byteCode.toString() + " Position " +programCounter);
				}
			} else {
				seguir = false;
			}
		}

		if (success) {
			System.out.println("El estado de la maquina tras ejecutar programa es: " + System.getProperty("line.separator") 
			+ this.toString());
		}
		return success;
	}

	/**
	 * Ejecuta el {@code ByteCode} recibido por parametro.
	 * 
	 * @param instruccion
	 *            instrucción a ejecutar.
	 * 
	 * @return {@code true} exito de la operacion, {@code false} en otro caso
	 */
	public boolean execute(ByteCode instruccion) {
		return instruccion.execute(this);
	}

	@Override
	public String toString() {
		String resultado = "Estado de la CPU: " + System.getProperty("line.separator");
		resultado += this.memory.toString() + System.getProperty("line.separator");
		resultado += this.stack.toString() + System.getProperty("line.separator")
				+ System.getProperty("line.separator");
		return resultado;
	}

	public void setByteCodeProgram(ByteCodeProgram newByteCodeProgram) {
		this.byteCodeProgram = newByteCodeProgram;
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
	 * Reinicia la memoria y la pila.
	 */
	public void reset() {
		this.memory.reset();
		this.stack.reset();
		this.byteCodeProgram.reset();
	}
}
