package ru.dolgov.calcparser.operators;

public class Subtraction extends Operation {

    public Subtraction() {
        priority = 1;
        sign = "-";
    }

    public double calculate(double leftOperand, double rightOperand) {
        return leftOperand - rightOperand;
    }
}
