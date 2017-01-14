package tp.pr3.inst.conditionals;

import tp.pr3.bc.jumps.ConditionalJump;
import tp.pr3.elements.Compiler;
import tp.pr3.exceptions.ArrayException;
import tp.pr3.exceptions.LexicalAnalysisException;
import tp.pr3.elements.LexicalParser;
import tp.pr3.mv.ParsedProgram;
import tp.pr3.inst.Instruction;

public class IfThen implements Instruction {

    private Condition condition;
    private ParsedProgram body;

    public IfThen(){}

    public IfThen(Condition condition, ParsedProgram body) {
        this.condition = condition;
        this.body = body;
    }

    @Override
    public Instruction lexParse(String[] words, LexicalParser lexParser) {
        if (words.length != 4 || !words[0].equalsIgnoreCase("IF")){
            return null;
        }else {
            try {
                Condition condition = ConditionParser.parse(words[1], words[2], words[3], lexParser);
                ParsedProgram ifThenBody = new ParsedProgram();
                lexParser.lexicalParser(ifThenBody, "ENDIF");
                if (condition != null && ifThenBody != null) {
                    lexParser.increaseProgramCounter();
                    return new IfThen(condition, ifThenBody);
                }
            } catch (LexicalAnalysisException exception) {
                System.out.println("Excepcion en el parseo del condicional IFThen: " + exception.getMessage());
                return null;
            }
        }
        return null;
    }

    @Override
    public void compile(Compiler compiler) throws ArrayException {
        this.condition.compile(compiler);
        compiler.compile(this.body);
        ConditionalJump conditionalJump = this.condition.conditionalJump;
        int jump = compiler.getCurrentNumberOfByteCodes();
        conditionalJump.setJump(jump);
    }
}
