package Command;

import TPMV.Engine;

/**
 * Clase que representa los comandos admitidos.
 */
public abstract class Command {
	/**
	 * Realiza la operación del comando
	 * 
	 * @param engine
	 *            instancia en la que se ejecutan los comandos.
	 * @return {@code true} exito de la operacion, {@code false} en otro caso
	 */
	abstract public boolean execute(Engine engine);

	/**
	 * Convierte un texto en comando
	 * 
	 * @param s
	 *            descomposicion de la cadena introducida
	 * @return representa la cadena recibida
	 */
	abstract public Command parse(String[] s);

	/**
	 * Muestra la ayuda del comando
	 * 
	 * @return cadena de texto con la explicación del comando
	 */
	abstract public String textHelp();

}

// private final ENUM_COMMAND command;
// private ByteCode instruction;
// private int replace = -1;
//
// /**
// * Constructor de la clase
// *
// * @param command
// * comando con el que construimos la clase.
// */
// public Command(ENUM_COMMAND command) {
// this.command = command;
// }
//
// /**
// * Constructor de la clase
// *
// * @param command
// * comando con el que construimos la clase.
// * @param instruction
// * {@code ByteCode} asociado al comando
// */
// public Command(ENUM_COMMAND command, ByteCode instruction) {
// this.command = command;
// this.instruction = instruction;
// }
//
// /**
// * Constructor de la clase
// *
// * @param command
// * comando con el que construimos la clase.
// * @param replace
// * parámetro asociado al comando.
// */
// public Command(ENUM_COMMAND command, int replace) {
// this.command = command;
// this.replace = replace;
// }
//
// /**
// * Función que realiza las llamadas a los metodos asociados a cada comando.
// *
// * @param engine
// * instancia en la que se ejecutan los comandos.
// * @return {@code true} exito de la operacion, {@code false} en otro caso
// */
// public boolean execute(Engine engine) {
// switch (this.command) {
// case HELP:
// return Engine.executeHelp();
// case QUIT:
// return engine.executeQuit();
// case NEWINST:
// return engine.executeNewInst(this.instruction);
// case RUN:
// return engine.excuteCommandRun();
// case RESET:
// return engine.executeReset();
// case REPLACE:
// return engine.executeReplace(this.replace);
// }
// return false;
// }
//
// public String toString() {
// String resultado = this.command.toString();
// if (this.instruction != null)
// resultado += " " + this.instruction.toString();
// if (this.replace > -1)
// resultado += " " + this.replace;
// return resultado;
// }
// }