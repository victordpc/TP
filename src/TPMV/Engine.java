package TPMV;

import java.util.Scanner;

import ByteCode.ByteCode;
import ByteCode.ByteCodeParser;
import ByteCode.ByteCodeProgram;
import Command.Command;
import Command.CommandParser;

/**
 * Clase para representar el bucle de control de la aplicación, se piden los
 * comandos a ejecutar y se realizan las ejecuciones de los comandos.
 */
public class Engine {

	private boolean end;
	private ByteCodeProgram byteCodeProgram;
	private final Scanner scanner;
	private final CPU cpu;

	/**
	 * Constructor de la clase
	 */
	public Engine() {
		this.byteCodeProgram = new ByteCodeProgram();
		this.cpu = new CPU();
		this.scanner = new Scanner(System.in);
	}

	/**
	 * Inicia la ejecucion de la maquina virtual leyendo sucesivamente los
	 * comandos introducidos por el usuario
	 */
	public void start() {
		this.end = false;
		System.out.println("Inicio del programa");
		System.out.print(System.getProperty("line.separator"));
		System.out.println("Empieze la introduccion de comandos:");
		System.out.print(System.getProperty("line.separator"));

		while (!this.end) {
			String line = this.scanner.nextLine().trim();
			Command command = CommandParser.parse(line);
			if (command != null) {
				System.out.println("Comienza la ejecución de " + command.toString());
				if (!command.execute(this)) {
					System.out.println("Error en la ejecución del comando" + System.getProperty("line.separator"));
				}
			} else {
				System.out.println("Comienza la ejecución de " + line);
				System.out.print("Error: Ejecución incorrecta del comando" + System.getProperty("line.separator"));
			}
		}
		System.out.print(System.getProperty("line.separator"));
	}

	/**
	 * Ejecuta el comando {@code HELP}, mostrando por pantalla la información de
	 * los posibles comandos que puede introducir el usuario.
	 * 
	 * @return {@code true} exito de la operacion, {@code false} en otro caso
	 */
	static public boolean executeHelp() {
		CommandParser.showHelp();
		return true;
	}

	/**
	 * Ejecuta el comando {@code QUIT} finalizando la ejecución.
	 * 
	 * @return {@code true} exito de la operacion, {@code false} en otro caso
	 */
	public boolean executeQuit() {
		this.end = true;
		System.out.println(byteCodeProgram.toString());
		System.out.println(System.getProperty("line.separator") + "Fin de la ejecucion...."
				+ System.getProperty("line.separator"));
		return true;
	}

	/**
	 * Ejecuta el comando {@code AddByteCodeProgram} para agregar operaciones al
	 * programa
	 * 
	 * @return {@code true} exito de la operacion, {@code false} en otro caso
	 */
	public boolean executeAddByteCodeProgram() {
		String instructionString = "";
		boolean resultado = true;
		ByteCode instruction = null;
		System.out.println("Introduzca las instrucciones: ");
		instructionString = this.scanner.nextLine();

		while (instructionString.toUpperCase() != "END" && resultado) {
			instruction = ByteCodeParser.parse(instructionString);

			if (instruction != null) {
				resultado = this.byteCodeProgram.addByteCode(instruction);
				instructionString = this.scanner.nextLine();
			} else
				resultado = false;
		}

		return resultado;
	}

	/**
	 * Ejecuta el comando {@code RUN}, reinicia la CPU y recorre el programa
	 * efectuando las operaciones.
	 * 
	 * @return {@code true} exito de la operacion, {@code false} en otro caso
	 */
	public boolean excuteCommandRun() {
		boolean resultado = true;
		if (this.cpu.run()) {
			System.out.println("El estado de la maquina tras ejecutar el programa: "
					+ System.getProperty("line.separator") + this.cpu.toString() + System.getProperty("line.separator")
					+ System.getProperty("line.separator") + "Programa ejecutado: "
					+ System.getProperty("line.separator") + this.byteCodeProgram.toString());
		} else {
			System.out.println("Error: Ejecucion incorrecta del programa " + System.getProperty("line.separator")
					+ System.getProperty("line.separator") + this.cpu.toString()
					+ System.getProperty("line.separator"));
			resultado = false;
		}

		this.cpu.reset();
		return resultado;
	}

	/**
	 * Ejecuta el comando {@code REPLACE}, sustituyendo el valor del programa en
	 * el indice indicado como parametro por una nueva instruccion que se pide
	 * al usuario.
	 * 
	 * @param position
	 *            índice en el cual se efectua el remplazo.
	 * @return {@code true} exito de la operacion, {@code false} en otro caso
	 */
	public boolean executeReplace(int position) {
		System.out.print("Nueva instruccion: ");
		String line = scanner.nextLine();
		ByteCode bc = ByteCodeParser.parse("newinst " + line);
		if (bc != null) {
			byteCodeProgram.replace(position, bc);
			System.out.println(byteCodeProgram.toString() + System.getProperty("line.separator"));
			return true;
		}
		return false;
	}

	/**
	 * Ejecuta el comando {@code RESET}, reiniciando el programa.
	 * 
	 * @return {@code true} exito de la operacion, {@code false} en otro caso
	 */
	public boolean executeReset() {
		this.byteCodeProgram.reset();
		return true;
	}
}
