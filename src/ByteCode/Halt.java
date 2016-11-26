package ByteCode;

import CPU.CPU;

public class Halt extends ByteCode {

	@Override
	public boolean execute(CPU cpu) {
		cpu.setHalt();
		return true;
	}

	@Override
	public ByteCode parse(String[] s) {
		if(s.length == 1 && s[0].equalsIgnoreCase(ENUM_BYTECODE.HALT.toString())) {
			return new Halt();
		}
		return null;
	}

	@Override
	public String toString() {
		return ENUM_BYTECODE.HALT.toString();
	}
}
