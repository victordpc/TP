package tp.pr3.bc.jumps.conditionaljumps;

public class ConditionalHelper {

    public static boolean isAValidOperator(String operator) {
        if (operator.equals("==") || operator.equals("<") || operator.equals("<=") || operator.equals(">=")) {
            return true;
        }
        return false;
    }
}
