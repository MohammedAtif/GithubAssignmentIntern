package com.zemoso.githubtask.assignment.services;

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
    public void testResultInt(){

        String query = "";//expression can't be null
        Assert.assertEquals(0, calculationService.calculateInt(query));

        query = "8888";
        Assert.assertEquals(8888, calculationService.calculateInt(query));

        query="1*2+(3*4+(30/5-5+(4/2)*12-1)+1)-20";
        Assert.assertEquals(19,calculationService.calculateInt(query));

        query="2-(2)";
        Assert.assertEquals(0,calculationService.calculateInt(query));

        query="2(4--3)";//missing operator
        Assert.assertEquals(0,calculationService.calculateInt(query));

        query="1**2";//invalid sign
        Assert.assertEquals(0,calculationService.calculateInt(query));

        query="1*2*";//invalid expression
        Assert.assertEquals(0,calculationService.calculateInt(query));

        query="*1*2";//invalid expression
        Assert.assertEquals(0,calculationService.calculateInt(query));

    }

    @Test
    public void testResultFloat(){

        String query = "";//expression can't be null
        Assert.assertEquals(0f, calculationService.calculateFloat(query), 0f);

        query="(90.99--9.01)*10/0";//number can't be divided by 0
        Assert.assertEquals(0f, calculationService.calculateFloat(query), 0f);

        query="{[({9+0.9}-0.9)*-100.01]-2}";
        Assert.assertEquals(-902.09f, calculationService.calculateFloat(query), 0f);

        query="{[({9+0.9}-0.9)*-100.01]-2f}";//alphabets are not allowed
        Assert.assertEquals(0f, calculationService.calculateFloat(query), 0f);

    }

    @Test
    public void testResultLong(){

        String query = "";//expression can't be null
        Assert.assertEquals(0L, calculationService.calculateLong(query));

        query = "+";//invalid expression
        Assert.assertEquals(0L, calculationService.calculateLong(query));

        query = "(+)";//invalid expression
        Assert.assertEquals(0L, calculationService.calculateLong(query));

        query = "32434+23232-343432*2323";
        Assert.assertEquals(-797736870L, calculationService.calculateLong(query));

        query = "32434+23232-(343432*2323)t";//alphabets are not allowed in an expression
        Assert.assertEquals(0L, calculationService.calculateLong(query));
    }

    @Test
    public void testResultDouble(){

        String query = "";//expression can't be null
        Assert.assertEquals(0, calculationService.calculateDouble(query), 0);

        query = "(1223.231)";
        Assert.assertEquals(1223.231, calculationService.calculateDouble(query), 0);

        query = "32434.129+23232.12309-343432.2382/(343432.2382*2)";
        Assert.assertEquals(55665.75209, calculationService.calculateDouble(query),0.0);

        query = "(-34.9034)+23.232";
        Assert.assertEquals(-11.6714, calculationService.calculateDouble(query),0.00001);

        query="{[({9+0.9}-0.9)*-100)-2}";//brackets are not closed properly
        Assert.assertEquals(0.0, calculationService.calculateDouble(query),0.00001);

        query="1.2null+1";//alphabets are not allowed in an expression
        Assert.assertEquals(0.0, calculationService.calculateDouble(query),0.00001);

    }
}
