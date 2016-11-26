package Arithmetics;

import ByteCode.ByteCode;
import ByteCode.ENUM_BYTECODE;
import CPU.CPU;

public class Div extends Arithmetics {

	@Override
	public boolean execute(CPU cpu) {
		int value2 = cpu.pop();
		int value1 = cpu.pop();
		boolean success = true;
		if (value2 != 0)
			cpu.push(value1 / value2);
		else {
			cpu.push(value2);
			cpu.push(value1);
			success=false;
		}
		return success;
	}

	@Override
	public ByteCode parse(String[] s) {
		if(s.length == 1 && s[0].equalsIgnoreCase(ENUM_BYTECODE.DIV.toString())) {
			return new Add();
		}
		return null;
	}
}
