package ConditionalJumps;

import ByteCode.ByteCode;
import CPU.CPU;

public class IFLEQ extends ConditionalJumps {

	@Override
	public boolean execute(CPU cpu) {
		if (cpu.numeroValoresEnPila() >= 2) {
			int cima = cpu.pop();
			int subcima = cpu.pop();
			if (!(cima >= subcima)) {
				cpu.goTo(this.position);
				return true;
			}
		}
		return false;
	}

	@Override
	public ByteCode parse(String[] s) {
		if (s.length == 2 && s[0].equalsIgnoreCase("IFLEQ")) {
			IFLEQ newIFLEQ = new IFLEQ();
			newIFLEQ.setPosition(Integer.parseInt(s[1]));
			return newIFLEQ;
		}
		return null;
	}

	@Override
	public String toString() {
		return "IFLEQ " + position;
	}

}
