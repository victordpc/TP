package Command;

/**
 * Clase que se encarga de convertir textos en comandos
 */
public class CommandParser {

	private final static Command[] commands = {
			new Help(), new Quit(), new Reset(), 
			new Replace(), new Run(), new AddByteCodeProgram()
	};
	
	/**
	 * Convierte un texto a un objeto de tipo {@code Command}.
	 * 
	 * @param linea
	 *            cadena de texto
	 * @return {@code Command} correspondiente al texto, si es incorrecto
	 *         devuelve {@code null}
	 */
	public static Command parse(String linea) {
		String[] s = linea.split(" ");
		
		Command newCommand = null;
		int i = 0;
		while(newCommand == null && i < commands.length) {
			if(commands[i].parse(s) != null) {
				newCommand = commands[i].parse(s);
			}
			i++;
		}

		
	/*	String commandString = instructionArray[0].toUpperCase();
		ENUM_COMMAND userCommand = ENUM_COMMAND.valueOf(commandString);
		
		Command command = null;
		switch (userCommand) {
		case HELP:
		case QUIT:
		case RESET:
		case RUN:
			command = new Command(ENUM_COMMAND.valueOf(commandString));
			break;
		case REPLACE:
			if (instructionArray.length == 2) {
				int position = Integer.parseInt(instructionArray[1]);
				if (position >= 0)
					command = new Command(ENUM_COMMAND.valueOf(commandString), position);
			}
			break;
		case NEWINST:
			ByteCode newByteCode = ByteCodeParser.parse(linea);
			if (newByteCode != null) {
				command = new Command(ENUM_COMMAND.valueOf(commandString), newByteCode);
			}
			break;
		}*/
		return newCommand;
	}
	
	public static void showHelp() {
		for(Command command : commands) {
			command.textHelp();
		}
	}
}
