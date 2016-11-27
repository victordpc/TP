package TPMV;

import ByteCode.ByteCode;
import ByteCode.ByteCodeProgram;

/**
 * Clase que contiene el procesamiento de la maquina virtual, contiene una
 * memoria y una pila de operandos.
 */
public class CPU {

	private final Memory memory;
	private final OperandStack stack;
	private boolean halt;
	private int programCounter;
	private ByteCodeProgram bcProgram;

	/**
	 * Constructor de la clase.
	 */
	public CPU() {
		this.memory = new Memory();
		this.stack = new OperandStack();
		this.halt = false;
		this.programCounter = 0;
		this.bcProgram = new ByteCodeProgram();
	}

	/**
	 * Introduce un valor en la cima de la pila.
	 * 
	 * @param valor
	 *            valor a introducir en la pila.
	 * @return {@code true} exito de la operacion, {@code false} en otro caso
	 */
	public boolean push(int valor) {
		return this.stack.push(valor);
	}

	/**
	 * Obtiene la cima de la pila.
	 * 
	 * @return valor almacenado en la cima de la pila.
	 */
	public int pop() {
		return this.stack.pop();
	}

	/**
	 * Introduce un valor en una poición de memoria
	 * 
	 * @param valor
	 *            valor que se introduce en memoria
	 * 
	 * @param posicion
	 *            direcciÃ³n de memoria en la que se guarda.
	 * @return {@code true} exito de la operacion, {@code false} en otro caso
	 */
	public boolean store(int posicion, int valor) {
		return this.memory.write(posicion, valor);
	}

	/**
	 * Lee el valor de una dirección de memoria.
	 * 
	 * @param posicion
	 *            dirección de memoria en la que se lee.
	 * @return valor almacenado en la dirección de memoria indicada
	 */
	public int load(int posicion) {
		return this.memory.read(posicion);
	}

	/**
	 * Establece el contador de programa
	 * 
	 * @param programCounter
	 *            direccion del programa a la que saltar
	 * @return {@code true} exito de la operacion, {@code false} en otro caso
	 */
	public boolean setProgramCounter(int programCounter) {
		if (programCounter >= 0 && programCounter < bcProgram.getLength()) {
			this.programCounter = programCounter;
			return true;
		}
		return false;
	}

	/**
	 * Ejecuta el {@code ByteCode} {@code HALT}, para la ejecuciÃ³n del
	 * programa.
	 * 
	 * @return {@code true} exito de la operacion, {@code false} en otro caso
	 */
	public boolean halt() {
		this.halt = true;
		return true;

	}

	/**
	 * Ejecuta el {@code ByteCode} {@code OUT}, muestra la cima de la pila.
	 * 
	 * @return {@code true} exito de la operacion, {@code false} en otro caso
	 */
	public boolean out() {
		Integer valorPila = this.stack.getLastPosition();
		if (valorPila != null)
			System.out.println("El ultimo valor en la pila es: " + valorPila + System.getProperty("line.separator"));
		else
			System.out.println("La pila no contiene valores");
		this.programCounter++;
		return true;
	}

	@Override
	public String toString() {
		String resultado = "Estado de la CPU: " + System.getProperty("line.separator");
		resultado += this.memory.toString() + System.getProperty("line.separator");
		resultado += this.stack.toString() + System.getProperty("line.separator")
				+ System.getProperty("line.separator");
		return resultado;
	}

	/**
	 * Devuelve el valor del atributo halt.
	 * 
	 * @return valor del atributo halt
	 */
	public boolean isHalted() {
		return this.halt;
	}

	/**
	 * Reinicia la memoria y la pila.
	 */
	public void reset() {
		this.memory.reset();
		this.stack.reset();
		this.halt = false;
		this.programCounter = 0;
	}

	/**
	 * Ejecutar el programa byte- code completo.
	 * 
	 * @return {@code true} exito de la operacion, {@code false} en otro caso
	 */
	public boolean run() {
		boolean correcto = true;

		while (correcto && halt) {
			ByteCode instrucion = bcProgram.getProgram(programCounter);
			correcto = instrucion.execute(this);
		}

		return correcto;
	}

	/**
	 * Avanza el contador de programa
	 */
	public void avanzaPc() {
		this.programCounter++;
	}

	/**
	 * Obtiene el numero de elementos que hay actualmente en la pila
	 * 
	 * @return numero de posiciones de la pila
	 */
	public int getStackLength() {
		return this.stack.getLength();
	}

