package ru.dolgov.calcparser;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.dolgov.calcparser.operators.Addition;
import ru.dolgov.calcparser.operators.Division;
import ru.dolgov.calcparser.operators.Multiplication;
import ru.dolgov.calcparser.operators.Subtraction;
import ru.dolgov.calcparser.parser.CalcParser;

public class TestCalcParser {
    CalcParser calcParser;

    @Before
    public void createCalcParser() {
        calcParser = new CalcParser();
        calcParser.getOperations(new Addition());
        calcParser.getOperations(new Division());
        calcParser.getOperations(new Multiplication());
        calcParser.getOperations(new Subtraction());
    }

    @Test
    public void testParsingExpression1() {
        double result = calcParser.calculate("5/5/1");
        double rightResult = 1;
        Assert.assertEquals(result, rightResult, 0d);
    }

    @Test
    public void testParsingExpression2() {
        double result = calcParser.calculate("2*2*2");
        double rightResult = 8;
        Assert.assertEquals(result, rightResult, 0d);
    }
}
