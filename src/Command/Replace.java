package Command;

import TPMV.Engine;

public class Replace extends Command {
	
	private int position;
	
	@Override
	public boolean execute(Engine engine) {
		return engine.executeReplace(position);
	}

	@Override
	public Command parse(String[] s) {
		if (s.length == 2) {
			int position = Integer.parseInt(s[1]);
			if (position >= 0) {
				if(s[0].equalsIgnoreCase(ENUM_COMMAND.REPLACE.toString())) {
					Replace newReplace = new Replace();
					newReplace.setPosition(position);
					return newReplace;
				}
			}
		}
		return null;
	}

	@Override
	public String textHelp() {
		return " REPLACE N: Solicita al usuario una nueva instrucción BC, "
				+ "que en caso de ser correcta reemplazará a la instrucción "
				+ "bytecode número N del programa." + System.getProperty("line.separator");
	}

	public String toString() {
		String resultado = ENUM_COMMAND.REPLACE.toString();
		if (this.position > -1)
			resultado += " " + this.position;
		return resultado;
	}
	
	public void setPosition(int position) {
		this.position = position;
	}
	
}
