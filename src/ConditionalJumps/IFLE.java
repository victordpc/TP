package ConditionalJumps;

import ByteCode.ByteCode;
import CPU.CPU;

public class IFLE extends ConditionalJumps {

	@Override
	public boolean execute(CPU cpu) {
		if(cpu.numeroValoresEnPila() >= 2) {
			int cima = cpu.pop();
			int subcima = cpu.pop();
			if(!(subcima < cima)) {
				System.out.println("CIMA "+cima +" "+ subcima);
				cpu.goTo(this.position);
			}
			return true;
		}
		return false;
	}

	@Override
	public ByteCode parse(String[] s) {
		if(s.length == 2 && s[0].equalsIgnoreCase("IFLE")) {
			IFLE newIFLE = new IFLE();
			newIFLE.setPosition(Integer.parseInt(s[1]));
			return newIFLE;
		}
		return null;
	}
	
	@Override
	public String toString() {
		return "IFLE " + position;
	}

}
