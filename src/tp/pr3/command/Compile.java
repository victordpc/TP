package tp.pr3.command;

import tp.pr3.exceptions.ArrayException;
import tp.pr3.exceptions.LexicalAnalysisException;
import tp.pr3.mv.Engine;

public class Compile extends Command {
    @Override
    public boolean execute(Engine engine) throws LexicalAnalysisException, ArrayException {
        engine.compile();
        return true;
    }

    @Override
    public Command parse(String[] s){
        if (s.length == 1 && s[0].equalsIgnoreCase("Compile"))
            return new Compile();
        return null;
    }

    @Override
    public String textHelp() {
        return "    COMPILE: realiza el análisis léxico del programa fuente, " +
                "generando un nuevo programa parseado y, posteriormente a partir " +
                "del programa parseado genera un programa bytecode." + System.getProperty("line.separator");
    }

    public String toString(){
        return "Compile" + System.getProperty("line.separator");
    }

}
