package tp.pr3.inst;

import tp.pr3.elements.Compiler;
import tp.pr3.elements.LexicalParser;
import tp.pr3.exceptions.ArrayException;

/**
 * Interfaz para las instrucciones
 */
public interface Instruction {

	/**
	 * Realiza la compilación de instruciones
	 * 
	 * @param compiler
	 *            compilador que se usa
	 * @throws ArrayException
	 *             para contemplar errores de acceso a posiciones incorrectas de
	 *             un array
	 */
	void compile(Compiler compiler) throws ArrayException;

	/**
	 * Realiza el parseo léxico de las instrucciones
	 * 
	 * @param words
	 *            cadena a parsear
	 * @param lexparser
	 *            parseor utilizado
	 * @return instrucción parseada
	 */
	Instruction lexParse(String[] words, LexicalParser lexparser);
}