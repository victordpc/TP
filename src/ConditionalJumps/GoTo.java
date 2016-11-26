package ConditionalJumps;

import ByteCode.ByteCode;
import ByteCode.ENUM_BYTECODE;
import CPU.CPU;

public class GoTo extends ConditionalJumps {

	@Override
	public boolean execute(CPU cpu) {
		cpu.goTo(this.position);
		return true;
	}

	@Override
	public ByteCode parse(String[] s) {
		if(s.length == 2 && s[0].equalsIgnoreCase(ENUM_BYTECODE.GOTO.toString())) {
			GoTo newGoTo = new GoTo();
			newGoTo.setPosition(Integer.parseInt(s[1]));
			return newGoTo;
		}
		return null;
	}
	
	@Override
	public String toString() {
		return ENUM_BYTECODE.GOTO.toString() +" "+ position;
	}

}
