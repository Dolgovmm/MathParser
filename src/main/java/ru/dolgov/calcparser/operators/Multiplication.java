package ru.dolgov.calcparser.operators;

public class Multiplication extends Operation {

    public Multiplication() {
        priority = 1;
        sign = "*";
    }

    public double calculate(double leftOperand, double rightOperand) {
        return leftOperand * rightOperand;
    }
}
