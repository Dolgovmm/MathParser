package ru.dolgov.calcparser.mathparser;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.dolgov.calcparser.mathParser.MathParser;

public class TestMathParser {
    MathParser mathParser;

    @Before
    public void createCalcParser() {
        mathParser = new MathParser();
    }

    @Test
    public void testParsingExpression1() throws Exception {
        double result = mathParser.parse("5/5");
        double rightResult = 1;
        Assert.assertEquals(result, rightResult, 0d);
    }

    @Test
    public void testParsingExpression2() throws Exception {
        double result = mathParser.parse("2+2*2");
        double rightResult = 6;
        Assert.assertEquals(result, rightResult, 0d);
    }

    @Test
    public void testParsingExpression3() throws Exception {
        double result = mathParser.parse("20/2*200");
        double rightResult = 2000;
        Assert.assertEquals(result, rightResult, 0d);
    }

    @Test
    public void testParsingExpression4() throws Exception {
        double result = mathParser.parse("18*3+97-64/7-8.0");
        double rightResult = 133.85;
        Assert.assertEquals(result, rightResult, 0.02d);
    }

    @Test(expected = Exception.class)
    public void testParsingExpression5() throws Exception {
        double result = mathParser.parse("18*3+97-+64/7-8.0");
        double rightResult = 133.85;
        Assert.assertEquals(result, rightResult, 0.02d);
    }

    @Test(expected = Exception.class)
    public void testParsingExpression6() throws Exception {
        double result = mathParser.parse("18*3+97-64/7-8..0");
        double rightResult = 133.85;
        Assert.assertEquals(result, rightResult, 0.02d);
    }
}
