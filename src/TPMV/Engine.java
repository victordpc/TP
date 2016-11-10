package TPMV;

import java.util.Scanner;

public class Engine {

	private boolean end;
	private ByteCodeProgram byteCodeProgram;
	private final Scanner scanner;
	private final CPU cpu;

	public Engine() {
		this.byteCodeProgram = new ByteCodeProgram();
		this.cpu = new CPU();
		this.scanner = new Scanner(System.in);
	}

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
				System.out.println("Comienza la ejecución de "
						+ command.toString());
				if (!command.execute(this)) {
					System.out.println("Error en la ejecución del comando"
							+ System.getProperty("line.separator"));
				}
			} else {
				System.out.println("Comienza la ejecución de " + line);
				System.out.print("Error: Ejecucion incorrecta del comando"
						+ System.getProperty("line.separator"));
			}
		}
		System.out.print(System.getProperty("line.separator"));
	}

	static public boolean executeHelp() {
		System.out
				.println("HELP: Muestra esta ayuda "
						+ System.getProperty("line.separator")
						+ "QUIT: Cierra la aplicación "
						+ System.getProperty("line.separator")
						+ "RUN: Ejecuta el programa "
						+ System.getProperty("line.separator")
						+ "NEWINST BYTECODE: Introduce una nueva instrucción al programa "
						+ System.getProperty("line.separator")
						+ "RESET: Vacía el programa actual "
						+ System.getProperty("line.separator")
						+ "REPLACE N: Reemplaza la instrucción N por la solicitada al usuario");
		return true;
	}

	public boolean executeQuit() {
		end = true;
		System.out.println(byteCodeProgram.toString());
		System.out.println(System.getProperty("line.separator")
				+ "Fin de la ejecucion...."
				+ System.getProperty("line.separator"));
		return true;
	}

	public boolean executeNewInst(ByteCode byteCode) {
		boolean resultado = byteCodeProgram.addByteCode(byteCode);
		System.out.println(byteCodeProgram.toString());
		return resultado;
	}

	public boolean excuteCommandRun() {
		this.cpu.reset();
		for (int i = 0; i < this.byteCodeProgram.getLength() && !cpu.isHalted(); i++) {
			ByteCode byteCode = this.byteCodeProgram.getProgram(i);
			if (cpu.execute(byteCode)) {
				System.out
				.println("El estado de la maquina tras ejecutar el bytecode "
						+ byteCode.toString()
						+ " es:"
						+ System.getProperty("line.separator")
						+ cpu.toString()
						+ System.getProperty("line.separator"));
			} else {
				System.out.println("Error: Ejecucion incorrecta del comando "
						+ System.getProperty("line.separator")
						+ this.byteCodeProgram.toString()
						+ System.getProperty("line.separator") + cpu.toString()
						+ System.getProperty("line.separator"));
				return false;
			}
		}
		return true;
	}

	public boolean executeReplace(int position) {
		System.out.print("Nueva instrucción: ");
		String line = scanner.nextLine();
		ByteCode bc = ByteCodeParser.parse("newinst " + line);
		if (bc != null) {
			byteCodeProgram.replace(position, bc);
			System.out.println(byteCodeProgram.toString()
					+ System.getProperty("line.separator"));
			return true;
		}
		return false;
	}

	public boolean executeReset() {
		return byteCodeProgram.reset();
	}
}
