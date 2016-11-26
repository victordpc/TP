package Command;

import TPMV.Engine;

public class AddByteCodeProgram extends Command {
	
	@Override
	public boolean execute(Engine engine) {
		return engine.readByteCodeProgram();
	}

	@Override
	public Command parse(String[] s) {
		if (s.length == 1 && s[0].equalsIgnoreCase(ENUM_COMMAND.BYTECODE.toString())) {
			return new AddByteCodeProgram();
		}
		return null;
	}

	@Override
	public String textHelp() {
		return " BYTECODE: Prepara la máquina para captar la entrada del nuevo programa"
				+ System.getProperty("line.separator");
	}
	
	public String toString() {
		return ENUM_COMMAND.BYTECODE.toString();
	}

}
