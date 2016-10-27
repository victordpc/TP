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
public class OperandStack {

    private final int[] stack;
    private final int STACK_SIZE = 1000;
    private int nextOperand;

    public OperandStack() {
        this.stack = new int[STACK_SIZE];
        this.nextOperand = -1;
    }

    public int length() {
        int stackSize = 0;
        if (nextOperand > 0) {
            stackSize = nextOperand;
        }
        return stackSize;
    }

    public int read(int pos) {
        return stack[pos];
    }

    public void write(int operand) {
        if (nextOperand < 0) {
            nextOperand = 0;
        }
        stack[nextOperand] = operand;
        nextOperand += 1;
    }

    public int getLastValue() {
        int position = 0;
        if ((nextOperand - 1) > 0) {
            position = nextOperand - 1;
            nextOperand -= 1;
        } else {
            nextOperand = -1;
        }
        return stack[position];
    }
    
    public int getLastPosition() {
        int position = 0;
        if(nextOperand > 0) {
            position = nextOperand - 1;
        }
        return position;
    }

}
