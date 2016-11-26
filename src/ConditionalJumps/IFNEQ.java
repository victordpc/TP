package ConditionalJumps;

import ByteCode.ByteCode;
import CPU.CPU;

public class IFNEQ extends ConditionalJumps {

	@Override
	public boolean execute(CPU cpu) {
		if(cpu.numeroValoresEnPila() >= 2) {
			int cima = cpu.pop();
			int subcima = cpu.pop();
			if(subcima == cima) {
				cpu.goTo(this.position);
			}
			return true;
		}
		return false;
	}

	@Override
	public ByteCode parse(String[] s) {
		if(s.length == 2 && s[0].equalsIgnoreCase("IFNEQ")) {
			IFNEQ newIFNEQ = new IFNEQ();
			newIFNEQ.setPosition(Integer.parseInt(s[1]));
			return newIFNEQ;
		}
		return null;
	}
	
	@Override
	public String toString() {
		return "IFNEQ " + position;
	}

}
