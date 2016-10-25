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
        return name;
    }
    
    public int getParam() {
        return param;
    }

    @Override
    public String toString() {
        String objectString = "";
        System.out.println("Name --> "+name +" "+param);
        objectString += name +" ";
        objectString += param +" ";
        return objectString;
    }
}
