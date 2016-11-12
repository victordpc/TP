package TPMV;

/**
 * Clase que representa los comandos admitidos.
 */
public class Command {
	private final ENUM_COMMAND command;
	private ByteCode instruction;
	private int replace = -1;

	/**
	 * Constructor de la clase
	 * 
	 * @param command
	 *            Comando con el que construimos la clase.
	 */
	public Command(ENUM_COMMAND command) {
		this.command = command;
	}

	/**
	 * Constructor de la clase
	 * 
	 * @param command
	 *            Comando con el que construimos la clase.
	 * @param instruction
	 *            ByteCode asociado al comando
	 */
	public Command(ENUM_COMMAND command, ByteCode instruction) {
		this.command = command;
		this.instruction = instruction;
	}

	/**
	 * Constructor de la clase
	 * 
	 * @param command
	 *            Comando con el que construimos la clase.
	 * @param replace
	 *            Parametro asociado al comando.
	 */
	public Command(ENUM_COMMAND command, int replace) {
		this.command = command;
		this.replace = replace;
	}

	/**
	 * Funcion que realiza las llamadas a los metodos asociados a cada comando.
	 * 
	 * @param engine
	 *            Instancia en la que se ejecutan los comandos.
	 * @return exito o fracaso de la operación.
	 */
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
		if (this.instruction != null)
			resultado += " " + this.instruction.toString();
		if (this.replace > -1)
			resultado += " " + this.replace;
		return resultado;
	}
}