package com.zemoso.githubtask.assignment.services;

import com.zemoso.githubtask.assignment.services.impl.PostfixCalculationService;

import static org.junit.Assert.fail;

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
        try{
        	Assert.assertEquals(0, calculationService.calculateInt("3/0"));
        }catch(Exception e) {
        	System.out.println("Divide by Zero Exception");
        }
        Assert.assertEquals(-2, calculationService.calculateInt("-3-3/(-3)"));
        Assert.assertEquals(-6, calculationService.calculateInt("-3-3"));
        Assert.assertEquals(0, calculationService.calculateInt("-3+3"));
        Assert.assertEquals(8, calculationService.calculateInt("-2*(-4)"));
    }

    @Test
    public void testResultFloat(){
    	try {
        	Assert.assertEquals(0f, calculationService.calculateFloat("a*2.0"),0f);
    	}
    	catch(NumberFormatException e) {
    		System.out.println("Number Not Found Exception : Please Enter only numbers!!");
    	}
    	Assert.assertEquals(6.0f, calculationService.calculateFloat("3*2.0"),0f);
    	Assert.assertEquals(9.09f, calculationService.calculateFloat("3.02+6.07"),0f);
    	Assert.assertEquals(-5.0f, calculationService.calculateFloat("-3.0-2.0"),0f);
    	Assert.assertEquals(1.5f, calculationService.calculateFloat("3/2"),0f);
    	try {
    		Assert.assertEquals(0f, calculationService.calculateFloat("3.0/0"),0f);
    	}catch(ArithmeticException e) {
    		System.out.println("Divide by Zero Exception");
    	}
    }

    @Test
    public void testResultLong(){
        Assert.assertEquals(979759800L, calculationService.calculateLong("(3004230+6793368)*100/1"));
        Assert.assertEquals(-979759800L, calculationService.calculateLong("(-3004230-6793368)*100"));
        Assert.assertEquals(1234567800L, calculationService.calculateLong("12345678*100"));
        Assert.assertEquals(12345678L, calculationService.calculateLong("1234567890/100"));
        try {
    		Assert.assertEquals(0L, calculationService.calculateFloat("12345678/0"),0L);
    	}catch(ArithmeticException e) {
    		System.out.println("Divide by Zero Exception");
    	}
    }

    @Test
    public void testResultDouble(){
        Assert.assertEquals(-2.0,calculationService.calculateDouble("-4.0+2.0"), 0);
        Assert.assertEquals(-18.0,calculationService.calculateDouble("-3.0*6.0"), 0);
        Assert.assertEquals(-6.11,calculationService.calculateDouble("-4.02+(-2.09)"), 0.01);
        Assert.assertEquals(-114.0,calculationService.calculateDouble("342.0/(-3.0)"), 0);
        try {
    		Assert.assertEquals(0, calculationService.calculateFloat("2.56/0"),0);
    	}catch(ArithmeticException e) {
    		System.out.println("Divide by Zero Exception");
    	}
    }
}