	// /**
	// * Ejecuta el {@code ByteCode} {@code LOAD}, carga el contenido de una
	// * posiciÃ³n de memoria indicado por parÃ¡metro en la cima de la pila
	// *
	// * @param posicion
	// * direcciÃ³n de memoria origen
	// *
	// * @return {@code true} exito de la operacion, {@code false} en otro caso
	// */
	// public int load(int posicion) {
	// return this.memory.read(posicion);
	// }
	//
	// /**
	// * Ejecuta el {@code ByteCode} {@code STORE}, saca la cima de la pila y la
	// * introduce en la memoria.
	// *
	// * @param posicion
	// * direcciÃ³n de memoria en la que se guarda.
	// * @return {@code true} exito de la operacion, {@code false} en otro caso
	// */
	// public boolean store(int posicion) {
	// if (this.stack.getLength() >= 1) {
	// this.programCounter++;
	// return this.memory.write(posicion, this.stack.pop());
	// }
	// return false;
	// }
	//
	// /**
	// * Ejecuta el {@code ByteCode} {@code LOAD}, carga el contenido de una
	// * posiciÃ³n de memoria indicado por parÃ¡metro en la cima de la pila
	// *
	// * @param posicion
	// * direcciÃ³n de memoria origen
	// *
	// * @return {@code true} exito de la operacion, {@code false} en otro caso
	// */
	// public boolean load(int posicion) {
	// int valor = this.memory.read(posicion);
	// this.programCounter++;
	// return this.stack.push(valor);
	// }
	//
	// /**
	// * Ejecuta el {@code ByteCode} {@code ADD}, saca la subcima y cima de la
	// * pila, suma la subcima a la cima e introduce el resultado en la pila
	// *
	// * @return {@code true} exito de la operacion, {@code false} en otro caso
	// */
	// public boolean add() {
	// if (this.stack.getLength() >= 2) {
	// int value2 = this.stack.pop();
	// int value1 = this.stack.pop();
	// this.programCounter++;
	// return this.stack.push(value1 + value2);
	// }
	// return false;
	// }
	//
	// /**
	// * Ejecuta el {@code ByteCode} {@code SUB}, saca la subcima y cima de la
	// * pila, resta la subcima a la cima e introduce el resultado en la pila.
	// *
	// * @return {@code true} exito de la operacion, {@code false} en otro caso
	// */
	// public boolean sub() {
	// if (this.stack.getLength() >= 2) {
	// int value2 = this.stack.pop();
	// int value1 = this.stack.pop();
	// this.programCounter++;
	// return this.stack.push(value1 - value2);
	// }
	// return false;
	// }
	//
	// /**
	// * Ejecuta el {@code ByteCode} {@code MUL}, saca la subcima y cima de la
	// * pila, multiplica la subcima a la cima e introduce el resultado en la
	// * pila.
	// *
	// * @return {@code true} exito de la operacion, {@code false} en otro caso
	// */
	// public boolean mul() {
	// if (this.stack.getLength() >= 2) {
	// int value2 = this.stack.pop();
	// int value1 = this.stack.pop();
	// this.stack.push(value1 * value2);
	// this.programCounter++;
	// return true;
	// }
	// return false;
	// }
	//
	// /**
	// * Ejecuta el {@code ByteCode} {@code DIV}, saca la subcima y cima de la
	// * pila, divide la subcima a la cima e introduce el resultado en la pila.
	// *
	// * En caso de resultar una divisiÃ³n por cero, restaura los valores de la
	// * pila.
	// *
	// * @return {@code true} exito de la operacion, {@code false} en otro caso
	// */
	// public boolean div() {
	// if (this.stack.getLength() >= 2) {
	// int value2 = this.stack.pop();
	// if (value2 != 0) {
	// int value1 = this.stack.pop();
	// this.stack.push(value1 / value2);
	// this.programCounter++;
	// return true;
	// } else {
	// this.stack.push(value2);
	// }
	// }
	// return false;
	// }
	//
	// /**
	// * Salto a la direcciÃ³n del programa indicada
	// *
	// * @param posicion
	// * direccion del programa a la que saltar
	// * @return {@code true} exito de la operacion, {@code false} en otro caso
	// */
	// public boolean goTo(int posicion) {
	// if (posicion >= 0 && posicion < bcProgram.getLength()) {
	// this.programCounter = posicion;
	// return true;
	// }
	// return false;
	// }
	//
	// /**
	// * Salto a la drecciÃ³n del programa indicada si la subcima es igual a la
	// * cima
	// *
	// * @param posicion
	// * direccion del programa a la que saltar
	// * @return {@code true} exito de la operacion, {@code false} en otro caso
	// */
	// public boolean ifEq(int posicion) {
	// if (this.stack.getLength() >= 2) {
	// int cima = this.stack.pop();
	// int subCima = this.stack.pop();
	// if (cima == subCima)
	// this.programCounter = posicion;
	// else
	// this.programCounter++;
	// return true;
	// }
	// return false;
	// }
	//
	// /**
	// * Salto a la direcciÃ³n del programa indicada si la subcima no es igual a
	// * la cima
	// *
	// * @param posicion
	// * direccion del programa a la que saltar
	// * @return {@code true} exito de la operacion, {@code false} en otro caso
	// */
	// public boolean ifNeq(int posicion) {
	// if (this.stack.getLength() >= 2) {
	// int cima = this.stack.pop();
	// int subCima = this.stack.pop();
	// if (cima != subCima)
	// this.programCounter = posicion;
	// else
	// this.programCounter++;
	// return true;
	// }
	// return false;
	// }
	//
	// /**
	// * Salto a la direcciÃ³n del programa indicada si la subcima es menor que
	// la
	// * cima
	// *
	// * @param posicion
	// * direccion del programa a la que saltar
	// * @return {@code true} exito de la operacion, {@code false} en otro caso
	// */
	// public boolean ifLe(int posicion) {
	// if (this.stack.getLength() >= 2) {
	// int cima = this.stack.pop();
	// int subCima = this.stack.pop();
	// if (cima > subCima)
	// this.programCounter = posicion;
	// else
	// this.programCounter++;
	// return true;
	// }
	// return false;
	// }
	//
	// /**
	// * Salto a la direcciÃ³n del programa indicada si la subcima es menor o
	// * igual que la cima
	// *
	// * @param posicion
	// * direccion del programa a la que saltar
	// * @return {@code true} exito de la operacion, {@code false} en otro caso
	// */
	// public boolean ifLeq(int posicion) {
	// if (this.stack.getLength() >= 2) {
	// int cima = this.stack.pop();
	// int subCima = this.stack.pop();
	// if (cima >= subCima)
	// this.programCounter = posicion;
	// else
	// this.programCounter++;
	// return true;
	// }
	// return false;
	// }

}
