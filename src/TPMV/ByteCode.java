package TPMV;

public class ByteCode {

    ENUM_BYTECODE name;
    private int param; //PUSH, STORE, LOAD

    public ByteCode(ENUM_BYTECODE name, int param) {
        this.name = name;
        this.param = param;
    }
    
    public ByteCode(ENUM_BYTECODE name) {
        this.name = name;
    }
    
    public ENUM_BYTECODE getName() {
        return this.name;
    }
    
    public int getParam() {
        return this.param;
    }

    @Override
    public String toString() {
        return this.name + " " + this.param +" ";
    }
}
