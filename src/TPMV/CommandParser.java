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
public class CommandParser {

    public static Command parse(String line) {
        String[] instructionArray = line.split(" ");
        String commandString = instructionArray[0];
        ENUM_COMMAND enumCommand = ENUM_COMMAND.valueOf(commandString.toUpperCase());
        Command command = null;
        switch (enumCommand) {
            case HELP:
            case QUIT:
            case RESET:
            case RUN:
                command = new Command(enumCommand);
                break;
            case REPLACE:
                int position = Integer.parseInt(instructionArray[1]);
                command = new Command(enumCommand, position);
                break;
            case NEWINST:
                ByteCode newByteCode = ByteCodeParser.parse(line);
                if (newByteCode != null) {
                    command = new Command(enumCommand, newByteCode);
                }
                break;
        }
        return command;
    }
}
