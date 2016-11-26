package Command;

import TPMV.Engine;

public class Quit extends Command {

	@Override
	public boolean execute(Engine engine) {
		return engine.executeQuit();
	}

	@Override
	public Command parse(String[] s) {
		if(s.length == 1 && s[0].equalsIgnoreCase(ENUM_COMMAND.QUIT.toString())) {
			return new Quit();
		}
		return null;
	}

	@Override
	public String textHelp() {
		return " QUIT: Cierra la aplicación" + System.getProperty("line.separator");
	}

	@Override
	public String toString() {
		return ENUM_COMMAND.QUIT.toString();
	}
}
