package TPMV;

public class CommandParser {

    public static Command parse(String line) {
        String[] instructionArray = line.split(" ");
        String commandString = instructionArray[0].toUpperCase();
        Command command = null;
        switch (commandString) {
            case "HELP":
            case "QUIT":
            case "RESET":
            case "RUN":
                command = new Command(ENUM_COMMAND.valueOf(commandString));
                break;
            case "REPLACE":
                int position = Integer.parseInt(instructionArray[1]);
                command = new Command(ENUM_COMMAND.valueOf(commandString), position);
                break;
            case "NEWINST":
                ByteCode newByteCode = ByteCodeParser.parse(line);
                if (newByteCode != null) {
                    command = new Command(ENUM_COMMAND.valueOf(commandString), newByteCode);
                }
                break;
        }
        return command;
    }
}
