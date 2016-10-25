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
public class ByteCodeParser {

    public static ByteCode parse(String line) {
        String[] instructionArray = line.split(" ");
        String commandString = instructionArray[1];
        ENUM_BYTECODE enumByteCode = ENUM_BYTECODE.valueOf(commandString.toUpperCase());
        ByteCode newByteCode = null;
        switch (enumByteCode) {
            case PUSH:
            case STORE:
            case LOAD:
                if (instructionArray.length == 3) {
                    int byteCodeParam = Integer.parseInt(instructionArray[2]);
                    newByteCode = new ByteCode(enumByteCode, byteCodeParam);
                }
                break;
            case ADD:
            case SUB:
            case MUL:
            case DIV:
            case OUT:
                newByteCode = new ByteCode(enumByteCode);
                break;
            case HALT:
                break;
        }
        return newByteCode;
    }
}
