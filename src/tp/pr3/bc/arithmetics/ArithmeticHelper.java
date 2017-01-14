package tp.pr3.bc.arithmetics;

public class ArithmeticHelper {

    public static boolean isAValidOperator(String operator) {
        if (operator.equalsIgnoreCase("+")
                || operator.equalsIgnoreCase("-")
                || operator.equalsIgnoreCase("*")
                || operator.equalsIgnoreCase("/")) {
            return true;
        }
        return false;
    }
}
