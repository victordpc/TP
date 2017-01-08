package tpmv.compiler.instruction.conditionals;

import bytecode.oneparameter.conditional.ConditionalJump;
import elements.Compiler;
import exceptions.ArrayException;
import exceptions.LexicalAnalysisException;
import elements.LexicalParser;
import tpmv.compiler.ParsedProgram;
import tpmv.compiler.instruction.Instruction;

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
