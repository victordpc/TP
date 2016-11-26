package ByteCode;

import CPU.CPU;

public class Load extends ByteCode {

	private int position;

	@Override
	public boolean execute(CPU cpu) {
		int value = cpu.read(position); 
		return cpu.push(value);
	}

	@Override
	public ByteCode parse(String[] s) {
		if(s.length == 2 && s[0].equalsIgnoreCase(ENUM_BYTECODE.LOAD.toString())) {
			Load newLoad = new Load();
			newLoad.setPosition(Integer.parseInt(s[1]));
			return newLoad;
		}
		return null;
	}
	
	public void setPosition(int position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return ENUM_BYTECODE.LOAD.toString() +" "+ position;
	}
}
