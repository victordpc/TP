package TPMV;

/**
 * Clase que se encarga de convertir textos en comandos
 */
public class CommandParser {

	/**
	 * Convierte un texto a un objeto de tipo {@code Command}.
	 * 
	 * @param linea
	 *            cadena de texto
	 * @return {@code Command} correspondiente al texto, si es incorrecto
	 *         devuelve {@code null}
	 */
	public static Command parse(String linea) {
		String[] instructionArray = linea.split(" ");
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
			if (instructionArray.length == 2) {
				int position = Integer.parseInt(instructionArray[1]);
				if (position >= 0)
					command = new Command(ENUM_COMMAND.valueOf(commandString), position);
			}
			break;
		case "NEWINST":
			ByteCode newByteCode = ByteCodeParser.parse(linea);
			if (newByteCode != null) {
				command = new Command(ENUM_COMMAND.valueOf(commandString), newByteCode);
			}
			break;
		}
		return command;
	}
}
