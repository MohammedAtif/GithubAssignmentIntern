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
        Assert.assertEquals(851969800,calculationService.calculateInt("112556 536782 53434 5884 * * 52724 - +"));
        Assert.assertEquals(4787854, calculationService.calculateInt("1125533 24647748 57885 / * 4787854 +"));
        Assert.assertEquals(27085, calculationService.calculateInt("24536 45758 23556 436754 * / 34564 - +"));
    }

    @Test
    public void testResultFloat(){
        Assert.assertEquals(159134.2f, calculationService.calculateFloat("4566.78 35678.9876 567 2456.34 / * +"), 0f);
        Assert.assertEquals(123070320, calculationService.calculateFloat("4573.7436 4543.673 5638.8937 456.45 / * 3468.98256 35477.245 * +"), 0f);
        Assert.assertEquals(134665.11f, calculationService.calculateFloat("234.5634 456 * 3457.35643 456.267 3656.12 / * +"), 0f);
    }

    @Test
    public void testResultLong(){
        Assert.assertEquals(21055672188L, calculationService.calculateLong("234567 89764 *"));
        Assert.assertEquals(24749397561L, calculationService.calculateLong("5678 4358823 * 567 +"));
        Assert.assertEquals(54326712L, calculationService.calculateLong("567354 123654 1233 / * 54326712 +"));
    }

    @Test
    public void testResultDouble(){
        Assert.assertEquals(15.328000000000001, calculationService.calculateDouble("3.2 4.79 *"), 0);
       Assert.assertEquals(17.089545657257975,calculationService.calculateDouble("4.77 3.567 * 456.67 34.23 / +"), 0);
        Assert.assertEquals(-4717.643869498577, calculationService.calculateDouble("345.24 45.67 123 / * 5647.456 -"), 0);
    }

}

