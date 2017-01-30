package tp.pr3.mv;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import tp.pr3.bc.ByteCode;
import tp.pr3.bc.ByteCodeParser;
import tp.pr3.cm.Command;
import tp.pr3.cm.CommandParser;
import tp.pr3.elements.CPU;
import tp.pr3.elements.Compiler;
import tp.pr3.elements.LexicalParser;
import tp.pr3.exceptions.ArrayException;
import tp.pr3.exceptions.BadFormatByteCodeException;
import tp.pr3.exceptions.ExecutionErrorException;
import tp.pr3.exceptions.LexicalAnalysisException;

/**
 * Clase para representar el bucle de control de la aplicación, se piden los
 * comandos a ejecutar y se realizan las ejecuciones de los comandos.
 */
public class Engine {

	private ByteCodeProgram bcProgram;
	private CPU cpu;
	private boolean end;
	private ParsedProgram pProgram;
	private final Scanner scanner;
	private SourceProgram sProgram;
	Compiler comp = null;
	LexicalParser lparser = null;

	/**
	 * Constructor de la clase
	 */
	public Engine() {
		this.bcProgram = new ByteCodeProgram();
		this.scanner = new Scanner(System.in);
		this.lparser = new LexicalParser();
		this.comp = new Compiler();
		this.pProgram = new ParsedProgram();
		this.sProgram = new SourceProgram();
	}

