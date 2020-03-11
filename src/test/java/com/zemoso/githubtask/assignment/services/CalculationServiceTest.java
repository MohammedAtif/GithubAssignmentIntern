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
      //  String query = "5-3*5";
        Assert.assertEquals(-10, calculationService.calculateInt("15-25"));
        Assert.assertEquals(120, calculationService.calculateInt("22+98"));

        Assert.assertEquals(0, calculationService.calculateInt("25*25-3/0"));
        Assert.assertEquals(0, calculationService.calculateInt(" "));
        Assert.assertEquals(0, calculationService.calculateInt("1.7*5.5-2.4)/1.2" ));
        Assert.assertEquals(0, calculationService.calculateInt("1.8*2.7+(3.6*4-5+(4/2+1)" ));
        Assert.assertEquals(0, calculationService.calculateInt("1.8++2.9" ));
        Assert.assertEquals(0, calculationService.calculateInt("1.2.5-2.7" ));
        Assert.assertEquals(0, calculationService.calculateInt("1.8*2.7+(3.6*4-5+(a/2+1)" ));
    }

    @Test
    public void testResultFloat(){
      //  String query = "";
        Assert.assertEquals(-0.86f, calculationService.calculateFloat("9.0-1.7*5.8"), 3f);
        Assert.assertEquals(12.0f, calculationService.calculateDouble("2.2+9.8"), 2f);

        Assert.assertEquals(0.0f, calculationService.calculateDouble("2.5*2.5-3.0/0.0"), 0f);
        Assert.assertEquals(0.0f, calculationService.calculateDouble(" "), 0f);
        Assert.assertEquals(0.0f, calculationService.calculateDouble("1.7*5.5-2.4)/1.2" ),0f);
        Assert.assertEquals(0.0f, calculationService.calculateDouble("1.8*2.7+(3.6*4-5+(4/2+1)" ),0f);
        Assert.assertEquals(0.0f, calculationService.calculateDouble("1.8++2.9" ),0f);
        Assert.assertEquals(0.0f, calculationService.calculateDouble("1.2.5-2.7" ),0f);
        Assert.assertEquals(0.0f, calculationService.calculateDouble("1.8*2.7+(3.6*4-5+(a/2+1)" ),0f);
    }

    @Test
    public void testResultLong(){
       // String query = "";
        Assert.assertEquals(1500341, calculationService.calculateLong("2555*588-1999"));
        Assert.assertEquals(-1000, calculationService.calculateLong("1500-2500"));
        Assert.assertEquals(1200, calculationService.calculateLong("220+980"));

        Assert.assertEquals(0, calculationService.calculateLong("25000*25000-3/0"));
        Assert.assertEquals(0, calculationService.calculateLong(" "));
        Assert.assertEquals(0, calculationService.calculateLong("1997*55-24888)/1.2" ));
        Assert.assertEquals(0, calculationService.calculateLong("18888*27+(3.6*4-5+(4/2+1)" ));
        Assert.assertEquals(0, calculationService.calculateLong("17778++29777" ));
        Assert.assertEquals(0, calculationService.calculateLong("18825--29997" ));
        Assert.assertEquals(0, calculationService.calculateLong("1888*7777+(37776*4-5+(a/2+1)" ));
    }

    @Test
    public void testResultDouble(){
      //  String query = "2.2+9.8";
        Assert.assertEquals(12.0, calculationService.calculateDouble("2.2+9.8"), 0);

        Assert.assertEquals(0.0, calculationService.calculateDouble("2.5*2.5-3.0/0.0"), 0);
        Assert.assertEquals(0.0, calculationService.calculateDouble(" "), 0);
        Assert.assertEquals(0.0, calculationService.calculateDouble("1.7*5.5-2.4)/1.2" ),0);
        Assert.assertEquals(0.0, calculationService.calculateDouble("1.8*2.7+(3.6*4-5+(4/2+1)" ),0);
        Assert.assertEquals(0.0, calculationService.calculateDouble("1.8++2.9" ),0);
        Assert.assertEquals(0.0, calculationService.calculateDouble("1.2.5-2.7" ),0);
        Assert.assertEquals(0.0, calculationService.calculateDouble("1.8*2.7+(3.6*4-5+(a/2+1)" ),0);





    }

}
