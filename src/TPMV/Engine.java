package TPMV;

import java.util.Scanner;

/**
 * Clase para representar el bucle de control de la aplicación, se piden los
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
	 * Inicia la ejecución de la máquina virtual leyendo sucesivamente los
	 * comandos introducidos por el usuario
	 */
	public void start() {
		end = false;
		System.out.println("Inicio del programa");
		System.out.print(System.getProperty("line.separator"));
		System.out.println("Empieze la introducción de comandos:");
		System.out.print(System.getProperty("line.separator"));

		while (!end) {
			String line = scanner.nextLine();
			Command command = CommandParser.parse(line);
			if (command != null) {
				System.out.println("Comienza la ejecución de " + command.toString());
				if (!command.execute(this)) {
					System.out.println("Error en la ejecución del comando" + System.getProperty("line.separator"));
				}
			} else {
				System.out.println("Comienza la ejecución de " + line);
				System.out.print("Error: Ejecucion incorrecta del comando" + System.getProperty("line.separator"));
			}
		}
		System.out.print(System.getProperty("line.separator"));
	}

	/**
	 * Ejecuta el comando HELP, mostrando por pantalla la información de los
	 * posibles comandos que puede introducir el usuario.
	 * 
	 * @return Exito o fracaso de la operación
	 */
	static public boolean executeHelp() {
		System.out.println("HELP: Muestra esta ayuda " + System.getProperty("line.separator")
				+ "QUIT: Cierra la aplicación " + System.getProperty("line.separator") + "RUN: Ejecuta el programa "
				+ System.getProperty("line.separator")
				+ "NEWINST BYTECODE: Introduce una nueva instrucción al programa "
				+ System.getProperty("line.separator") + "RESET: Vacía el programa actual "
				+ System.getProperty("line.separator")
				+ "REPLACE N: Reemplaza la instrucción N por la solicitada al usuario");
		return true;
	}

	/**
	 * Ejecuta el comando QUIT finalizando la ejecución.
	 * 
	 * @return Exito o fracaso de la operación.
	 */
	public boolean executeQuit() {
		end = true;
		System.out.println(byteCodeProgram.toString());
		System.out.println(System.getProperty("line.separator") + "Fin de la ejecucion...."
				+ System.getProperty("line.separator"));
		return true;
	}

	/**
	 * Ejecuta el comando NEWINST para agregar una nueva instrucción al
	 * programa.
	 * 
	 * @param byteCode
	 *            ByteCode con la instrucción codificada.
	 * @return Exito o fracaso de la operación
	 */
	public boolean executeNewInst(ByteCode byteCode) {
		boolean resultado = byteCodeProgram.addByteCode(byteCode);
		System.out.println(byteCodeProgram.toString());
		return resultado;
	}

	/**
	 * Ejecuta el comando RUN, reinicia la CPU y recorre el programa efectuando
	 * las operaciones incluidas en el.
	 * 
	 * @return Exito o fracaso de la operación
	 */
	public boolean excuteCommandRun() {
		this.cpu.reset();
		for (int i = 0; i < this.byteCodeProgram.getLength() && !cpu.isHalted(); i++) {
			ByteCode byteCode = this.byteCodeProgram.getProgram(i);
			if (cpu.execute(byteCode)) {
				System.out.println("El estado de la maquina tras ejecutar el bytecode " + byteCode.toString() + " es:"
						+ System.getProperty("line.separator") + cpu.toString() + System.getProperty("line.separator"));
			} else {
				System.out.println("Error: Ejecucion incorrecta del comando " + System.getProperty("line.separator")
						+ this.byteCodeProgram.toString() + System.getProperty("line.separator") + cpu.toString()
						+ System.getProperty("line.separator"));
				return false;
			}
		}
		return true;
	}

	/**
	 * Ejecuta el comando REPLACE, sustituyendo el valor del programa en el
	 * indice indicado como parámetro por una nueva instrucción que se pide al
	 * usuario.
	 * 
	 * @param position
	 *            Índice en el cual se efectua el remplazo.
	 * @return Exito o fracaso de la operación
	 */
	public boolean executeReplace(int position) {
		System.out.print("Nueva instrucción: ");
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
	 * Ejecuta el comando RESET, reiniciando el programa.
	 * 
	 * @return Exito o fracaso de la operación
	 */
	public boolean executeReset() {
		byteCodeProgram.reset();
		return true;
	}
}
