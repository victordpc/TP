/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TPMV;

/**
 *
 * @author yhondri
 */
public class ByteCodeProgram {

    private final ByteCode[] program;
    private final CPU cpu;

    private int nextProgramPosition = 0;
    private static final int EXTEND_VALUE = 1000;

    public ByteCodeProgram() {
        program = new ByteCode[EXTEND_VALUE];
        cpu = new CPU();
    }

    public void addByteCode(ByteCode byteCode) {
        program[nextProgramPosition] = byteCode;
        nextProgramPosition++;
        showProgramInfo();
    }

    public void showProgramInfo() {
        System.out.println("Programa almacenado:");
        for (int i = 0; i < nextProgramPosition; i++) {
            ByteCode storedByteCode = program[i];
            switch (storedByteCode.name) {
                case PUSH:
                case LOAD:
                case STORE:
                    System.out.println(i + ": " + storedByteCode.getName().toString() + " " + storedByteCode.getParam());
                    break;
                default:
                    System.out.println(i + ": " + storedByteCode.getName().toString());
                    break;
            }
        }
    }

    public void run() {
        for (int i = 0; i < nextProgramPosition; i++) {
            ByteCode byteCode = program[i];
            if (cpu.execute(byteCode)) {
                switch (byteCode.name) {
                    case PUSH:
                    case LOAD:
                    case STORE:
                        System.out.println("El estado de la maquina tras ejecutar el bytecode " + byteCode.getName()
                                + " " + byteCode.getParam() + " es:");
                        break;
                    default:
                        System.out.println("El estado de la maquina tras ejecutar el bytecode " + byteCode.getName()
                                + " es:");
                        break;
                }
                cpu.showStatus();
            }
        }
    }

    public void replace(int position, ByteCode newInstruction) {
        int temp = nextProgramPosition;
        nextProgramPosition = position;
        addByteCode(newInstruction);
        nextProgramPosition = temp;
    }
}
