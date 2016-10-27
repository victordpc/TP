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
public class CPU {

    private final Memory memory;
    private final OperandStack stack;

    public CPU() {
        this.memory = new Memory();
        this.stack = new OperandStack();
    }

    public boolean execute(ByteCode instruction) {
        boolean success = false;
        int value1;
        int value2;
        switch (instruction.getName()) {
            case PUSH:
                stack.write(instruction.getParam());
                success = true;
                break;
            case STORE:
                int value = stack.getLastValue();
                success = memory.write(instruction.getParam(), value);
                break;
            case LOAD:
                stack.write(instruction.getParam());
                success = true;
                break;
            case ADD:
                value2 = stack.getLastValue();
                value1 = stack.getLastValue();
                stack.write(value1 + value2);
                success = true;
                break;
            case SUB:
                value2 = stack.getLastValue();
                value1 = stack.getLastValue();
                stack.write(value1 - value2);
                success = true;
                break;
            case MUL:
                value2 = stack.getLastValue();
                value1 = stack.getLastValue();
                stack.write(value1 * value2);
                success = true;
                break;
            case DIV:
                value2 = stack.getLastValue();
                value1 = stack.getLastValue();
                stack.write(value1 / value2);
                success = true;
                break;
            case OUT:
                System.out.println("El último valor en la pila es: " +stack.read(stack.getLastPosition()));
                break;
            default:
                break;
        }
        return success;
    }

    public void showStatus() {
        System.out.print("\nEstado de la CPU:\nMemoria: ");
        if (memory.isEmpty()) {
            System.out.print("<vacía>");
        } else {
            for (int i = 0; i < memory.length(); i++) {
                Integer value = memory.read(i);
                if (value != null) {
                    System.out.print("[" + i + "]:" + value.intValue() + " ");
                }
            }
        }
        System.out.print("\nPila: ");
        if (stack.length() == 0) {
            System.out.print("<vacía>");
        } else {
            for (int i = 0; i < stack.length(); i++) {
                System.out.print(stack.read(i) + " ");
            }
        }
        System.out.print("\n\n");
    }
}
