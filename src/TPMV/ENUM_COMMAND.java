package TPMV;

/**
 * Enumerado para indicar los comandos admitidos por el sistema.
 */
public enum ENUM_COMMAND {
	/**
	 * Muestra informacion sobre los comandos disponibles.
	 */
	HELP,
	/**
	 * Cierra la aplicacion.
	 */
	QUIT,
	/**
	 * Introduce una instruccion bytecode al programa actual.
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
	 * Solicita una nueva instruccion bytecode que remplaza a una existente.
	 */
	REPLACE
}
