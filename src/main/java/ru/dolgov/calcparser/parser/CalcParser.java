package ru.dolgov.calcparser.parser;

import ru.dolgov.calcparser.operators.Division;
import ru.dolgov.calcparser.operators.Operation;

public class CalcParser {

    public double parse(String expression) {
        //String replaceSpace = expression.replaceAll("\\s+", "");
        if (expression.contains("/")) {
            Operation division = new Division();
            String[] expressions = expression.split("/");
            for (int i = 0; i < expressions.length - 1; i++) {
                if (isExpressionContainOperation(expressions[i])) {
                    expressions[i] = Double.toString(parse(expressions[i]));
                } else {
                    double result = Double.parseDouble(expressions[0]);
                    for (int j = 0; j < expressions.length - 2; j++) {
                        result = division.calculate(result, Double.parseDouble(expressions[i + 1]));
                    }
                    return result;
                }
            }
        }
        return Double.NaN;
    }

    private boolean isExpressionContainOperation(String expression) {
        if ((expression.contains("/")) || (expression.contains("*")) || (expression.contains("+")) || (expression.contains("-"))) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        CalcParser calcParser = new CalcParser();
        System.out.println(calcParser.parse("5/5/1"));
    }
}
