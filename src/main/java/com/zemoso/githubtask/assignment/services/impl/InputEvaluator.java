package com.zemoso.githubtask.assignment.services.impl;

import java.util.Stack;

public class InputEvaluator {

	 public double calculateExpression(String expression) 
	    { 
	        Stack<Double> operands = new Stack<Double>();  
	        Stack<Character> operators = new Stack<Character>(); 
	  
	        for (int i = 0;i < expression.length();i++) 
	        { 
	       
	        	if (expression.charAt(i) == ' ') 
	                continue; 
	            if (expression.charAt(i) >= '0' && expression.charAt(i)<= '9') 
	            { 
	                String currentNumber=""; 
	                
	                while ((i < expression.length() && expression.charAt(i) >= '0' && expression.charAt(i) <= '9') || (i < expression.length() && expression.charAt(i) == '.' ))
	                {
	                    currentNumber+=expression.charAt(i++); 

	                }
	                operands.push(Double.parseDouble(currentNumber)); 
	                i--;
	               
	            }        
	            else if (expression.charAt(i) == '(') {
	                operators.push(expression.charAt(i)); 
	           
	            }
	            else if (expression.charAt(i) == ')') 
	            { 
	                while (operators.peek() != '(') 
	                {
	                  operands.push(performOperation(operators.pop(), operands.pop(), operands.pop()));
	                }   
	                operators.pop(); 
	            } 
	  
	          
	            else if (expression.charAt(i) == '+' || expression.charAt(i)== '-' || 
	            		expression.charAt(i) == '*' ||expression.charAt(i) == '/'|| expression.charAt(i) == '^') 
	            { 
	               
	                while (!operators.empty() && precedence(operators.peek())>=precedence(expression.charAt(i))) 
	                  operands.push(performOperation(operators.pop(), operands.pop(), operands.pop())); 
	  
	               
	                operators.push(expression.charAt(i)); 
	            } 
	        }
	        while (!operators.empty()) 
	            operands.push(performOperation(operators.pop(), operands.pop(), operands.pop()));
	        return operands.pop(); 
	    } 
	    public int precedence(char op1) 
	    { 
	    	if(op1 == '+' || op1 == '-') 
	    		return 1;
	    	else if ((op1 == '*' || op1 == '/'))  	
	            return 2; 
	    	return 0;
	     
	    }  
	    public  double performOperation(char op, double b, double a) 
	    { 
	    
	    
	        switch (op) 
	        { 
	        case '+': 
	            return a + b; 
	        case '-': 
	            return a - b; 
	        case '*': 
	            return a * b; 
	        case '/': 
	        	if(b==0) {
	        		throw new ArithmeticException();
	        	}
	            return a / b;  
	        } 
	    	
	        return 0; 
	    } 
	 
}
