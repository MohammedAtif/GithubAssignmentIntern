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
        Assert.assertEquals(6, calculationService.calculateInt("2*3"));
        Assert.assertEquals(-3, calculationService.calculateInt("1*(2+3)-8"));
        Assert.assertEquals(25, calculationService.calculateInt("1+3*8"));
    }

    @Test
    public void testResultFloat(){
        Assert.assertEquals(7.0, calculationService.calculateFloat("2+2.5*2"), 0f);
        Assert.assertEquals(7.5, calculationService.calculateFloat("3*2.5"), 0f);
        Assert.assertEquals(20.5, calculationService.calculateFloat("6+4+10.5"), 0f);
    }

    @Test
    public void testResultLong(){
			Assert.assertEquals(Long.parseLong("200000000000"), calculationService.calculateLong("1000000*2000000/10"));
			Assert.assertEquals(Long.parseLong("987654330086"), calculationService.calculateLong("987654321077+9009"));
 
    }

    @Test
    public void testResultDouble(){
    Assert.assertEquals(5.2, calculationService.calculateDouble("(5.38-4.34)*5"), 0);
    Assert.assertEquals( 581216724.4865831, calculationService.calculateDouble("581216732.323433-7.83684987683688"), 0);
       
    }

	}
