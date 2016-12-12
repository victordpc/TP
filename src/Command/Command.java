package Command;

import TPMV.Engine;

/**
 * Clase que representa los comandos admitidos.
 */
public abstract class Command {
	/**
	 * Realiza la operación del comando
	 * 
	 * @param engine
	 *            instancia en la que se ejecutan los comandos.
	 * @return <code>true</code> exito de la operacion, <code>false</code> en otro caso
	 */
	abstract public boolean execute(Engine engine);

	/**
	 * Convierte un texto en comando
	 * 
	 * @param s
	 *            descomposicion de la cadena introducida
	 * @return representa la cadena recibida
	 */
	abstract public Command parse(String[] s);

	/**
	 * Muestra la ayuda del comando
	 * 
	 * @return cadena de texto con la explicación del comando
	 */
	abstract public String textHelp();

}