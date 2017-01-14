package tp.pr3.command;

import command.*;

/**
 * Clase que se encarga de convertir textos en comandos
 */
public class CommandParser {
	private final static Command[] commands = { new Load(), new Help(), new Quit(), new Reset(), new Replace(), new Run(),
			new AddByteCodeProgram(), new Compile(), new PrintProgram()};

	/**
	 * Convierte un texto a un objeto de tipo <code>command</code>.
	 * 
	 * @param linea
	 *            cadena de texto
	 * @return <code>command</code> correspondiente al texto, si es incorrecto
	 *         devuelve <code>null</code>
	 */
	public static Command parse(String linea) {
		String[] instructionArray = linea.split(" ");

		for (Command comando : commands) {
			Command com = comando.parse(instructionArray);

			if (com != null)
				return com;
		}
		return null;
	}

	/**
	 * Muestra por pantalla la ayuda asociada al conjunto de comandos
	 */
	public static void showHelp() {
		String cadena = "";
		for (Command comando : commands) {
			cadena += comando.textHelp();
		}
		System.out.println(cadena);
	}
}
