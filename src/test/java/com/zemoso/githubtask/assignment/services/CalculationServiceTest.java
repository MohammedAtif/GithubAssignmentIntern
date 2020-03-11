package com.zemoso.githubtask.assignment.services;

import com.zemoso.githubtask.assignment.exceptions.InvalidPostfixException;
import com.zemoso.githubtask.assignment.services.impl.PostfixCalculationService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class CalculationServiceTest {

    private CalculationService calculationService;

    @Before
    public void setup(){
        calculationService = new PostfixCalculationService();
    }

    @Test
    public void testResultInt() throws InvalidPostfixException {
        Assert.assertEquals(6, calculationService.calculateInt("3+3"));
        Assert.assertEquals(25, calculationService.calculateInt("1+3*8"));
        Assert.assertEquals(65534, calculationService.calculateInt("32767+32767"));
        Assert.assertEquals(-4, calculationService.calculateInt("2+3*1-9"));
        Assert.assertEquals(757, calculationService.calculateInt("(100+200)/2*5+7"));
    }

    @Test(expected = InvalidPostfixException.class)
    public void testResultInt2() throws InvalidPostfixException{
        calculationService.calculateInt("3 3");
    }

    @Test(expected = InvalidPostfixException.class)
    public void testResultInt3() throws InvalidPostfixException{
        calculationService.calculateInt("3+abc");
    }

    @Test
    public void testResultFloat() throws InvalidPostfixException {

        Assert.assertEquals(6.0f, calculationService.calculateFloat("3.0+3.0"),0f);
        Assert.assertEquals(25.0f, calculationService.calculateFloat("1.0+3.0*8.0"),0f);
        Assert.assertEquals(65534.0f, calculationService.calculateFloat("32767.0+32767.0"),0f);
        Assert.assertEquals(-4.0f, calculationService.calculateFloat("2.0+3.0*1.0-9.0"),0f);
        Assert.assertEquals(757.0f, calculationService.calculateFloat("(100.0+200.0)/2.0*5.0+7.0"),0f);
    }

    @Test(expected = InvalidPostfixException.class)
    public void testResultFloat2() throws InvalidPostfixException{
        calculationService.calculateFloat("3.0 3.0");
    }

    @Test(expected = InvalidPostfixException.class)
    public void testResultFloat3() throws InvalidPostfixException{
        calculationService.calculateFloat("3.0+abc");
    }

    @Test
    public void testResultLong() throws InvalidPostfixException {
        Assert.assertEquals(93275084941L, calculationService.calculateLong("48202815761+45072269180"));
        Assert.assertEquals(7371091810470792848L, calculationService.calculateLong("97901348632*75291014"));
        Assert.assertEquals(64260674092L, calculationService.calculateLong("85075510742+40657992837-61472829487"));
        Assert.assertEquals(30462898813L, calculationService.calculateLong("55553569923-25090671110"));
        Assert.assertEquals(4294967296L, calculationService.calculateLong("2147483648+2147483648"));
    }

    @Test(expected = InvalidPostfixException.class)
    public void testResultLong2() throws InvalidPostfixException{
        calculationService.calculateLong("3L 3L");
    }

    @Test(expected = InvalidPostfixException.class)
    public void testResultLong3() throws InvalidPostfixException{
        calculationService.calculateLong("3L+abc");
    }

    @Test
    public void testResultDouble() throws InvalidPostfixException {
        String query = "";
        Assert.assertEquals(93275084941.0, calculationService.calculateDouble("48202815761.0+45072269180.0"),0);
        Assert.assertEquals(7371091810470792848.0, calculationService.calculateDouble("97901348632.0*75291014.0"),0);
        Assert.assertEquals(64260674092.0, calculationService.calculateDouble("85075510742.0+40657992837.0-61472829487.0"),0);
        Assert.assertEquals(30462898813.0, calculationService.calculateDouble("55553569923.0-25090671110.0"),0);
        Assert.assertEquals(4294967296.0, calculationService.calculateDouble("2147483648.0+2147483648.0"),0);
    }

    @Test(expected = InvalidPostfixException.class)
    public void testResultDouble2() throws InvalidPostfixException{
        calculationService.calculateDouble("3.0 3.0");
    }

    @Test(expected = InvalidPostfixException.class)
    public void testResultDouble3() throws InvalidPostfixException{
        calculationService.calculateDouble("3.0+abc");
    }

}
