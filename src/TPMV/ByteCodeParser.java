package TPMV;

public class ByteCodeParser {

	public static ByteCode parse(String entrada) {
		ByteCode resultado = null;
		String[] instructionArray = entrada.split(" ");
		String commandString = instructionArray[1].toUpperCase();

		switch (commandString) {
		case "PUSH":
		case "LOAD":
		case "STORE":
			if (instructionArray.length == 3) {
				resultado = new ByteCode(ENUM_BYTECODE.valueOf(commandString),
						Integer.parseInt(instructionArray[2]));
			}
			break;
		case "ADD":
		case "SUB":
		case "MUL":
		case "DIV":
		case "OUT":
		case "HALT":
			if (instructionArray.length == 2) {
				resultado = new ByteCode(ENUM_BYTECODE.valueOf(commandString));
			}
			break;
		}

		return resultado;
	}
}
