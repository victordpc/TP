package TPMV;

public class Command {

	private final ENUM_COMMAND command;
	private ByteCode instruction;
	private int replace = -1;

	public Command(ENUM_COMMAND command) {
		this.command = command;
	}

	public Command(ENUM_COMMAND command, ByteCode instruction) {
		this.command = command;
		this.instruction = instruction;
	}

	public Command(ENUM_COMMAND command, int replace) {
		this.command = command;
		this.replace = replace;
	}

	public boolean execute(Engine engine) {
		switch (command) {
		case HELP:
			return Engine.executeHelp();
		case QUIT:
			return engine.executeQuit();
		case NEWINST:
			return engine.executeNewInst(instruction);
		case RUN:
			return engine.excuteCommandRun();
		case RESET:
			return engine.executeReset();
		case REPLACE:
			return engine.executeReplace(replace);
		}
		return false;
	}

	public String toString() {
		String resultado = this.command.toString();
		if (instruction != null)
			resultado += " " + instruction.toString();
		if (replace > -1)
			resultado += " " + replace;
		return resultado;
	}
}
