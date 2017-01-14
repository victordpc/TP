package command;

import tp.pr3.command.Command;
import tp.pr3.exceptions.ArrayException;
import tp.pr3.mv.Engine;

/**
 * Clase que representa el comando <code>AddByteCodeProgram</code>
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
	public boolean execute(Engine engine) throws ArrayException {
		boolean resultado = engine.readByteCodeProgram();
		System.out.println("Fin introducción de instrucciones bytecode.");
		return resultado;
	}

	@Override
	public Command parse(String[] s) {
		if (s.length == 1 && s[0].equalsIgnoreCase("bytecode"))
			return new AddByteCodeProgram();
		return null;
	}

	@Override
	public String textHelp() {
		return "    BYTECODE: Introduce nuevas instrucciones bytecode al programa "
				+ System.getProperty("line.separator");
	}

	@Override
	public String toString() {
		return "bytecode" + System.getProperty("line.separator");
	}

}
