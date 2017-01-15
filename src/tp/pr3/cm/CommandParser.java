package tp.pr3.cm;

/**
 * Clase que se encarga de convertir textos en comandos
 */
public class CommandParser {
	private final static Command[] commands = { new Help(), new Quit(), new Load(), new Replace(), new Compile(),
			new Run() };

	/**
	 * Convierte un texto a un objeto de tipo <code>Command</code>.
	 * 
	 * @param linea
	 *            cadena de texto
	 * @return <code>Command</code> correspondiente al texto, si es incorrecto
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

	/**
	 * Constructor de la clase
	 */
	public CommandParser() {
	}
}
