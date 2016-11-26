package ByteCode;

/**
 * Enumerado para indicar los {@code ByteCode} admitidos por el sistema.
 */
public enum ENUM_BYTECODE {
	/**
	 * Introduce un valor en la pila.
	 */
	PUSH,
	/**
	 * Saca la cima de la pila y la introduce en la memoria.
	 */
	STORE,
	/**
	 * Carga un valor de memoria en la cima de la pila.
	 */
	LOAD,
	/**
	 * Saca la subcima y cima de la pila, suma la subcima a la cima e introduce
	 * el resultado en la pila.
	 */
	ADD,
	/**
	 * Saca la subcima y cima de la pila, resta la subcima a la cima e introduce
	 * el resultado en la pila.
	 */
	SUB,
	/**
	 * Saca la subcima y cima de la pila, multiplica la subcima a la cima e
	 * introduce el resultado en la pila.
	 */
	MUL,
	/**
	 * Saca la subcima y cima de la pila, divide la subcima a la cima e
	 * introduce el resultado en la pila.
	 */
	DIV,
	/**
	 * Muestra la cima de la pila.
	 */
	OUT,
	/**
	 * Para la ejecución del programa.
	 */
	HALT
}
