package ByteCode;

import CPU.CPU;

/**
 * Clase que representa las instrucciones que puede manejar la máquina virtual.
 */
public abstract class ByteCode {

	abstract public boolean execute(CPU cpu);
	abstract public ByteCode parse(String[] s);

}
