package TPMV;

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
	
    public String toString(){
		String resultado="";
		
        if (isEmpty()) {
            resultado="<vacía>";
        } else {
            for (int i = 0; i < this.memory.length; i++) {
                Integer value = this.memory[i];
                if (value != null) {
                    resultado += "[" + i + "]:" + value.intValue() + " ";
                }
            }
        }

		return resultado;
	}
	
    private void resize(int pos) {
        int newSize = ((pos / REDIM_SIZE) + 1) * REDIM_SIZE;
        memory = java.util.Arrays.copyOf(this.memory, newSize);
    }
}
