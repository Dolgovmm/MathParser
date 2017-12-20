package ru.dolgov.calcparser.operators;

public class Division extends Operation {

    public Division() {
        priority = 1;
        sign = "/";
    }

    public double calculate(double leftOperand, double rightOperand) {
        return leftOperand / rightOperand;
    }
}
