package tp.pr3.command;

import tp.pr3.exceptions.ArrayException;
import tp.pr3.mv.Engine;

public class Load extends Command {

    private String fileName;

    public Load() {
        super();
    }

    @Override
    public boolean execute(Engine engine)  throws java.io.FileNotFoundException, ArrayException {
        return engine.executeLoad(this.fileName);
    }

    @Override
    public Command parse(String[] s) {
        if (s.length == 2 && s[0].equalsIgnoreCase("Load")) {
           Load loadCommand = new Load();
           loadCommand.setFileName(s[1]);
           return loadCommand;
        }
        return null;
    }

    @Override
    public String textHelp() {
        return "    LOAD FICH: Carga el fichero de nombre FICH como programa fuente. No realiza " +
                "ningún tipo de comprobación sintáctica." + System.getProperty("line.separator");
    }

    @Override
    public String toString() {
        return "LOAD " + fileName + System.getProperty("line.separator");
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
