package ByteCode;

import CPU.CPU;

public class Out extends ByteCode {

	@Override
	public boolean execute(CPU cpu) {
		return true;
	}

	@Override
	public ByteCode parse(String[] s) {
		if(s.length == 1 && s[0].equalsIgnoreCase(ENUM_BYTECODE.OUT.toString())) {
			return new Out();
		}
		return null;
	}

	@Override
	public String toString() {
		return ENUM_BYTECODE.OUT.toString();
	}
}
