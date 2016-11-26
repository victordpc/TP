package Arithmetics;

import ByteCode.ByteCode;
import CPU.CPU;

public abstract class Arithmetics extends ByteCode {
	
	@Override
	public abstract boolean execute(CPU cpu);

	@Override
	public abstract ByteCode parse(String[] s);
}
