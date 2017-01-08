package bytecode.oneparameter.conditional;

public class ConditionalHelper {

    public static boolean isAValidOperator(String operator) {
        if (operator.equals("==") || operator.equals("<") || operator.equals("<=") || operator.equals(">=")) {
            return true;
        }
        return false;
    }
}
