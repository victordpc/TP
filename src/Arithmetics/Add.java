package Arithmetics;

import ByteCode.ByteCode;
import ByteCode.ENUM_BYTECODE;
import CPU.CPU;

public class Add extends Arithmetics {

	@Override
	public boolean execute(CPU cpu) {
		int value2 = cpu.pop();
		int value1 = cpu.pop();
		return cpu.push(value1 + value2);
	}

	@Override
	public ByteCode parse(String[] s) {
		if(s.length == 1 && s[0].equalsIgnoreCase(ENUM_BYTECODE.ADD.toString())) {
			return new Add();
		}
		return null;
	}

}
