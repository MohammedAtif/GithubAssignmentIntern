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
        String query = "";
        Assert.assertEquals("The answer of 2+2 has to be 4",4,calculationService.calculateInt("2+2.5"));
        Assert.assertEquals("The answer of 2*3-6 has to be 0",0,calculationService.calculateInt("2*3-6.3"));
        Assert.assertEquals("The answer of 2+2-2*2 has to be 0",0,calculationService.calculateInt("2+2-2*2"));
        Assert.assertEquals("The answer of 7/2-3+5 has to be 5",5,calculationService.calculateInt("7/2-3+5"));
        Assert.assertEquals("The answer of 2*2 has to be 4",4,calculationService.calculateInt("2*2"));
        Assert.assertEquals("wrong answer",42,calculationService.calculateInt("2+4*8/8-2"));
    }

    @Test
    public void testResultFloat(){
        String query = "";
        Assert.assertEquals("The answer of 3.5+7*4-2 has to be 29.5", 29.5, calculationService.calculateFloat("3.5+7*4-2"),0.001);
        Assert.assertEquals("The answer of 2.3+7/3-1.4 has to be 3.23",3.23,calculationService.calculateFloat("2.3+7/3-1.4"),0.001);
        Assert.assertEquals("The answer of 2+2/5.3*1.8 has to be 2.68",2.67,calculationService.calculateFloat("2+2/5.3*1.8"),0.001);
        Assert.assertEquals("The answer of 2*3/3.0-2 has to be 0.00",0.00,calculationService.calculateFloat("2*3/3.0-2"),0.001);
        Assert.assertEquals("The answer of 8.4+2.3/1.3*7.8 has to be 22.19",22.19,calculationService.calculateFloat("8.4+2.3/1.3*7.8"),0.001);
    }

    @Test
    public void testResultLong(){
        String query = "";
        Assert.assertEquals("The answer of 745+540*889-568/8 has to be 480734",480734, calculationService.calculateLong("745+540*889-568/8"));
        Assert.assertEquals("The answer of 2342*3454-698 has to be 8088570",8088570, calculationService.calculateLong("2342*3454-698"));
        Assert.assertEquals("The answer of 222+222*222/222 has to be 444",0, calculationService.calculateLong("222+222*222/222"));
        Assert.assertEquals("The answer of 222-222*222/222 has to be 0",0, calculationService.calculateLong("222-222*222/222"));
        Assert.assertEquals("The answer of 1/1000*500+500 has to be 500",500, calculationService.calculateLong("1/1000*500+500"));
    }

    @Test
    public void testResultDouble(){
        String query = "";
        Assert.assertEquals("The answer of 3.5+7*4-2 has to be 29.5", 29.5, calculationService.calculateDouble("3.5+7*4-2"),0.001);
        Assert.assertEquals("The answer of 2.3+7/3-1.4 has to be 3.23",3.23,calculationService.calculateDouble("2.3+7/3-1.4"),0.001);
        Assert.assertEquals("The answer of 2+2/5.3*1.8 has to be 2.68",2.68,calculationService.calculateDouble("2+2/5.3*1.8"),0.001);
        Assert.assertEquals("The answer of 2*3/3.0-2 has to be 0.00",0.00,calculationService.calculateDouble("2*3/3.0-2"),0.001);
        Assert.assertEquals("The answer of 8.4+2.3/1.3*7.8 has to be 22.19",22.19,calculationService.calculateDouble("8.4+2.3/1.3*7.8"),0.001);
    }

}

