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
public class Memory {

    private Integer[] memory;
    private final int REDIM_SIZE = 1000;

    public Memory() {
        memory = new Integer[REDIM_SIZE];
    }

    public boolean write(int pos, int value) {
        boolean result = false;
        if (pos >= 0) {
            if (this.memory.length < pos) {
                resize(pos);
            }
            this.memory[pos] = value;
            result = true;
        }
        return result;
    }

    public Integer read(int pos) {
        return memory[pos];
    }

    public boolean isEmpty() {
        boolean isEmtpy = true;
        for (Integer integer : memory) {
            if (integer != null) {
                isEmtpy = false;
                break;
            }
        }        
        return isEmtpy;
    }

    public int length() {
        return memory.length;
    }

    private void resize(int pos) {
        int newSize = ((pos / REDIM_SIZE) + 1) * REDIM_SIZE;
        memory = java.util.Arrays.copyOf(this.memory, newSize);

        // Integer[] temp = new Integer[((pos / redimSize) + 1) * redimSize];
        // if (this.memory != null)
        // System.arraycopy(this.memory, 0, temp, 0,
        // Math.min(this.memory.length, temp.length));
        // this.memory = temp;
    }
}
