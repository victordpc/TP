package Command;

/**
 * Enumerado para indicar los comandos admitidos por el sistema.
 */
public enum ENUM_COMMAND {
	/**
	 * Muestra informacion sobre los comandos disponibles.
	 */
	HELP,
	/**
	 * Cierra la aplicación.
	 */
	QUIT,
	/**
	 * Introduce una instruccion bytecode al programa actual.
	 */
	BYTECODE,
	/**
	 * Ejecuta el programa actual.
	 */
	RUN,
	/**
	 * Inicialíza el programa actual.
	 */
	RESET,
	/**
	 * Solicita una nueva instruccion {@code ByteCode} que remplaza a una
	 * existente.
	 */
	REPLACE
}
