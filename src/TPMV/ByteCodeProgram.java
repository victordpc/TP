package TPMV;

public class ByteCodeProgram {

	private final ByteCode[] program;
	private int nextProgramPosition = 0;
	private static final int EXTEND_VALUE = 1000;

	public ByteCodeProgram() {
		program = new ByteCode[EXTEND_VALUE];
	}

	public boolean addByteCode(ByteCode byteCode) {
		if (nextProgramPosition < EXTEND_VALUE) {
			program[nextProgramPosition++] = byteCode;
			return true;
		} else
			return false;
	}

	public ByteCode getProgram(int position) {
		return program[position];
	}

	public void replace(int position, ByteCode newInstruction) {
		this.program[position] = newInstruction;
	}

	public String toString() {
		String objectInfo = "";
		objectInfo += "Programa almacenado: "
				+ System.getProperty("line.separator");
		for (int i = 0; i < nextProgramPosition; i++) {
			ByteCode storedByteCode = program[i];
			switch (storedByteCode.name) {
			case PUSH:
			case LOAD:
			case STORE:
				objectInfo += i + ": " + storedByteCode.getName().toString()
						+ " " + storedByteCode.getParam()
						+ System.getProperty("line.separator");
				break;
			default:
				objectInfo += i + ": " + storedByteCode.getName().toString()
						+ System.getProperty("line.separator");
				break;
			}
		}
		return objectInfo;
	}

	public int getLength() {
		return this.nextProgramPosition;
	}

	public boolean reset() {
		nextProgramPosition = 0;
		return true;
	}
}
