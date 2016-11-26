package ConditionalJumps;

import ByteCode.ByteCode;
import CPU.CPU;

public abstract class ConditionalJumps extends ByteCode {

	protected int position;
	
	@Override
	public abstract boolean execute(CPU cpu);

	@Override
	public abstract ByteCode parse(String[] s);
	
	public void setPosition(int position) {
		this.position = position;
	}

}
