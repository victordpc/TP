package TPMV;

import java.util.Scanner;

import ByteCode.ByteCode;
import ByteCode.ByteCodeParser;
import ByteCode.ByteCodeProgram;
import CPU.CPU;
import Command.Command;
import Command.CommandParser;

/**
 * Clase para representar el bucle de control de la aplicación, se piden los
 * comandos a ejecutar y se realizan las ejecuciones de los comandos.
 */
public class Engine {

	private boolean end;
	private final Scanner scanner;
	private final CPU cpu;
	private ByteCodeProgram byteCodeProgram;

	/**
	 * Constructor de la clase
	 */
	public Engine() {
		this.cpu = new CPU();
		this.scanner = new Scanner(System.in);
		this.byteCodeProgram = new ByteCodeProgram();
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
					System.out.println("Error en la ejecución del comando " + command.toString() + System.getProperty("line.separator"));
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
	public boolean executeHelp() {
		System.out.println("HELP: Muestra esta ayuda " + System.getProperty("line.separator")
				+ "QUIT: Cierra la aplicacion " + System.getProperty("line.separator") + "RUN: Ejecuta el programa "
				+ System.getProperty("line.separator")
				+ "NEWINST BYTECODE: Introduce una nueva instruccion al programa "
				+ System.getProperty("line.separator") + "RESET: Vacia el programa actual "
				+ System.getProperty("line.separator")
				+ "REPLACE N: Reemplaza la instruccion N por la solicitada al usuario");
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

	public boolean readByteCodeProgram() {
		boolean success = true;
		String linea = "";
		System.out
				.println("Introduce el bytecode. Una instruccion por linea: " + System.getProperty("line.separator"));
		while (!linea.equalsIgnoreCase("end")) {
			linea = scanner.nextLine();
			if (!linea.equalsIgnoreCase("end")) {
				ByteCode newByteCode = ByteCodeParser.parse(linea.split(" "));
				if (newByteCode != null) {
					success = byteCodeProgram.addByteCode(newByteCode);
				} else {
					success = false;
				}
			}
		}

		if (success) {
			System.out.println(this.byteCodeProgram.toString() + System.getProperty("line.separator"));
		}

		return success;
	}

	/**
	 * Ejecuta el comando {@code RUN}, reinicia la CPU y recorre el programa
	 * efectuando las operaciones.
	 * 
	 * @return {@code true} exito de la operacion, {@code false} en otro caso
	 */
	public boolean excuteCommandRun() {
		this.cpu.setByteCodeProgram(this.byteCodeProgram);
		return this.cpu.run();
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
		String linea = scanner.nextLine();
		ByteCode newByteCode = ByteCodeParser.parse(linea.split(" "));
		if (newByteCode != null) {
			this.byteCodeProgram.replace(position, newByteCode);
			System.out.println(this.byteCodeProgram.toString());
			return true;
		}
		return false;
	}

	public boolean executeReset() {
		this.cpu.reset();
		return true;
	}

}
