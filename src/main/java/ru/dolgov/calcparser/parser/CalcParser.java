package ru.dolgov.calcparser.parser;

import ru.dolgov.calcparser.operators.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CalcParser {
    List<Operation> operations;

    public CalcParser() {
        operations = new ArrayList<>();
    }

    public double calculate(String expression) {
        //String replaceSpace = expression.replaceAll("\\s+", "");
        double result = Double.NaN;
        for (Operation operation: operations) {
            if (expression.contains(operation.getSign())) {
                result = parse(operation, expression);
            }
        }
        return result;
    }

    private boolean isExpressionContainOperation(String expression) {
        for (Operation operation: operations) {
            if (expression.contains(operation.getSign())) {
                return true;
            }
        }
        return false;
    }

    private String parse(Operation operation, String expression) {
        String result;
        String[] expressions = expression.split(operation.getSign());
        for (int i = 0; i < expressions.length - 1; i++) {
            if (isExpressionContainOperation(expressions[i])) {
                expressions[i] = Double.toString(calculate(expressions[i]));
            } else {
                result = expressions[0];
                for (int j = 0; j < expressions.length - 2; j++) {
                    result = Double.toString(operation.calculate(Double.parseDouble(result), Double.parseDouble(expressions[1])));
                }
            }
        }
        return result;
    }

    public void getOperations(Operation operation) {
        operations.add(operation);
        operations.sort(new Comparator<Operation>() {
            @Override
            public int compare(Operation o1, Operation o2) {
                    if (o1.getPriority() == o2.getPriority()) {
                        return 0;
                    }
                    if (o1.getPriority() < o2.getPriority()) {
                        return 1;
                    }
                    return -1;
            }
        });
    }


}
