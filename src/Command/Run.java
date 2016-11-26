package Command;

import TPMV.Engine;

public class Run extends Command {

	@Override
	public boolean execute(Engine engine) {
		return engine.excuteCommandRun();
	}

	@Override
	public Command parse(String[] s) {
		if(s.length == 1 && s[0].equalsIgnoreCase(ENUM_COMMAND.RUN.toString())) {
			return new Run();
		}
		return null;
	}

	@Override
	public String textHelp() {
		return " RUN: Ejecuta el programa actual. "
				+ "En caso de que se produzca un error de ejecución, "
				+ "avisa al usuario mediante un mensaje." + System.getProperty("line.separator");
	}
	
	@Override
	public String toString() {
		return ENUM_COMMAND.RUN.toString();
	}

}
