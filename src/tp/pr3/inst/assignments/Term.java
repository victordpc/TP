package tp.pr3.inst.assignments;

import tp.pr3.bc.ByteCode;

/**
 * Representa los terminos existentes en una instrución
 */
public interface Term {

	/**
	 * Genera el <code>ByteCode</code> correspondiente
	 * 
	 * @param compiler
	 *            objeto con el que se va a operar
	 * 
	 * @return ByteCode corrrespondiente
	 */
	ByteCode compile(Compiler compiler);

	/**
	 * Conierte una cadena de texto en un <code>Term</code>
	 * 
	 * @param term
	 *            cadena de texto a convertir
	 * 
	 * @return termino que resulta de convertir la cadena de texto si ha sido
	 *         exitoso, en otro caso <code>NULL</code>
	 */
	Term parse(String term);
}