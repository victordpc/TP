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
	 * Ejecuta el ByteCode recibido por parametro.
	 * 
	 * @param instruccion
	 *            Instruccion a ejecutar.
	 * @return Resultado cierto o falso de la ejecucion del la instruccion.
	 */
	public boolean execute(ByteCode instruccion) {
		boolean success = false;
		int value1;
		int value2;
		switch (instruccion.getName()) {
		case PUSH:
			if (stack.getLength() >= 1) {
				success = stack.push(instruccion.getParam());
			}
			break;
		case STORE:
			if (stack.getLength() >= 1) {
				success = memory.write(instruccion.getParam(), stack.pop());
			}
			break;
		case LOAD:
			success = this.stack.push(memory.read(instruccion.getParam()));
			break;
		case ADD:
			if (stack.getLength() >= 2) {
				value2 = stack.pop();
				value1 = stack.pop();
				stack.push(value1 + value2);
				success = true;
			}
			break;
		case SUB:
			if (stack.getLength() >= 2) {
				value2 = stack.pop();
				value1 = stack.pop();
				stack.push(value1 - value2);
				success = true;
			}
			break;
		case MUL:
			if (stack.getLength() >= 2) {
				value2 = stack.pop();
				value1 = stack.pop();
				stack.push(value1 * value2);
				success = true;
			}
			break;
		case DIV:
			if (stack.getLength() >= 2) {
				value2 = stack.pop();
				value1 = stack.pop();
				stack.push(value1 / value2);
				success = true;
			}
			break;
		case HALT:
			this.halt = true;
			break;
		case OUT:
			System.out.println(
					"El ultimo valor en la pila es: " + stack.getLastPosition() + System.getProperty("line.separator"));
			break;
		default:
			break;
		}
		return success;
	}

	@Override
	public String toString() {
		String resultado = "Estado de la CPU: " + System.getProperty("line.separator") + "Memoria: ";
		resultado += this.memory.toString() + System.getProperty("line.separator");
		resultado += "Pila:" + System.getProperty("line.separator");
		resultado += this.stack.toString() + System.getProperty("line.separator")
				+ System.getProperty("line.separator");
		return resultado;
	}

	/**
	 * Devuelve el valor del atributo halt.
	 * 
	 * @return Valor del atributo halt
	 */
	public boolean isHalted() {
		return halt;
	}

	/**
	 * Reinicia la memoria y la pila.
	 */
	public void reset() {
		this.memory.reset();
		this.stack.reset();
	}
}
