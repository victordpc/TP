package ByteCode;

import CPU.CPU;

public class Push extends ByteCode {

	private int param; // PUSH, STORE, LOAD

	@Override
	public boolean execute(CPU cpu) {
		return cpu.push(param);
	}

	@Override
	public ByteCode parse(String[] s) {
		if(s.length == 2 && s[0].equalsIgnoreCase(ENUM_BYTECODE.PUSH.toString())) {
			Push newPush = new Push();
			newPush.setParam(Integer.parseInt(s[1]));
			return newPush;
		}
		return null;
	}
	
	public void setParam(int param) {
		this.param = param;
	}
	
	@Override
	public String toString() {
		return ENUM_BYTECODE.PUSH.toString() +" "+ param;
	}

}
