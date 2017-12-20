package ru.dolgov.calcparser.operators;

public abstract class Operation {
    protected int priority;
    protected String sign;

    public abstract double calculate(double leftOperand, double rightOperand);

    public int getPriority() {
        return priority;
    }

    public  String getSign() {
        return sign;
    }
}
