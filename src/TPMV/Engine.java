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
        System.out.println("HELP: Muestra esta ayuda " + System.getProperty("line.separator")
                + "QUIT: Cierra la aplicación " + System.getProperty("line.separator")
                + "RUN: Ejecuta el programa " + System.getProperty("line.separator")
                + "NEWINST BYTECODE: Introduce una nueva instrucción al programa " + System.getProperty("line.separator")
                + "RESET: Vacía el programa actual " + System.getProperty("line.separator")
                + "REPLACE N: Reemplaza la instrucción N por la solicitada al usuario");
    }

    public void executeQuit() {
        end = true;
        System.out.println(byteCodeProgram.toString());
        System.out.println("\nFin de la ejecucion....");
    }

    public void executeNewInst(ByteCode byteCode) {
        byteCodeProgram.addByteCode(byteCode);
        System.out.println(byteCodeProgram.toString());
    }

    public void excuteCommandRun() {
    	this.cpu.reset();
        for (int i = 0; i < this.byteCodeProgram.getLength() && !cpu.isHalted(); i++) {
            ByteCode byteCode = this.byteCodeProgram.getProgram(i);
            if (cpu.execute(byteCode)) {
            	String status = "El estado de la maquina tras ejecutar el bytecode ";
                switch (byteCode.name) {
                    case PUSH:
                    case LOAD:
                    case STORE:
                    	status += byteCode.getName() + " " + byteCode.getParam() + " es:";
                        break;
                    default:
                    	status += byteCode.getName() + " es:";
                        break;
                }
                System.out.println(status +System.getProperty("line.separator")+cpu.toString());
            }
        }
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
