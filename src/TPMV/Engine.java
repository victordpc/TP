package tpmv;

import java.util.Scanner;

import bytecode.ByteCode;
import bytecode.ByteCodeParser;
import bytecode.ByteCodeProgram;
import command.Command;
import command.CommandParser;

/**
 * Clase para representar el bucle de control de la aplicación, se piden los
 * comandos a ejecutar y se realizan las ejecuciones de los comandos.
 */
public class Engine {

	/**
	 * Ejecuta el comando <code>HELP</code>, mostrando por pantalla la
	 * información de los posibles comandos que puede introducir el usuario.
	 * 
	 * @return <code>true</code> exito de la operacion, <code>false</code> en
	 *         otro caso
	 */
	static public boolean executeHelp() {
		CommandParser.showHelp();
		return true;
	}

	private ByteCodeProgram byteCodeProgram;
	private CPU cpu;
	private boolean end;
	private final Scanner scanner;

	/**
	 * Constructor de la clase
	 */
	public Engine() {
		this.byteCodeProgram = new ByteCodeProgram();
		this.scanner = new Scanner(System.in);
	}

	/**
	 * Ejecuta el comando <code>RUN</code>, reinicia la CPU y recorre el
	 * programa efectuando las operaciones.
	 * 
	 * @return <code>true</code> exito de la operacion, <code>false</code> en
	 *         otro caso
	 */
	public boolean excuteCommandRun() {
		boolean resultado = true;
		this.cpu= new CPU(this.byteCodeProgram);
		
		if (this.cpu.run()) {
			System.out.println("El estado de la maquina tras ejecutar el programa: "
					+ System.getProperty("line.separator") + this.cpu.toString());
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
	 * Ejecuta el comando <code>QUIT</code> finalizando la ejecución.
	 * 
	 * @return <code>true</code> exito de la operacion, <code>false</code> en
	 *         otro caso
	 */
	public boolean executeQuit() {
		this.end = true;
		System.out.println(byteCodeProgram.toString());
		System.out.println(System.getProperty("line.separator") + "Fin de la ejecucion...."
				+ System.getProperty("line.separator"));
		return true;
	}

	/**
	 * Ejecuta el comando <code>REPLACE</code>, sustituyendo el valor del
	 * programa en el indice indicado como parametro por una nueva instruccion
	 * que se pide al usuario.
	 * 
	 * @param position
	 *            índice en el cual se efectua el remplazo.
	 * 
	 * @return <code>true</code> exito de la operacion, <code>false</code> en
	 *         otro caso
	 */
	public boolean executeReplace(int position) {
		if (position < byteCodeProgram.getLength()) {
			System.out.print("Nueva instruccion: ");
			String line = scanner.nextLine();
			ByteCode bc = ByteCodeParser.parse(line);
			if (bc != null && byteCodeProgram.replace(position, bc)) {
				System.out.println(byteCodeProgram.toString() + System.getProperty("line.separator"));
				return true;
			}
		}
		return false;
	}

	/**
	 * Ejecuta el comando <code>RESET</code>, reiniciando el programa.
	 * 
	 * @return <code>true</code> exito de la operacion, <code>false</code> en
	 *         otro caso
	 */
	public boolean executeReset() {
		this.byteCodeProgram.reset();
		System.out.println("RESET ejecutado");
		return true;
	}

	/**
	 * Escribe por pantalla el programa almacenado
	 * 
	 * @return <code>true</code> en todo caso.
	 */
	public boolean printProgram() {
		System.out.println(this.byteCodeProgram.toString());
		System.out.println("Fin del programa.");
		return true;
	}

	/**
	 * Ejecuta el comando <code>ByteCode</code> para agregar operaciones al
	 * programa
	 * 
	 * @return <code>true</code> exito de la operacion, <code>false</code> en
	 *         otro caso
	 */
	public boolean readByteCodeProgram() {
		String instructionString = "";
		ByteCode instruction = null;

		this.byteCodeProgram.reset();

		System.out.println("Introduzca las instrucciones: ");
		instructionString = this.scanner.nextLine();

		while (!instructionString.equalsIgnoreCase("END")) {
			instruction = ByteCodeParser.parse(instructionString);

			if (instruction != null)
				this.byteCodeProgram.addByteCode(instruction);
			else
				System.err.println("ByteCode incorrecto, vuelva a introducirlo");

			instructionString = this.scanner.nextLine();
		}

		System.out.println(this.byteCodeProgram.toString() + System.getProperty("line.separator"));
		return true;
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
}
