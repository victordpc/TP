package tp.pr3.cm;

import java.io.FileNotFoundException;

import tp.pr3.exceptions.ArrayException;
import tp.pr3.exceptions.BadFormatByteCodeException;
import tp.pr3.exceptions.ExecutionErrorException;
import tp.pr3.exceptions.LexicalAnalysisException;
import tp.pr3.mv.Engine;

/**
 * Clase que representa los comandos admitidos.
 */
public interface Command {

	/**
	 * Convierte un texto en comando
	 * 
	 * @param s
	 *            descomposicion de la cadena introducida
	 * @return representa la cadena recibida
	 */
	public Command parse(String[] s);

	/**
	 * Muestra la ayuda del comando
	 * 
	 * @return cadena de texto con la explicación del comando
	 */
	public String textHelp();

	/**
	 * Realiza la operación del comando
	 * 
	 * @param engine
	 *            instancia en la que se ejecutan los comandos.
	 * @throws LexicalAnalysisException
	 *             Se lanza si se produce un comportamiento no esperado cuando
	 *             se analice léxicamente un programa
	 * @throws ArrayException
	 *             Se lanza si se produce un acceso a una posición no válida de
	 *             un array
	 * @throws BadFormatByteCodeException
	 *             Se utiliza para detectar que un posible bytecode no se ajusta
	 *             a la sintaxis especificada
	 * @throws ExecutionErrorException
	 *             Se usa para errores en ejecución
	 * @throws FileNotFoundException
	 *             Intento de abrir un fichero no existente
	 */
	void execute(Engine engine) throws BadFormatByteCodeException, ArrayException, ExecutionErrorException,
			FileNotFoundException, LexicalAnalysisException;

}