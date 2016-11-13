package TPMV;

import java.util.Scanner;

/**
 * Clase para representar el bucle de control de la aplicacion, se piden los
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
			String line = this.scanner.nextLine();
			Command command = CommandParser.parse(line);
			if (command != null) {
				System.out.println("Comienza la ejecucion de " + command.toString());
				if (!command.execute(this)) {
					System.out.println("Error en la ejecucion del comando" + System.getProperty("line.separator"));
				}
			} else {
				System.out.println("Comienza la ejecucion de " + line);
				System.out.print("Error: Ejecucion incorrecta del comando" + System.getProperty("line.separator"));
			}
		}
		System.out.print(System.getProperty("line.separator"));
	}

	/**
	 * Ejecuta el comando HELP, mostrando por pantalla la informacion de los
	 * posibles comandos que puede introducir el usuario.
	 * 
	 * @return Exito o fracaso de la operacion
	 */
	static public boolean executeHelp() {
		System.out.println("HELP: Muestra esta ayuda " + System.getProperty("line.separator")
				+ "QUIT: Cierra la aplicacion " + System.getProperty("line.separator") 
				+ "RUN: Ejecuta el programa "+ System.getProperty("line.separator")
				+ "NEWINST BYTECODE: Introduce una nueva instruccion al programa "
				+ System.getProperty("line.separator") 
				+ "RESET: VacIa el programa actual "+ System.getProperty("line.separator")
				+ "REPLACE N: Reemplaza la instruccion N por la solicitada al usuario");
		return true;
	}

	/**
	 * Ejecuta el comando QUIT finalizando la ejecucion.
	 * 
	 * @return Exito o fracaso de la operacion.
	 */
	public boolean executeQuit() {
		this.end = true;
		System.out.println(byteCodeProgram.toString());
		System.out.println(System.getProperty("line.separator") + "Fin de la ejecucion...."
				+ System.getProperty("line.separator"));
		return true;
	}

	/**
	 * Ejecuta el comando NEWINST para agregar una nueva instruccion al
	 * programa.
	 * 
	 * @param byteCode
	 *            ByteCode con la instruccion codificada.
	 * @return Exito o fracaso de la operacion
	 */
	public boolean executeNewInst(ByteCode byteCode) {
		boolean resultado = byteCodeProgram.addByteCode(byteCode);
		System.out.println(byteCodeProgram.toString());
		return resultado;
	}

	/**
	 * Ejecuta el comando RUN, reinicia la CPU y recorre el programa efectuando
	 * las operaciones.
	 * 
	 * @return Exito o fracaso de la operacion
	 */
	public boolean excuteCommandRun() {
		this.cpu.reset();
		for (int i = 0; i < this.byteCodeProgram.getLength() && !this.cpu.isHalted(); i++) {
			ByteCode byteCode = this.byteCodeProgram.getProgram(i);
			if (this.cpu.execute(byteCode)) {
				System.out.println("El estado de la maquina tras ejecutar el bytecode " + byteCode.toString() + " es:"
						+ System.getProperty("line.separator") + this.cpu.toString() + System.getProperty("line.separator"));
			} else {
				System.out.println("Error: Ejecucion incorrecta del comando " + System.getProperty("line.separator")
						+ this.byteCodeProgram.toString() + System.getProperty("line.separator") + this.cpu.toString()
						+ System.getProperty("line.separator"));
				return false;
			}
		}
		return true;
	}

	/**
	 * Ejecuta el comando REPLACE, sustituyendo el valor del programa en el
	 * indice indicado como parametro por una nueva instruccion que se pide al
	 * usuario.
	 * 
	 * @param position
	 *            Indice en el cual se efectua el remplazo.
	 * @return Exito o fracaso de la operacion
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
	 * Ejecuta el comando RESET, reiniciando el programa.
	 * 
	 * @return Exito o fracaso de la operacion
	 */
	public boolean executeReset() {
		this.byteCodeProgram.reset();
		return true;
	}
}
