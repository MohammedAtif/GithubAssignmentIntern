package com.zemoso.githubtask.assignment.services;



import com.zemoso.githubtask.assignment.services.impl.PostfixCalculationService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
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
        

        Assert.assertEquals(-7, calculationService.calculateInt("-23+16-10/5-(-3+1)"));
        Assert.assertEquals(14, calculationService.calculateInt("2 +3*  4"));
        Assert.assertEquals(67, calculationService.calculateInt("12/3-(3+4)*(-6-3)"));

        Assert.assertEquals(4, calculationService.calculateInt("23*(1-1)+4"));

        Assert.assertEquals(6, calculationService.calculateInt("2-(-3)+1"));
        
        try
        {
        Assert.assertEquals(0, calculationService.calculateInt("2+*3"));
        }
        catch(Exception e)
        {
        	System.out.println(e.getMessage());
        }
        try
        {
        Assert.assertEquals(0, calculationService.calculateInt("2+(3"));
        }
        catch(Exception e)
        {
        	System.out.println(e.getMessage());
        }
        try
        {
        Assert.assertEquals(0, calculationService.calculateInt("2/0"));
        }
        catch(Exception e)
        {
        	System.out.println(e.getMessage());
        }
        
        
    }

   
    
    
    @Test
    public void testResultFloat(){
        
        
        Assert.assertEquals(37.35, calculationService.calculateFloat("4.5*(2.3+6.0)"), 2);
        Assert.assertEquals(-0.823456, calculationService.calculateFloat("-4.123456789+3.3"), 6);
        Assert.assertEquals(13.2, calculationService.calculateFloat("5*2.5+(3-2.3)"), 1);
        try
        {
        	Assert.assertEquals(0f, calculationService.calculateFloat("11.2.3+2"), 0f);
        }
        catch(Exception e)
        {
        	System.out.println(e.getMessage());
        }
    }
    
    
    @Test
    public void testResultLong(){
        
        Assert.assertEquals(21244666577756L, calculationService.calculateLong("21232342343432+12324234324"));
        Assert.assertEquals(-3747747733474L, calculationService.calculateLong("-312312311123*12+(-1+3)"));
        
        try {
        	Assert.assertEquals(21244666577756L, calculationService.calculateLong("21+(122324321-1"));
        }
        catch(Exception e)
        {
        	System.out.println(e.getMessage());
        }
    }
    
   
    @Test
    public void testResultDouble(){
        
        Assert.assertEquals(9.12323232432, calculationService.calculateDouble("3.12323232432+3*2"), 0);
        try
        {
        	Assert.assertEquals(9.12323232432, calculationService.calculateDouble("3.12323.232432+3*2"), 0);
        }
        catch(Exception e)
        {
        	System.out.println(e.getMessage());
        }
        try
        {
        	Assert.assertEquals(9.12323232432, calculationService.calculateDouble("3.12(+3*2"), 0);
        }
        catch(Exception e)
        {
        	System.out.println(e.getMessage());
        }
    }
    
}

