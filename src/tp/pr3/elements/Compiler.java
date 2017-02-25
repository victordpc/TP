package tp.pr3.elements;

import tp.pr3.bc.ByteCode;
import tp.pr3.exceptions.ArrayException;
import tp.pr3.inst.Instruction;
import tp.pr3.mv.ByteCodeProgram;
import tp.pr3.mv.ParsedProgram;

/**
 * Clase que representa el compilador de la máquina virtual, pasamos de un
 * <code>ParsedProgram</code> a un <code>ByteCodeProgram</code>
 */
public class Compiler {
	ByteCodeProgram bcProgram = null;
	int numVars = 0;
	String[] varTable = new String[28];

	/**
	 * Constructor de la clase
	 */
	public Compiler() {

	}

	/**
	 * Agrega un ByteCode al programa
	 * 
	 * @param bc
	 *            ByteCode a agregar
	 * @throws ArrayException
	 *             para contemplar errores de acceso a posiciones incorrectas de
	 *             un array
	 */
	public void addByteCode(ByteCode bc) throws ArrayException {
		bcProgram.addByteCode(bc, bcProgram.size());
	}

	/**
	 * Añade una variable
	 * 
	 * @param varName
	 *            nombre de la variable
	 * @return índice de la variable
	 */
	public int addVariable(String varName) {
		this.varTable[this.numVars++] = varName;
		return numVars - 1;
	}

	/**
	 * Compila un programa parseado
	 * 
	 * @param pProgram
	 *            programa donde lee las instruciones para compilar
	 * @throws ArrayException
	 *             para contemplar errores de acceso a posiciones incorrectas de
	 *             un array
	 */
	public void compile(ParsedProgram pProgram) throws ArrayException {
		int i = 0;
		while (i < pProgram.getSize()) {
			Instruction instr = pProgram.getInstruction(i);
			instr.compile(this);
			i++;
		}
	}

	/**
	 * Devuelve el tamaño actual del programa ByteCode
	 * 
	 * @return número de elementos del programa ByteCode
	 */
	public int getSizeBcProgram() {
		return bcProgram.size();
	}

	/**
	 * Este método devuelve el índice de la variable varName en la tabla de
	 * variables, con el efecto colateral de que si no está, añade la variable a
	 * la tabla
	 * 
	 * @param varName
	 *            nombre de la variable
	 * @return indice de la variable
	 */
	public int indexOf(String varName) {
		for (int i = 0; i < numVars; i++) {
			if (this.varTable[i].equalsIgnoreCase(varName)) {
				return i;
			}
		}
		return this.addVariable(varName);
	}

	/**
	 * Inicializa la clase compiler
	 * 
	 * @param bcProgram
	 *            programa ByteCode que rellena
	 */
	public void initialize(ByteCodeProgram bcProgram) {
		this.bcProgram = bcProgram;
		this.numVars = 0;
	}

	@Override
	public String toString() {
		String cadena = "Compiler [programa ByteCode=" + bcProgram.toString();
		cadena += ", numero de variables=" + numVars + " ";
		cadena += "tabla de variables=";
		for (int i = 0; i < numVars; i++) {
			cadena += varTable[i] + " ";
		}
		cadena += "]";
		return cadena;
	}

}
