package Command;

import TPMV.Engine;

public class Help extends Command {

	@Override
	public boolean execute(Engine engine) {
		return engine.executeHelp();
	}

	@Override
	public Command parse(String[] s) {
		if(s.length == 1 && s[0].equalsIgnoreCase(ENUM_COMMAND.HELP.toString())) {
			return new Help();
		}
		return null;
	}

	@Override
	public String textHelp() {
		return " HELP:Que muestra información sobre los distintos comandos disponibles.";
	}
	
	@Override
	public String toString() {
		return ENUM_COMMAND.HELP.toString();
	}

}
