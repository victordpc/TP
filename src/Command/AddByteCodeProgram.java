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
		return engine.executeAddByteCodeProgram();
	}

	@Override
	public Command parse(String[] s) {
		if (s.length == 1 && s[0].equalsIgnoreCase("AddByteCodeProgram"))
			return new AddByteCodeProgram();
		return null;
	}

	@Override
	public String textHelp() {
		return "    ADDBYTECODEPROGRAM BYTECODE: Introduce nuevas instrucciones al programa "
				+ System.getProperty("line.separator");
	}

	public String toString() {
		return "ADDBYTECODEPROGRAM" + System.getProperty("line.separator");
	}

}
