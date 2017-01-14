package tp.pr3.mv;

import java.io.FileNotFoundException;
import java.util.Scanner;

import tp.pr3.bc.ByteCode;
import tp.pr3.bc.ByteCodeParser;
import tp.pr3.command.Command;
import tp.pr3.command.CommandParser;
import tp.pr3.elements.CPU;
import tp.pr3.elements.LexicalParser;
import tp.pr3.exceptions.ArrayException;
import tp.pr3.exceptions.BadFormatByteCodeException;
import tp.pr3.exceptions.ExecutionErrorException;
import tp.pr3.exceptions.LexicalAnalysisException;
import tp.pr3.elements.Compiler;

/**
 * Clase para representar el bucle de control de la aplicación, se piden los
 * comandos a ejecutar y se realizan las ejecuciones de los comandos.
 */
public class Engine {

    private ByteCodeProgram byteCodeProgram;
    private CPU cpu;
    private boolean end;
    private final Scanner scanner;
    private SourceProgram sProgram;
    private ParsedProgram parsedProgram;
    private LexicalParser lexicalParser;
    private Compiler compiler;

    /**
     * Constructor de la clase
     */
    public Engine() {
        this.byteCodeProgram = new ByteCodeProgram();
        this.scanner = new Scanner(System.in);
        this.sProgram = new SourceProgram();
        this.lexicalParser = new LexicalParser(sProgram);
        this.compiler = new Compiler();
        this.parsedProgram = new ParsedProgram();
    }

    /**
     * Ejecuta el comando <code>RUN</code>, reinicia la CPU y recorre el
     * programa efectuando las operaciones.
     *
     * @return <code>true</code> exito de la operacion, <code>false</code> en
     * otro caso
     */
    public boolean excuteCommandRun() throws ExecutionErrorException, ArrayException {
        boolean resultado = true;
        this.cpu = new CPU(this.byteCodeProgram);

        if (this.cpu.run()) {
            System.out.println("El estado de la maquina tras ejecutar el programa: " + System.getProperty("line.separator"));
            System.out.print(this.cpu.toString() + System.getProperty("line.separator"));
            printSystemData();
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
     * otro caso
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
     * @param position índice en el cual se efectua el remplazo.
     * @return <code>true</code> exito de la operacion, <code>false</code> en
     * otro caso
     */
    public boolean executeReplace(int position) throws BadFormatByteCodeException, ArrayException {
        if (position < byteCodeProgram.getLength()) {
            System.out.print("Nuevo bytecode: ");
            String line = scanner.nextLine();
            ByteCode bc = ByteCodeParser.parse(line);
            if (bc != null && byteCodeProgram.replace(position, bc)) {
                printSystemData();
                return true;
            } else {
                throw new BadFormatByteCodeException("Excepcion-BadFormatByteCodeException: El bytecode introducido no existe, inténtalo de nuevo");
            }
        } else {
            throw new ArrayException("Excepcion-ArrayException, la posición a la que intenta acceder no existe");
        }
    }

    /**
     * Ejecuta el comando <code>RESET</code>, reiniciando el programa.
     *
     * @return <code>true</code> exito de la operacion, <code>false</code> en
     * otro caso
     */
    public boolean executeReset() {
        this.byteCodeProgram.reset();
        System.out.println("RESET ejecutado");
        return true;
    }

    /**
     * Ejecuta el comando <code>HELP</code>, mostrando por pantalla la
     * información de los posibles comandos que puede introducir el usuario.
     *
     * @return <code>true</code> exito de la operacion, <code>false</code> en
     * otro caso
     */
    static public boolean executeHelp() {
        CommandParser.showHelp();
        return true;
    }

    /**
     * Escribe por pantalla el programa almacenado
     *
     * @return <code>true</code> siempre.
     */
    public boolean printProgram() {
        System.out.println(this.byteCodeProgram.toString());
        System.out.println("Fin del programa.");
        return true;
    }

    /**
     * Ejecuta el comando <code>bytecode</code> para agregar operaciones al
     * programa
     *
     * @return <code>true</code> exito de la operacion, <code>false</code> en
     * otro caso
     */
    public boolean readByteCodeProgram() throws ArrayException {

        this.byteCodeProgram.reset();

        System.out.println("Introduzca las instrucciones: ");
        String instructionString = this.scanner.nextLine();

        while (!instructionString.equalsIgnoreCase("END")) {
            ByteCode instruction = ByteCodeParser.parse(instructionString);

            if (instruction != null)
                this.byteCodeProgram.addByteCode(instruction);
            else
                System.err.println("bytecode incorrecto, vuelva a introducirlo");

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
        System.out.println("Introduce un comando:");
        System.out.print(System.getProperty("line.separator"));

        while (!this.end) {
            String line = this.scanner.nextLine().trim();
            Command command = CommandParser.parse(line);
            if (command != null) {
                try {
                    System.out.println("Comienza la ejecución de " + command.toString());
                    if (!command.execute(this)) {
                        System.out.println("Error en la ejecución del comando" + System.getProperty("line.separator"));
                    }
                } catch (FileNotFoundException e) {
                    System.err.print(e.getMessage() + System.getProperty("line.separator"));
                } catch (LexicalAnalysisException e) {
                    System.err.print(e.getMessage() + System.getProperty("line.separator"));
                } catch (ArrayException e) {
                    System.err.print(e.getMessage() + System.getProperty("line.separator"));
                } catch (BadFormatByteCodeException e) {
                    System.err.print(e.getMessage() + System.getProperty("line.separator"));
                } catch (ExecutionErrorException e) {
                    System.err.print(e.getMessage() + System.getProperty("line.separator"));
                }
            } else {
                System.out.println("Comienza la ejecución de " + line);
                System.out.print("Error: Ejecución incorrecta del comando" + System.getProperty("line.separator"));
            }
        }
        System.out.print(System.getProperty("line.separator"));
    }

    //NEW
    public boolean executeLoad(String fileName) throws java.io.FileNotFoundException, ArrayException {
        boolean success = false;
        if (sProgram.readFile(fileName)) {
            success = true;
            System.out.println(sProgram.toString());
        }
        return success;
    }

    public void compile() throws LexicalAnalysisException, ArrayException {
        lexicalParser.initialize();
        lexicalParser.lexicalParser(parsedProgram, "END");
        byteCodeProgram = new ByteCodeProgram();
        compiler.initialize(byteCodeProgram);
        compiler.compile(parsedProgram);
        printSystemData();
    }

    private void printSystemData() {
        System.out.println(sProgram.toString() + System.getProperty("line.separator"));
        System.out.println(byteCodeProgram.toString());
    }
}
