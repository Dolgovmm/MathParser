package ru.dolgov.calcparser.operators;

public class Division extends Operation {

    public double calculate(double leftOperand, double rightOperand) {
        return leftOperand / rightOperand;
    }
}
