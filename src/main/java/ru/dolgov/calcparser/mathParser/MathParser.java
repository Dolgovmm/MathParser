package ru.dolgov.calcparser.mathParser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MathParser
{
    public double parse(String expression) throws Exception {
        Pattern pattern = Pattern.compile("(\\d*[\\*/+]{2,})");
        Matcher matcher = pattern.matcher(expression);
        if (matcher.find()) {
            throw new Exception("To many operators in a row '" + expression + "'");
        }
        pattern = Pattern.compile("(\\d*[\\.]{2,}\\d)");
        matcher = pattern.matcher(expression);
        if (matcher.find()) {
            throw new Exception("To many dots in a row '" + expression + "'");
        }

        Result result = additionSubtraction(expression);
        if (!result.getRemainingExpression().isEmpty()) {
            throw new Exception("Can't full parse '" + result.getRemainingExpression() + "'");
        }
        return result.getResult();
    }

    private Result additionSubtraction(String expression) throws Exception {
        Result current = multiplicateDivision(expression);
        double result = current.getResult();

        while (current.getRemainingExpression().length() > 0) {
            if (!(current.getRemainingExpression().charAt(0) == '+' || current.getRemainingExpression().charAt(0) == '-')) break;

            char operator = current.getRemainingExpression().charAt(0);
            String remainingExpression = current.getRemainingExpression().substring(1);

            current = multiplicateDivision(remainingExpression);
            if (operator == '+') {
                result += current.getResult();
            } else {
                result -= current.getResult();
            }
        }
        return new Result(result, current.getRemainingExpression());
    }

    private Result multiplicateDivision(String expression) throws Exception {
        Result current = getResultFromRemainingExpression(expression);

        double result = current.getResult();
        while (true) {
            if (current.getRemainingExpression().length() == 0) {
                return current;
            }
            char operator = current.getRemainingExpression().charAt(0);
            if ((operator != '*' && operator != '/')) return current;

            String remainingPartOfExpression = current.getRemainingExpression().substring(1);
            Result right = getResultFromRemainingExpression(remainingPartOfExpression);

            if (operator == '*') {
                result *= right.getResult();
            } else {
                result /= right.getResult();
            }
            current = new Result(result, right.getRemainingExpression());
        }
    }

   private Result getResultFromRemainingExpression(String expression) throws Exception {

        boolean negative = false;
        if (expression.charAt(0) == '-'){
            negative = true;
            expression = expression.substring( 1 );
        }

       int i = 0;
       int dotCount = 0;
        while (i < expression.length() && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
            if (expression.charAt(i) == '.' && ++dotCount > 1) {
                throw new Exception("Not valid number in '" + expression.substring(0, i + 1) + "'");
            }
            i++;
        }

        if( i == 0 ) {
            throw new Exception( "Can't get valid number in '" + expression + "'" );
        }

        double operand = Double.parseDouble(expression.substring(0, i));
        if (negative) {
            operand = -operand;
        }
        String remainingPart = expression.substring(i);

        return new Result(operand, remainingPart);
    }
}