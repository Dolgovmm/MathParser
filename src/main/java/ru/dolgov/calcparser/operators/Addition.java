package ru.dolgov.calcparser.operators;

public class Addition extends Operation {

    public double calculate(double leftOperand, double rightOperand) {
        return leftOperand + rightOperand;
    }
}