	/**
	 * Ejecuta el comando <code>RUN</code>, reinicia la CPU y recorre el
	 * programa efectuando las operaciones.
	 * 
	 * @return <code>true</code> exito de la operacion, <code>false</code> en
	 *         otro caso
	 * @throws ExecutionErrorException
	 *             errores en ejecución
	 * @throws ArrayException
	 *             para contemplar errores de acceso a posiciones incorrectas de
	 *             un array
	 */
	public boolean excuteRun() throws ArrayException, ExecutionErrorException {
		boolean resultado = true;
		this.cpu = new CPU(this.bcProgram);

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
	 * Método que compila el programa fuente cargado, lo traduce a un programa
	 * parseado y luego a programa ByteCode
	 * 
	 * @return <code>true</code> exito de la operacion, <code>false</code> en
	 *         otro caso
	 * 
	 * @throws LexicalAnalysisException
	 *             fallo en el parseo
	 * @throws ArrayException
	 *             llenado de programa
	 */
	public boolean executeCompile() throws LexicalAnalysisException, ArrayException {
		System.out.println(this.sProgram + System.getProperty("line.separator"));
		this.pProgram.reset();
		this.lexicalAnalysis();
		this.bcProgram.reset();
		this.generateByteCode();
		System.out.println(this.bcProgram + System.getProperty("line.separator"));
		return true;
	}

	/**
	 * Ejecuta el comando <code>HELP</code>, mostrando por pantalla la
	 * información de los posibles comandos que puede introducir el usuario.
	 */
	public void executeHelp() {
		CommandParser.showHelp();
	}

	/**
	 * Escribe por pantalla el programa almacenado
	 *
	 */
	public void executePrintProgram() {
		System.out.println(this.bcProgram.toString());
		System.out.println("Fin del programa.");
	}

	/**
	 * Ejecuta el comando <code>QUIT</code> finalizando la ejecución.
	 * 
	 * @return <code>true</code> exito de la operacion, <code>false</code> en
	 *         otro caso
	 */
	public boolean executeQuit() {
		this.end = true;
		System.out.println(bcProgram.toString());
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
	 * @throws BadFormatByteCodeException
	 *             detectar que un posible bytecode no se ajusta a la sintaxis
	 *             especificada
	 * @throws ArrayException
	 *             para contemplar errores de acceso a posiciones incorrectas de
	 *             un array.
	 */
	public boolean executeReplace(int position) throws BadFormatByteCodeException, ArrayException {
		if (position >= 0 && position < bcProgram.size()) {
			System.out.print("Nueva instruccion: ");
			String line = scanner.nextLine();
			ByteCode bc = null;
			while (bc == null) {
				bc = ByteCodeParser.parse(line.trim());
				if (bc != null && bcProgram.addByteCode(bc, position)) {
					System.out.println(bcProgram.toString() + System.getProperty("line.separator"));
					return true;
				} else {
					System.out.println("ByteCode [" + line + "] no es un ByteCode admitido");
					// throw new BadFormatByteCodeException("ByteCode [" + line
					// + "] no es un ByteCode admitido");
				}
			}
		}
		throw new ArrayException("La posición indicada [" + position + "] no es una posición válida del programa");
	}

	/**
	 * Ejecuta el comando <code>RESET</code>, reiniciando el programa.
	 * 
	 * @return <code>true</code> exito de la operacion, <code>false</code> en
	 *         otro caso
	 */
	public boolean executeReset() {
		this.bcProgram.reset();
		System.out.println("RESET ejecutado");
		return true;
	}

	/**
	 * Carga un fichero en el sistema
	 * 
	 * @param fichName
	 *            ruta del fichero para cargar
	 * @throws FileNotFoundException
	 *             fichero no existente
	 * @throws ArrayException
	 *             para contemplar errores de acceso a posiciones incorrectas de
	 *             un array
	 */
	public void load(String fichName) throws FileNotFoundException, ArrayException {
		sProgram.reset();

		try {
			Scanner scanner = new Scanner(new File(fichName));
			while (scanner.hasNextLine()) {
				sProgram.addInst(scanner.nextLine().trim());
			}
			scanner.close();
			System.out.println(sProgram.toString());

		} catch (FileNotFoundException exception) {
			throw new FileNotFoundException("Fichero no Encontrado");
			// System.out.println("Excepcion: Fichero no Encontrado...");
		}
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
			Command command = null;
			try {
				command = CommandParser.parse(line);
			} catch (BadFormatByteCodeException e) {
				System.err.println("Error en el comando " + line + " " + e.getMessage());
			}
			if (command != null) {
				System.out.println("Comienza la ejecución de " + command.toString());
				try {
					command.execute(this);
					System.out.println("Fin de ejecución de " + command.toString());
				} catch (LexicalAnalysisException e) {
					System.err.println("Error en el análisis lexico del programa: " + e.getMessage());
				} catch (ArrayException e) {
					System.err.println("Error en la ejecución del comando " + command + " " + e.getMessage());
				} catch (FileNotFoundException e) {
					System.err.println("Error en la ejecución del comando " + command + " " + e.getMessage());
				} catch (BadFormatByteCodeException e) {
					System.err.println("Error en la ejecución del comando " + command + " " + e.getMessage());
				} catch (ExecutionErrorException e) {
					System.err.println("Error en la ejecución del comando " + command + " " + e.getMessage());
				}
			} else {
				System.err.print("Comando no reconocido" + System.getProperty("line.separator"));
			}
		}
		System.out.print(System.getProperty("line.separator"));
	}

	private void generateByteCode() throws ArrayException {
		this.comp.initialize(bcProgram);
		this.comp.compile(pProgram);
	}

	private void lexicalAnalysis() throws LexicalAnalysisException {
		this.lparser.initialize(sProgram);
		this.lparser.lexicalParser(pProgram, "END");
	}
}

// /**
// * Ejecuta el comando <code>ByteCode</code> para agregar operaciones al
// * programa
// *
// * @return <code>true</code> exito de la operacion, <code>false</code> en
// * otro caso
// */
// public boolean readByteCodeProgram() {
// String instructionString = "";
// ByteCode instruction = null;
//
// this.byteCodeProgram.reset();
//
// System.out.println("Introduzca las instrucciones: ");
// instructionString = this.scanner.nextLine();
//
// while (!instructionString.equalsIgnoreCase("END")) {
// instruction = ByteCodeParser.parse(instructionString);
//
// if (instruction != null)
// this.byteCodeProgram.addByteCode(instruction, null);
// else
// System.err.println("ByteCode incorrecto, vuelva a introducirlo");
//
// instructionString = this.scanner.nextLine();
// }
//
// System.out.println(this.byteCodeProgram.toString() +
// System.getProperty("line.separator"));
// return true;
// }
