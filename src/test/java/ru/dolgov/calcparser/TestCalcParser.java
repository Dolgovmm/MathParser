package ru.dolgov.calcparser;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.dolgov.calcparser.parser.CalcParser;

public class TestCalcParser {
    CalcParser calcParser;

    @Before
    public void createCalcParser() {
        calcParser = new CalcParser();
    }

    @Test
    public void testParsingExpression() {
        double result = calcParser.parse("5/5/1");
        double rightResult = 1;
        Assert.assertEquals(result, rightResult, 0d);
    }
}
