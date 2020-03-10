package com.zemoso.githubtask.assignment.services;

import com.zemoso.githubtask.assignment.services.impl.PostfixCalculationService;

import static org.junit.Assert.fail;

import java.util.EmptyStackException;
import java.util.InputMismatchException;

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
    	
    		
            String query = "22+2*4+48/2-9";
            Assert.assertEquals(45, calculationService.calculateInt(query));
            query="(10+2)*6-(48+10)";
            Assert.assertEquals(14, calculationService.calculateInt(query));
            query="(10.2+2)*6-45/5";
            Assert.assertEquals(64, calculationService.calculateInt(query));
            query="100*(700+36)/36+3459900";
            Assert.assertEquals(3461944, calculationService.calculateInt(query));
            query="((34+36)*67)/34-(90+45)";
            Assert.assertEquals(2, calculationService.calculateInt(query));
    		
    		try
    		{
    			 query="(10+2)*6-(a+10)";
    			 Assert.assertEquals(14, calculationService.calculateInt(query));
    		}
    		catch(EmptyStackException e) {
    			System.out.println("Enter Correct input");
    		}
            
        }

        @Test
        public void testResultFloat(){ // 
            String query = "2.3*5.7-20.4/5.0+46";
            Assert.assertEquals(55.03f, calculationService.calculateFloat(query),0.0000001);
            query = "(12.5+16.8)*48.8/24.4+(105.6-50.5)";
            Assert.assertEquals(113.7f, calculationService.calculateFloat(query),0.0000001);
            query = "56*95+98/2.5-42.9";
            Assert.assertEquals(5316.3f, calculationService.calculateFloat(query),0.0000001);
            query = "24.34*(54.78-23.45)+57.789";
            Assert.assertEquals(820.3612f, calculationService.calculateFloat(query),0.0000001);
            query = "(2.3*(5.7-2.4)+      56.8/56.89)";
            Assert.assertEquals(8.588418f, calculationService.calculateFloat(query),0.0000001);
        }

        @Test
        public void testResultLong(){
            String query = "8888*919292+14233-453678/2";
            Assert.assertEquals(8170454690L, calculationService.calculateLong(query));
            query = "8888*(45634+14233)-(3458+9872/24)";
            Assert.assertEquals(532094026L, calculationService.calculateLong(query));
            query = "(4356.78888+567.89)*8907/21+7865";
            Assert.assertEquals(2096632L, calculationService.calculateLong(query));
            query = "((9885-9618)*(9553-9306))/2+43567";
            Assert.assertEquals(76541L, calculationService.calculateLong(query));
            
            try{
            	query = "4352+5467/0";
            	Assert.assertEquals(0, calculationService.calculateLong(query));
            }
            catch(ArithmeticException e) {
            	System.out.println("Divide By zero");
            }
        }

        @Test
        public void testResultDouble(){
         String query = "456.67+546.78*789.9/34.0";
             Assert.assertEquals(13159.65594117647, calculationService.calculateDouble(query),0.0000001);
             
             try{
            	 query = "(2.3+44.5)/0";
            	 Assert.assertEquals(0, calculationService.calculateDouble(query),0.0000001);
             }
             catch(ArithmeticException e) {
            	 System.out.println("Divide by zero");
             }
            
             query = "((2345.356+4546.3462)*5678.76)/34.5+(4563-7890)";
             Assert.assertEquals(1131059.167689044, calculationService.calculateDouble(query),0.0000001);
             query = "45*64+45/5+56";
             Assert.assertEquals(2945, calculationService.calculateDouble(query),0.0000001);
             query = "(4567+34576)/456*(2-2)";
             Assert.assertEquals(0, calculationService.calculateDouble(query),0.0000001);
        }
}
