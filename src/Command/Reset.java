package Command;

import TPMV.Engine;

public class Reset extends Command {

	@Override
	public boolean execute(Engine engine) {
		return engine.executeReset();
	}

	@Override
	public Command parse(String[] s) {
		if(s.length == 1 && s[0].equalsIgnoreCase(ENUM_COMMAND.RESET.toString())) {
			return new Reset();
		}
		return null;
	}

	@Override
	public String textHelp() {
		return " RESET: Inicializa el programa actual "
				+ "eliminando todas las instrucciones almacenadas." + System.getProperty("line.separator");
	}
	
	@Override
	public String toString() {
		return ENUM_COMMAND.RESET.toString();
	}

}
