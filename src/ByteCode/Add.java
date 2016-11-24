package ByteCode;

import TPMV.CPU;

/**
 * Clase que representa la instrución {@code ADD}
 * 
 * @author victor
 */
public class Add extends ByteCode {

	/**
	 * Constructor de la clase
	 */
	public Add() {
	}

	@Override
	public boolean execute(CPU cpu) {
		return cpu.add();
	}

	@Override
	public ByteCode parse(String[] s) {
		if (s.length == 1 && s[0].equalsIgnoreCase("Add"))
			return new Add();
		return null;
	}

	public String toString()	{return "ADD"+System.getProperty("line.separator");}
}
