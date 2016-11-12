package TPMV;

/**
 * Clase que representa las instrucciones que puede manejar la maquina virtual.
 */
public class ByteCode {

	ENUM_BYTECODE name;
	private int param; // PUSH, STORE, LOAD

	/**
	 * Constructor de la clase
	 * 
	 * @param name
	 *            Nombre del enumerado ENUM_BYTECODE que identifica que ByteCode
	 *            estamos creando.
	 * @param parametro
	 *            Parametro necesario para las instrucciones PUSH, STORE, LOAD.
	 */
	public ByteCode(ENUM_BYTECODE name, int parametro) {
		this.name = name;
		this.param = parametro;
	}

	/**
	 * Constructor de la clase
	 * 
	 * @param name
	 *            Nombre del enumerado ENUM_BYTECODE que identifica que ByteCode
	 *            estamos creando.
	 */
	public ByteCode(ENUM_BYTECODE name) {
		this.name = name;
	}

	/**
	 * @return Valor del atributo name
	 */
	public ENUM_BYTECODE getName() {
		return this.name;
	}

	/**
	 * @return Valor del atributo param
	 */
	public int getParam() {
		return this.param;
	}

	@Override
	public String toString() {
		switch (this.name) {
		case PUSH:
		case LOAD:
		case STORE:
			return this.name + " " + this.param;
		default:
			return this.name.toString();
		}
	}
}
