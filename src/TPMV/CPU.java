package TPMV;

public class CPU {

	private final Memory memory;
	private final OperandStack stack;
	private boolean halt;

	public CPU() {
		this.memory = new Memory();
		this.stack = new OperandStack();
		this.halt = false;
	}

	public boolean execute(ByteCode instruction) {
		boolean success = false;
		int value1;
		int value2;
		switch (instruction.getName()) {
		case PUSH:
			if (stack.length() >= 1) {
				success = stack.push(instruction.getParam());
			}
			break;
		case STORE:
			if (stack.length() >= 1) {
				int value = stack.pop();
				success = memory.write(instruction.getParam(), value);
			}
			break;
		case LOAD:
			memory.read(instruction.getParam());
			success = true;
			break;
		case ADD:
			if (stack.length() >= 2) {
				value2 = stack.pop();
				value1 = stack.pop();
				stack.push(value1 + value2);
				success = true;
			}
			break;
		case SUB:
			if (stack.length() >= 2) {
				value2 = stack.pop();
				value1 = stack.pop();
				stack.push(value1 - value2);
				success = true;
			}
			break;
		case MUL:
			if (stack.length() >= 2) {
				value2 = stack.pop();
				value1 = stack.pop();
				stack.push(value1 * value2);
				success = true;
			}
			break;
		case DIV:
			if (stack.length() >= 2) {
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
			System.out.println("El último valor en la pila es: "
					+ stack.getLastPosition()
					+ System.getProperty("line.separator"));
			break;
		default:
			break;
		}
		return success;
	}

	@Override
	public String toString() {
		String resultado = "Estado de la CPU: "
				+ System.getProperty("line.separator") + "Memoria: ";
		resultado += this.memory.toString()
				+ System.getProperty("line.separator");
		resultado += "Pila:" + System.getProperty("line.separator");
		resultado += this.stack.toString()
				+ System.getProperty("line.separator")
				+ System.getProperty("line.separator");
		return resultado;
	}

	public boolean isHalted() {
		return halt;
	}

	public void reset() {
		this.memory.reset();
		this.stack.reset();
	}
}
