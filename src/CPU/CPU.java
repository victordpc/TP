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

	public boolean replace(int position, ByteCode newByteCode) {
		byteCodeProgram.replace(position, newByteCode);
		System.out.println(byteCodeProgram.toString() + System.getProperty("line.separator"));
		return true;
	}

	public boolean run() {
		boolean resultado = true;
		for (int i = 0; i < this.programCounter && !this.isHalted() && resultado; i++) {
			ByteCode byteCode = this.byteCodeProgram.getProgram(i);
			resultado = this.execute(byteCode);
//			if (this.execute(byteCode)) {
//				System.out.println("El estado de la maquina tras ejecutar el bytecode " + byteCode.toString() + " es:"
//						+ System.getProperty("line.separator") + this.cpu.toString()
//						+ System.getProperty("line.separator"));
//			} else {
//				System.out.println("Error: Ejecucion incorrecta del comando " + System.getProperty("line.separator")
//						+ this.byteCodeProgram.toString() + System.getProperty("line.separator") + this.cpu.toString()
//						+ System.getProperty("line.separator"));
//				resultado = false;
//			}
		}
		this.reset();
		return resultado;
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

		/**
		 * boolean success = false; int value1; int value2; switch
		 * (instruccion.getName()) { case PUSH: success =
		 * this.stack.push(instruccion.getParam()); break; case STORE: if
		 * (this.stack.getLength() >= 1) { success =
		 * this.memory.write(instruccion.getParam(), this.stack.pop()); } break;
		 * case LOAD: Integer valor = this.memory.read(instruccion.getParam());
		 * if (valor != null) success = this.stack.push(valor); break; case ADD:
		 * if (this.stack.getLength() >= 2) { value2 = this.stack.pop(); value1
		 * = this.stack.pop(); success = this.stack.push(value1 + value2); }
		 * break; case SUB: if (this.stack.getLength() >= 2) { value2 =
		 * this.stack.pop(); value1 = this.stack.pop(); success =
		 * this.stack.push(value1 - value2); } break; case MUL: if
		 * (this.stack.getLength() >= 2) { value2 = this.stack.pop(); value1 =
		 * this.stack.pop(); this.stack.push(value1 * value2); success = true; }
		 * break; case DIV: if (this.stack.getLength() >= 2) { value2 =
		 * this.stack.pop(); value1 = this.stack.pop(); if (value2 != 0)
		 * this.stack.push(value1 / value2); else { this.stack.push(value2);
		 * this.stack.push(value1); success=false; }
		 * 
		 * success = true; } break; case HALT: this.halt = true; break; case
		 * OUT: Integer valorPila = this.stack.getLastPosition(); if (valorPila
		 * != null) System.out .println("El ultimo valor en la pila es: " +
		 * valorPila + System.getProperty("line.separator")); else
		 * System.out.println("La pila no contiene valores"); break; default:
		 * break; } return success;
		 */
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
