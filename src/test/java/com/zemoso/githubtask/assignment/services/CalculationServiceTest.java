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
    	 //Simple expression
        Assert.assertEquals(18, calculationService.calculateInt("5*3+7/2-3/6"));
        //Expression with brackets
        Assert.assertEquals(21, calculationService.calculateInt("(4+3)*3+(7-3)/4*(2/3)"));
        //Expression with floating point numbers
        Assert.assertEquals(6, calculationService.calculateInt("6.2+3.7*6.8/2/(4.4*7.1)"));
        //Expression with negative value
        Assert.assertEquals(-10, calculationService.calculateInt("-4*6/3+4*-5/7"));
        //Expression with spaces
        Assert.assertEquals(12, calculationService.calculateInt("     -4                 *-3"));
        //Expression to test exceptions
        try {
            Assert.assertEquals(-16, calculationService.calculateInt("3a*l/k"));
            Assert.fail("failed to catch exception");
        }catch(Exception e) {
        	System.out.println("Invalid expression");

        }
    }
        
    

    @Test
    public void testResultFloat(){
    	  //Simple expression
        Assert.assertEquals(3.5f, calculationService.calculateFloat("2+3*4/8"),0.01f);
        //Expression with brackets
        Assert.assertEquals(15.0f, calculationService.calculateFloat("3+(4-2)*6"),0.01f);
        //Expression with floating point numbers
        Assert.assertEquals(26.66f, calculationService.calculateFloat("2.4*(4.6+9.3*(2.3-1.6))"),0.01f);
        //Expression with negative value
        Assert.assertEquals(11.81f, calculationService.calculateFloat("-3*4.2/2*(-6/3.2)"),0.01f);
        //Expression with spaces
        Assert.assertEquals(-4.0f, calculationService.calculateFloat("2        +3         *-2"),0.01f);
        //Expression to test exceptions
        try {
            Assert.assertEquals(0, calculationService.calculateFloat("3a*l/k"),0.001);
            Assert.fail("failed to catch exception");
        }catch(Exception e) {
        	System.out.println("Invalid expression");

        }
    }

    @Test
    public void testResultLong(){
    	  //Simple expression
        Assert.assertEquals(4458517702L, calculationService.calculateLong("346578*64322/5-321"));
        //Expression with brackets
        Assert.assertEquals(40742L, calculationService.calculateLong("(25*566)/34*98-43"));
        //Expression with floating point numbers
        Assert.assertEquals(-16109L, calculationService.calculateLong("422.3-23.65*655.7-1024.6"));
        //Expression with negative value
        Assert.assertEquals(-23343444L, calculationService.calculateLong("-3444*6778-563/44"));
        //Expression with spaces
        Assert.assertEquals(-4, calculationService.calculateLong("2                 *-2"));
        //Expression to test exceptions
        try {
            Assert.assertEquals(0, calculationService.calculateLong("3a*l/k"));
            Assert.fail("failed to catch exception");
        }catch(Exception e) {
        	System.out.println("Invalid expression");

        }
    }

    @Test
    public void testResultDouble(){
        
        //Simple expression
        Assert.assertEquals(0, calculationService.calculateDouble("2+2*4/2-3*8/4"),0.001);
        //Expression with brackets
        Assert.assertEquals(23.0, calculationService.calculateDouble("(3*2+2)*4-(3*6/2)"),0.001);
        //Expression with floating point numbers
        Assert.assertEquals(11.1, calculationService.calculateDouble("3.6+2.2*4-2*1.3/2"),0.001);
        //Expression with negative value
        Assert.assertEquals(-17.3, calculationService.calculateDouble("-3*-2+4/2-4.6*5.5"),0.001);
        //Expression with spaces
        Assert.assertEquals(-4, calculationService.calculateDouble("2                 *-2"),0.001);
        //Expression to test exceptions
        try {
            Assert.assertEquals(0, calculationService.calculateDouble("3a*l/k"),0.001);
            Assert.fail("failed to catch exception");
        }catch(Exception e) {
        	System.out.println("Invalid expression");
        }
    }

}
