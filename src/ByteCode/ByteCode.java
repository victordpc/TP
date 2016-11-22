package ByteCode;

import TPMV.CPU;

/**
 * Clase que representa las instrucciones que puede manejar la máquina virtual.
 */
public abstract class ByteCode {

	/**
	 * Ejecuta el {@code ByteCode}
	 * 
	 * @param cpu
	 *            instancia en la que se ejecuta el {@code ByteCode}
	 * 
	 * @return {@code true} exito de la operacion, {@code false} en otro caso
	 */
	abstract public boolean execute(CPU cpu);

	/**
	 * Convierte un texto a un objeto de tipo {@code ByteCode}.
	 * 
	 * @param s
	 *            cadena de texto.
	 * @return {@code ByteCode} correspondiente al texto, si es incorrecto
	 *         devuelve {@code null}.
	 */
	abstract public ByteCode parse(String[] s);

}

// public class ByteCode {
//
// ENUM_BYTECODE name;
// private int param; // PUSH, STORE, LOAD
//
// /**
// * Constructor de la clase
// *
// * @param name
// * nombre del enumerado {@code ENUM_BYTECODE} que identifica que
// * {@code ByteCode} estamos creando.
// * @param parametro
// * entero necesario para las instrucciones {@code PUSH},
// * {@code STORE}, {@code LOAD}.
// */
// public ByteCode(ENUM_BYTECODE name, int parametro) {
// this.name = name;
// this.param = parametro;
// }
//
// /**
// * Constructor de la clase
// *
// * @param name
// * nombre del enumerado {@code ENUM_BYTECODE} que identifica que
// * {@code ByteCode} estamos creando.
// */
// public ByteCode(ENUM_BYTECODE name) {
// this.name = name;
// }
//
// /**
// * @return valor del atributo name
// */
// public ENUM_BYTECODE getName() {
// return this.name;
// }
//
// /**
// * @return valor del atributo param
// */
// public int getParam() {
// return this.param;
// }
//
// @Override
// public String toString() {
// switch (this.name) {
// case PUSH:
// case LOAD:
// case STORE:
// return this.name + " " + this.param;
// default:
// return this.name.toString();
// }
// }
// }
