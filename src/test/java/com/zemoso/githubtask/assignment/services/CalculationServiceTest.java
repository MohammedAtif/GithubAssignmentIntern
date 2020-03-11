package com.zemoso.githubtask.assignment.services;

import com.zemoso.githubtask.assignment.services.impl.PostfixCalculationService;
import org.apache.catalina.connector.Response;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class CalculationServiceTest {
    private CalculationService calculationService;

    @Before
    public void setup() {
        calculationService = new PostfixCalculationService();
    }

    @Test
    public void testResultInt() {
        Assert.assertEquals("Testing addition", 6, calculationService.calculateInt("2+2+2"));
        Assert.assertEquals("Testing subtraction", 25, calculationService.calculateInt("24-2+3"));
        Assert.assertEquals("Testing multiplication", 8, calculationService.calculateInt("2+2*3"));
    }

    @Test(expected = NumberFormatException.class)
    public void testResultIntFormatException() {
        calculationService.calculateInt("2+2a+3");
    }

    @Test(expected = ArithmeticException.class)
    public void testResultIntArithematicException() {
        calculationService.calculateInt("2+2+2/0");
    }

    @Test
    public void testResultFloat() {
        Assert.assertEquals("Testing addition", 7.5, calculationService.calculateFloat("2.5+2.5+2.5"), 0f);
        Assert.assertEquals("Testing subtraction", 20.9, calculationService.calculateFloat("24.9-7+3"), 1f);
        Assert.assertEquals("Testing multiplication", 9.8, calculationService.calculateFloat("2+2*3.9"), 1f);
    }

    @Test(expected = NumberFormatException.class)
    public void testResultFloatFortmatException() {
        calculationService.calculateInt("2.0o+2a+3.8");
        calculationService.calculateInt("2.0+2a+3.8''");
        calculationService.calculateInt("2.0+2a+3.8.,");
    }

    @Test(expected = ArithmeticException.class)
    public void testResultFloatArithematicException() {
        calculationService.calculateFloat("2.0+2.8/0");
    }

    @Test
    public void testResultDouble() {
        Assert.assertEquals("Testing addition", 7.746700000000001, calculationService.calculateDouble("2.5767+2.59+2.58"), 0f);
        Assert.assertEquals("Testing subtraction", 5677.98, calculationService.calculateDouble("2498.98-798+3977"), 0f);
        Assert.assertEquals("Testing multiplication", 3843.3999999999996, calculationService.calculateDouble("2767+276*3.9"), 0f);
    }

    @Test(expected = NumberFormatException.class)
    public void testResultDoubleFormatException() {
        calculationService.calculateInt("2.878780o+2a+3.8");
        calculationService.calculateInt("2.067+2a+3.8''");
        calculationService.calculateInt("2.0+2a+3.887678.,");
    }

    @Test(expected = ArithmeticException.class)
    public void testResultDoubleArithematicException() {
        calculationService.calculateFloat("28787.0989+2.8767/0");
    }

    @Test
    public void testResultLong() {
        Assert.assertEquals("Testing addition", 3.8681464904E10, calculationService.calculateDouble("38678676767+2787879+258"), 0);
        Assert.assertEquals("Testing subtraction", 2.49879977E8, calculationService.calculateDouble("249876798-798+3977"), 0);
        Assert.assertEquals("Testing multiplication", 13531, calculationService.calculateDouble("2767+276*39"), 0);
    }

    @Test(expected = NumberFormatException.class)
    public void testResultLongFormatException() {
        calculationService.calculateInt("2878780o+2a+38");
        calculationService.calculateInt("2067+2a+38''");
        calculationService.calculateInt("20+2a+3887678.,");
    }

    @Test(expected = ArithmeticException.class)
    public void testResultLongArithematicException() {
        calculationService.calculateFloat("287870989+28767/0");
    }
}
