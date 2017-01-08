package tpmv.compiler.instruction.conditionals;

import bytecode.oneparameter.GoTo;
import bytecode.oneparameter.conditional.ConditionalJump;
import elements.Compiler;
import exceptions.ArrayException;
import exceptions.LexicalAnalysisException;
import elements.LexicalParser;
import tpmv.compiler.ParsedProgram;
import tpmv.compiler.instruction.Instruction;

public class While implements Instruction {

    private Condition condition;
    private ParsedProgram whileBody;

    public While() {
    }

    public While(Condition condition, ParsedProgram whileBody) {
        this.condition = condition;
        this.whileBody = whileBody;
    }

    @Override
    public Instruction lexParse(String[] words, LexicalParser lexParser) {

        if (words.length != 4 || !words[0].equalsIgnoreCase("WHILE")) {
            return null;
        } else {
            try {
                Condition condition = ConditionParser.parse(words[1], words[2], words[3], lexParser);
                ParsedProgram whileBody = new ParsedProgram();
                lexParser.lexicalParser(whileBody, "ENDWHILE");

                if (condition != null && whileBody != null) {
                    lexParser.increaseProgramCounter();
                    return new While(condition, whileBody);
                }
            } catch (LexicalAnalysisException exception) {
                return null;
            }
        }
        return null;
    }

    @Override
    public void compile(Compiler compiler) throws ArrayException {
        int whileIndex = compiler.getCurrentNumberOfByteCodes();
        this.condition.compile(compiler);
        compiler.compile(this.whileBody);
        ConditionalJump conditionalJump = this.condition.conditionalJump;
        int jump = compiler.getCurrentNumberOfByteCodes() + 1;
        conditionalJump.setJump(jump);
        compiler.addByteCode(new GoTo(whileIndex));
    }
}
