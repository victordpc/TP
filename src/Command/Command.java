package Command;

import TPMV.Engine;

/**
 * Clase que representa los comandos admitidos.
 */
public abstract class Command {
	
	abstract public boolean execute(Engine engine);
	
	abstract public Command parse(String[] s);
	
	abstract public String textHelp();
	
}