package ru.dolgov.calcparser.operators;

public class Addition extends Operation {

    public Addition() {
        priority = 2;
        sign = "+";
    }

    public double calculate(double leftOperand, double rightOperand) {
        return leftOperand + rightOperand;
    }


}
