package ConditionalJumps;

import ByteCode.ByteCode;
import CPU.CPU;

public class IFEQ extends ConditionalJumps {

	@Override
	public boolean execute(CPU cpu) {
		if (cpu.numeroValoresEnPila() >= 2) {
			int cima = cpu.pop();
			int subcima = cpu.pop();
			if (cima != subcima) {
				cpu.goTo(this.position);
			}
			return true;
		}
		return false;
	}

	@Override
	public ByteCode parse(String[] s) {
		if (s.length == 2 && s[0].equalsIgnoreCase("IFEQ")) {
			IFEQ newIFEQ = new IFEQ();
			newIFEQ.setPosition(Integer.parseInt(s[1]));
			return newIFEQ;
		}
		return null;
	}

	@Override
	public String toString() {
		return "IFEQ " + this.position;
	}

}
