package TPMV;

/**
 * Enumerado para indicar los comandos admitidos por el sistema.
 */
public enum ENUM_COMMAND {
	/**
	 * Muestra información sobre los comandos disponibles.
	 */
	HELP,
	/**
	 * Cierra la aplicación.
	 */
	QUIT,
	/**
	 * Introduce una instrucción bytecode al programa actual.
	 */
	NEWINST,
	/**
	 * Ejecuta el programa actual.
	 */
	RUN,
	/**
	 * Inicializa el programa actual.
	 */
	RESET,
	/**
	 * Solicita una nueva instrucción bytecode que remplaza a una existente.
	 */
	REPLACE
}
