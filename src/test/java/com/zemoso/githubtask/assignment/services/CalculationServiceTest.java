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
        Assert.assertEquals(-1, calculationService.calculateInt(query));

        query="2+*3";
        Assert.assertEquals(-1, calculationService.calculateInt(query));
        query="2+(3*5)(";
        Assert.assertEquals(-1, calculationService.calculateInt(query));

        query="2*3/0";
        Assert.assertEquals(-1, calculationService.calculateInt(query));
        query="2*a";
        Assert.assertEquals(-1, calculationService.calculateInt(query));
        query="2";
        Assert.assertEquals(2, calculationService.calculateInt(query));
        query="2.3*3.6";
        Assert.assertEquals(8, calculationService.calculateInt(query));
        query="2.6547+3*0";
        Assert.assertEquals(2, calculationService.calculateInt(query));
    }

    @Test
    public void testResultFloat(){
        String query = "";
        Assert.assertEquals(-1f, calculationService.calculateFloat(query), 0f);
        query="2+*3";
        Assert.assertEquals(-1f, calculationService.calculateFloat(query), 0f);
        query="2+(3*5)(";
        Assert.assertEquals(-1f, calculationService.calculateFloat(query), 0f);
        query="2.3*3.6";
        Assert.assertEquals(8.28f, calculationService.calculateFloat(query), 0f);
        query="2*3/0";
        Assert.assertEquals(-1f, calculationService.calculateFloat(query), 0f);
        query="2*a";
        Assert.assertEquals(-1f, calculationService.calculateFloat(query), 0f);
        query="2";
        Assert.assertEquals(2f, calculationService.calculateFloat(query), 0f);
        query="2.224+3*0";
        Assert.assertEquals(2.224f, calculationService.calculateFloat(query), 0f);


    }

    @Test
    public void testResultLong(){
        String query = "";
        Assert.assertEquals(-1, calculationService.calculateLong(query));
        query="2+*3";
        Assert.assertEquals(-1, calculationService.calculateLong(query));
        query="2+(3*5)(";
        Assert.assertEquals(-1, calculationService.calculateLong(query));

        query="2*3/0";
        Assert.assertEquals(-1, calculationService.calculateLong(query));
        query="2*a";
        Assert.assertEquals(-1, calculationService.calculateLong(query));
        query="2";
        Assert.assertEquals(2, calculationService.calculateLong(query));
        query="2.3*3.6";
        Assert.assertEquals(8, calculationService.calculateLong(query));
        query="2.6547+3*0";
        Assert.assertEquals(2, calculationService.calculateLong(query));
    }

    @Test
    public void testResultDouble(){
        String query = "";
        Assert.assertEquals(-1, calculationService.calculateDouble(query), 0);
        query="2+*3";
        Assert.assertEquals(-1, calculationService.calculateDouble(query), 0);
        query="2+(3*5)(";
        Assert.assertEquals(-1, calculationService.calculateDouble(query), 0);
        query="2.3*3.6";
        Assert.assertEquals(8.28, calculationService.calculateDouble(query), 0);
        query="2*3/0";
        Assert.assertEquals(-1, calculationService.calculateDouble(query), 0);
        query="2*a";
        Assert.assertEquals(-1, calculationService.calculateDouble(query), 0);
        query="2";
        Assert.assertEquals(2, calculationService.calculateDouble(query), 0);
        query="2.224+3*0";
        Assert.assertEquals(2.224, calculationService.calculateDouble(query), 0);

        query="2.2.2";
        Assert.assertEquals(-1, calculationService.calculateDouble(query), 0);

    }

}

