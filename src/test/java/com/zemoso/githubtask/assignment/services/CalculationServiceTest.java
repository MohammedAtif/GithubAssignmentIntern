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
    public void setup()
    {
        calculationService = new PostfixCalculationService();
    }

    @Test
    public void testResultInt()
    {
        
    	  String query = "2*35*40";
         // Assert.assertEquals(2800, calculationService.calculateInt(query));
          
          query = "12+35+42";
          Assert.assertEquals(89, calculationService.calculateInt(query));
          
         query ="12+3523-424";
          Assert.assertEquals(3111, calculationService.calculateInt(query));
          
       
         //operator precendence
          query = "100+50*25-5+45/5";
          Assert.assertEquals(1354, calculationService.calculateInt(query));
          
         
          
          //inner parenthesis
         query = "(25+(3*(45/5)*4)+5)";
       Assert.assertEquals(138, calculationService.calculateInt(query));
       
       query = "(1+(32*(25+(3*(45/5)*4)+5))+45*7)";
       Assert.assertEquals("inner parenthesis checking",4732, calculationService.calculateInt(query));
       
       
       
       
       
       //invalid expressions 
       
          String inValid[]= { "(2*35)+4)","((2*3)+4", "34*abc+5", "12/0","()","awerq"};
          
          for(int i=0;i<inValid.length;i++)
        	  
          { 
          	query=inValid[i];
          	try
          	{
          	 Assert.assertEquals("checking invalid cases" ,calculationService.calculateInt(query));
          	}
          	catch(Exception e)
          	{
          		System.out.println("invalid expresssion");
          	}
          }
    	
    
    }

   @Test
    public void testResultFloat()
    {
      String query = "12.4*2.1";
    
      
      
      
      //invalid expressions 
      
         String inValid[]= { "(2.45f*35.56)+4.2)","((2.2*3.45)+4.4", "34.3*abc+5", "12.23/0","()","awerq"};
         
         for(int i=0;i<inValid.length;i++)
       	  
         { 
         	query=inValid[i];
         	try
         	{
         	 Assert.assertEquals("checking invalid cases" ,calculationService.calculateInt(query));
         	}
         	catch(Exception e)
         	{
         		System.out.println("invalid expresssion");
         	}
         }
   	
   
        
    }

    @Test
    public void testResultLong()
    {
        String query = "123456*1234567";
  String inValid[]= { "(2*3.5)+4)","((2*3)+4", "3.4*abc+5", "12/0","()","awerq",""};
        
        for(int i=0;i<inValid.length;i++)
        { 
        	query=inValid[i];
        	try
        	{
        	 Assert.assertEquals("checking invalid cases" ,calculationService.calculateLong(query));
        	}
        	catch(Exception e)
        	{
        		System.out.println("invalid expresssion");
        	}
        }
        
        
    }

    @Test
    public void testResultDouble(){
    	
    	//simple expression
    	
       String query = "2*35.23*423.30";
       
        Assert.assertEquals(29825.717999999997, calculationService.calculateDouble(query), 0);
        
        query = "12+35.23+42.4";
        Assert.assertEquals(89.63, calculationService.calculateDouble(query), 0);
        
       query ="12+35.23-42.4";
        Assert.assertEquals(4.829999999999998, calculationService.calculateDouble(query), 0);
        
     
       //operator precendence
        query = "100.50*25.5+45.5";
        Assert.assertEquals(2608.25, calculationService.calculateDouble(query), 0);
        
        query = "100.50+25.5*45.5/55.56";
        Assert.assertEquals(121.38282937365011, calculationService.calculateDouble(query), 0);
        
        //inner parenthesis
       query = "(2.5+(3*(4.5/5)*4)+5)";
     Assert.assertEquals(18.3, calculationService.calculateDouble(query), 0);
     
     query = "(1+(32*(2.5+(3*(4.5/5)*4)+5))+4.5*7)";
     Assert.assertEquals(618.1, calculationService.calculateDouble(query), 0);
     
     
     
     
     
     //invalid expressions 
     
        String inValid[]= { "(2*3.5)+4)","((2*3)+4", "3.4*abc+5", "12/0","()","awerq",""};
        
        for(int i=0;i<inValid.length;i++)
        { 
        	query=inValid[i];
        	try
        	{
        	 Assert.assertEquals("checking invalid cases" ,calculationService.calculateDouble(query));
        	}
        	catch(Exception e)
        	{
        		System.out.println("invalid expresssion");
        	}
        }
        
        
    
    
    }

}

