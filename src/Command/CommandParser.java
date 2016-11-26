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
		return newCommand;
	}
	
	public static void showHelp() {
		for(Command command : commands) {
			command.textHelp();
		}
	}
}
