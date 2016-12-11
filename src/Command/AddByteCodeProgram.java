package Command;

import TPMV.Engine;

/**
 * Clase que representa el comando {@code AddByteCodeProgram}
 * 
 * @author victor
 */
public class AddByteCodeProgram extends Command {

	/**
	 * Constructor de la clase
	 */
	public AddByteCodeProgram() {
		super();
	}

	@Override
	public boolean execute(Engine engine) {
		boolean resultado = engine.readByteCodeProgram();
		System.out.println("Fin introducción de instrucciones ByteCode.");
		return resultado;
	}

	@Override
	public Command parse(String[] s) {
		if (s.length == 1 && s[0].equalsIgnoreCase("ByteCode"))
			return new AddByteCodeProgram();
		return null;
	}

	@Override
	public String textHelp() {
		return "    ByteCode: Introduce nuevas instrucciones ByteCode al programa "
				+ System.getProperty("line.separator");
	}

	@Override
	public String toString() {
		return "ByteCode" + System.getProperty("line.separator");
	}

}
