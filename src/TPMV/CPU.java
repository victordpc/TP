package TPMV;

/**
 * Clase que contiene el procesamiento de la maquina virtual, contiene una
 * memoria y una pila de operandos.
 */
public class CPU {

	private final Memory memory;
	private final OperandStack stack;
	private boolean halt;

	/**
	 * Constructor de la clase.
	 */
	public CPU() {
		this.memory = new Memory();
		this.stack = new OperandStack();
		this.halt = false;
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
		boolean success = false;
		int value1;
		int value2;
		switch (instruccion.getName()) {
		case PUSH:
			success = this.stack.push(instruccion.getParam());
			break;
		case STORE:
			if (this.stack.getLength() >= 1) {
				success = this.memory.write(instruccion.getParam(), this.stack.pop());
			}
			break;
		case LOAD:
			Integer valor = this.memory.read(instruccion.getParam());
			if (valor != null)
				success = this.stack.push(valor);
			break;
		case ADD:
			if (this.stack.getLength() >= 2) {
				value2 = this.stack.pop();
				value1 = this.stack.pop();
				success = this.stack.push(value1 + value2);
			}
			break;
		case SUB:
			if (this.stack.getLength() >= 2) {
				value2 = this.stack.pop();
				value1 = this.stack.pop();
				success = this.stack.push(value1 - value2);
			}
			break;
		case MUL:
			if (this.stack.getLength() >= 2) {
				value2 = this.stack.pop();
				value1 = this.stack.pop();
				this.stack.push(value1 * value2);
				success = true;
			}
			break;
		case DIV:
			if (this.stack.getLength() >= 2) {
				value2 = this.stack.pop();
				value1 = this.stack.pop();
				if (value2 != 0)
					this.stack.push(value1 / value2);
				else {
					this.stack.push(value2);
					this.stack.push(value1);
					success=false;
				}
				
				success = true;
			}
			break;
		case HALT:
			this.halt = true;
			break;
		case OUT:
			Integer valorPila = this.stack.getLastPosition();
			if (valorPila != null)
				System.out
						.println("El ultimo valor en la pila es: " + valorPila + System.getProperty("line.separator"));
			else
				System.out.println("La pila no contiene valores");
			break;
		default:
			break;
		}
		return success;
	}

	@Override
	public String toString() {
		String resultado = "Estado de la CPU: " + System.getProperty("line.separator");
		resultado += this.memory.toString() + System.getProperty("line.separator");
		resultado += this.stack.toString() + System.getProperty("line.separator")
				+ System.getProperty("line.separator");
		return resultado;
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
	}
}
