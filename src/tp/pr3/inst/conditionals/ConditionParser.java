package tp.pr3.inst.conditionals;

import tp.pr3.elements.LexicalParser;

public class ConditionParser {

    private final static Condition[] conditions = {new Equal(), new NotEqual(), new Less(), new LessEq()};

    public static Condition parse(String t1, String op, String t2, LexicalParser parser) {
        for (Condition conditionParser: conditions) {
            Condition condition = conditionParser.parse(t1, op, t2, parser);
            if (condition != null){
                return condition;
            }
        }
        return null;
    }
}
