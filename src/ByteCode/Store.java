package ByteCode;

import CPU.CPU;

public class Store extends ByteCode {

	private int position;
	
	@Override
	public boolean execute(CPU cpu) {
		return cpu.write(position);
	}

	@Override
	public ByteCode parse(String[] s) {
		if(s.length == 2 && s[0].equalsIgnoreCase(ENUM_BYTECODE.STORE.toString())) {
			Store newStore = new Store();
			newStore.setPosition(Integer.parseInt(s[1]));
			return newStore;
		}
		return null;
	}
	
	public void setPosition(int position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return ENUM_BYTECODE.STORE.toString() +" "+ position;
	}
}
