package TPMV;

import java.util.Scanner;

public class Engine {

    private boolean end;
    private ByteCodeProgram byteCodeProgram;
    private final Scanner scanner;

    public Engine() {
        this.byteCodeProgram = new ByteCodeProgram();
        scanner = new Scanner(System.in);
    }

    public void start() {
        end = false;
        while (!end) {
            String line = scanner.nextLine();
            Command command = CommandParser.parse(line);
            System.out.println("Comienza la ejecución de " + line);
            if (command != null) {
                if (!command.execute(this)) {
                    throw new UnsupportedOperationException("Not supported yet.");
                }
            } else {
                System.out.print("Error: Ejecucion incorrecta del comando");
            }
        }
    }

    public void executeHelp() {
        System.out.println("HELP: Muestra esta ayuda \n"
                + "QUIT: Cierra la aplicación \n"
                + "RUN: Ejecuta el programa \n"
                + "NEWINST BYTECODE: Introduce una nueva instrucción al programa \n"
                + "RESET: Vacía el programa actual \n"
                + "REPLACE N: Reemplaza la instrucción N por la solicitada al usuario");
    }

    public void executeQuit() {
        end = true;
        byteCodeProgram.showProgramInfo();
        System.out.println("\nFin de la ejecucion....");
    }

    public void executeNewInst(ByteCode byteCode) {
        byteCodeProgram.addByteCode(byteCode);
    }

    public void executeRun() {
        byteCodeProgram.run();
    }

    public void executeReplace(int position) {
        System.out.print("Nueva instrucción: ");
        String line = "newinst ";
        line += scanner.nextLine();
        Command command = CommandParser.parse(line);
        if (command != null) {
            byteCodeProgram.replace(position, command.getByteCode());
        }
    }

    public void executeReset() {
        byteCodeProgram = new ByteCodeProgram();
    }
}
