package ru.dolgov.mathparser;

public class Result {
    private double result;
    private String remainingExpression;

    public Result(double result, String remainingExpression) {
        this.result = result;
        this.remainingExpression = remainingExpression;
    }

    public double getResult() {
        return result;
    }

    public String getRemainingExpression() {
        return remainingExpression;
    }
}
