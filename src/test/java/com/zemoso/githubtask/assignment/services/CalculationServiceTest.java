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
         Assert.assertEquals("The answer of 2 3 + has to be 5",5,calculationService.calculateInt("2 3 +"));
         Assert.assertEquals("The answer of 2 5 * has to be -14",-14,calculationService.calculateInt("2 4 4 * -"));
         Assert.assertEquals("The answer of 5 8 * has to be 40",40,calculationService.calculateInt("5 8 *"));
         Assert.assertEquals("The answer of 7 1 / has to be 7",7,calculationService.calculateInt("7 1 /"));
         Assert.assertEquals("The answer of 2 3 4 * * has to be 24",24,calculationService.calculateInt("2 3 4 * *"));
    }

    @Test
    public void testResultFloat(){
        String query = "";
        Assert.assertEquals("The answer of 20.3 39.2 + has to be 59.5", 59.5, calculationService.calculateFloat("20.3 39.2 +"),0.000001);
        Assert.assertEquals("The answer of 2.3 4.5 4.2 * - has to be -16.6",-16.6,calculationService.calculateFloat("2.3 4.5 4.2 * -"),0.000001);
        Assert.assertEquals("The answer of 5.4 8.35 - has to be 4-2.9499999999999993",-2.9499999999999993 ,calculationService.calculateFloat("5.4 8.35 -"),0.000001);
      
    }

    @Test
    public void testResultLong(){
        String query = "";
        Assert.assertEquals("The answer of 200000 30000 + has to be 230000",230000,calculationService.calculateInt("200000 30000 +"));
        Assert.assertEquals("The answer of 20000 50000 * has to be 1000000000",1000000000,calculationService.calculateInt("20000 50000 *"));
        Assert.assertEquals("The answer of 5000 80000 * has to be 400000000",400000000,calculationService.calculateInt("5000 80000 *"));
        Assert.assertEquals("The answer of 700000 10000 / has to be 70",70,calculationService.calculateInt("700000 10000 /"));
        Assert.assertEquals("The answer of 200000 20000 - has to be 180000",180000,calculationService.calculateInt("200000 20000 -"));
        
    }

    @Test
    public void testResultDouble(){
    	String query = "";
        Assert.assertEquals("The answer of 20.3 39.2 + has to be 59.5", 59.5, calculationService.calculateFloat("20.3 39.2 +"),0.000001);
        Assert.assertEquals("The answer of 2.3 4.5 4.2 * - has to be -16.679032",-16.679032,calculationService.calculateFloat("2.321 4.512 4.211 * -"),0.000001);
        Assert.assertEquals("The answer of 5.4 8.35 - has to be -2.9200999999999997",-2.9200999999999997 ,calculationService.calculateFloat("5.433 8.3531 -"),0.000001);
    }

}
