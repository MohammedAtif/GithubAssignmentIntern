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
    //Test cases for int
    @Test
    public void testResultInt_1(){
        String query = "0*(1+3)-5";
        Assert.assertEquals(-5, calculationService.calculateInt(query));
    }
    @Test
    public void testResultInt_2(){
        String query = "0+2*4";
        Assert.assertEquals(8, calculationService.calculateInt(query));
    }
    @Test
    public void testResultInt_3(){
        String query = "104*(2+12)";
        Assert.assertEquals(1456, calculationService.calculateInt(query));
    }
    @Test
    public void testResultInt_4(){
        String query = "4";
        Assert.assertEquals(4, calculationService.calculateInt(query));
    }
    @Test
    public void testResultInt_5(){
        String query = "0+(1*3)-5";
        Assert.assertEquals(-2, calculationService.calculateInt(query));
    }
    //Test cases for float
    @Test
    public void testResultFloat_1(){
        String query = "(4+8)*(6-5)/((3-2)*(2+2))";
        Assert.assertEquals(3.0f, calculationService.calculateFloat(query), 0f);
    }
    @Test
    public void testResultFloat_2(){
        String query = "6*(9-5)/((3-2))";
        Assert.assertEquals(24.0f, calculationService.calculateFloat(query), 0f);
    }
    @Test
    public void testResultFloat_3(){
        String query = "6.2*(9-5)/((3.5-2))";
        Assert.assertEquals(16.533333f, calculationService.calculateFloat(query), 0f);
    }
    @Test
    public void testResultFloat_4(){
        String query = "5.5*(9-9)/((3.5-2))";
        Assert.assertEquals(0.0f, calculationService.calculateFloat(query), 0f);
    }
    @Test
    public void testResultFloat_5(){
        String query = "(9.3+11.879)*8.1+72";
        Assert.assertEquals(243.54991f, calculationService.calculateFloat(query), 0f);
    }
    //Test cases for long
    @Test
    public void testResultLong_1(){
        String query = "12345*54321";
        Assert.assertEquals(670592745, calculationService.calculateLong(query));
    }
    @Test
    public void testResultLong_2(){
        String query = "12345*(54321+2)-799999";
        Assert.assertEquals(669817436 , calculationService.calculateLong(query));
    }
    @Test
    public void testResultLong_3(){
        String query = "99999999*1";
        Assert.assertEquals(99999999 , calculationService.calculateLong(query));
    }
    @Test
    public void testResultLong_4(){
        String query = "99999999*(2-3)";
        Assert.assertEquals(-99999999 , calculationService.calculateLong(query));
    }
    @Test
    public void testResultLong_5(){
        String query = "100*5000-(7000000/70)";
        Assert.assertEquals(400000 , calculationService.calculateLong(query));
    }
    //Test cases for double
    @Test
    public void testResultDouble_1(){
        String query = "12345*(54321+2)/343-799999";
        Assert.assertEquals(1155153.8717201166, calculationService.calculateDouble(query), 0);
    }
    @Test
    public void testResultDouble_2(){
        String query = "10987654.321/(4*569)-89898.55";
        Assert.assertEquals(-85070.93386599298, calculationService.calculateDouble(query), 0);
    }
    @Test
    public void testResultDouble_3(){
        String query = "1111111111111111/1.111111111";
        Assert.assertEquals(1.0000000000999999E15, calculationService.calculateDouble(query), 0);
    }
    @Test
    public void testResultDouble_4(){
        String query = "12345.6666666666*(54321+2)/343-7999";
        Assert.assertEquals(1947259.4557823027, calculationService.calculateDouble(query), 0);
    }
    @Test
    public void testResultDouble_5(){
        String query = "981.000000000007/7.00000000981";
        Assert.assertEquals(140.14285694645795, calculationService.calculateDouble(query), 0);
    }

}

