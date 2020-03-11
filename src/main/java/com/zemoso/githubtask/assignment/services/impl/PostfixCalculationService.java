package com.zemoso.githubtask.assignment.services.impl;

import com.zemoso.githubtask.assignment.services.CalculationService;

import java.util.Stack;

import org.springframework.stereotype.Service;

@Service
public class PostfixCalculationService implements CalculationService {

    @Override
    public int calculateInt(String input) {
        return evaluatePostfixInt(infixToPostfix(input));
    }

    @Override
    public float calculateFloat(String input) {
        return evaluatePostfixFloat(infixToPostfix(input));
    }

    @Override
    public long calculateLong(String input) {
        return evaluatePostfixLong(infixToPostfix(input));
    }

    @Override
    public double calculateDouble(String input) {
        return evaluatePostfixDouble(infixToPostfix(input));
    }
    
    public static int Precedence(char ch) 
    { 
        switch (ch) { 
			case '+': return 1;
			case '-': return 1; 
			case '*': return 2;
			case '/': return 2; 
			case '^': return 3; 
        } 
        return -1; 
    } 
    //changing infix expression to postfix expression
    public static String infixToPostfix(String exp) 
    { 
        String result = new String(""); 
        Stack<Character> operators = new Stack<>(); 
          
        for (int i = 0; i < exp.length(); i++) 
        { 
            char c = exp.charAt(i); 
            if (Character.isDigit(c) || c == '.') // expression can have int values as well as float values
                result += c;  
            else if (c == '(') 
            	operators.push(c); 
            else if (c == ')') 
            { 
                while (!operators.isEmpty() && operators.peek() != '(') //popping all operators until we get an open brace
                    result += " " + operators.pop(); 
                operators.pop();
            } 
            else 
            { 
            	result += " ";
                while (!operators.isEmpty() && Precedence(c) <= Precedence(operators.peek())){ // checking for the precedence of operators
                    result += operators.pop() + " "; 
             } 
                operators.push(c); 
            } 
       
        } 
        while (!operators.isEmpty()){ 
            result += " " + operators.pop(); // adding all the remaining operators to the result
         } 
        return result; 
    } 
    //evaluating postfix expression which is of float type
    public static float evaluatePostfixFloat(String exp) 
    { 
        //making a stack of values
        Stack<Float> values = new Stack<>(); 
        for(int i = 0 ; i < exp.length() ; i++) 
        { 
            char c = exp.charAt(i); 
            String number = "";
            if(Character.isDigit(c)) 
            {
            	while(i < exp.length() - 1 && ((c >= '0' && c <= '9') || c == '.')) {
            		number += c;
            		i++;
            		c = exp.charAt(i);
            	}
            	values.push(Float.parseFloat(number));	
            }
            else if(c != ' ')	// whenever a operator comes, it pops up the last two values in stack performs operations and pushes the result again into the stack
            { 
                float value1 = values.pop(); 
                float value2 = values.pop(); 
                switch(c) 
                { 
                    case '+': values.push(value2 + value1); 
                    		  break; 
                    case '-': values.push(value2 - value1); 
                    		  break; 
                    case '/': values.push(value2 / value1); 
                    		  break; 
                    case '*': values.push(value2 * value1); 
                    		  break; 
                    case '^': values.push((float)(Math.pow(value2, value1))); 
          		  			  break; 
                    		  
              } 
            } 
        } 
        return values.pop();     
    }
 	//evaluating postfix expression which is of double type
    public static double evaluatePostfixDouble(String exp) 
    { 
        
        Stack<Double> values = new Stack<>(); 
        for(int i = 0 ; i < exp.length() ; i++) 
        { 
            char c = exp.charAt(i); 
            String number = "";
            if(Character.isDigit(c)) 
            {
            	while(i < exp.length() - 1 && ((c >= '0' && c <= '9') || c == '.')) {
            		number += c;
            		i++;
            		c = exp.charAt(i);
            	}
            	values.push(Double.parseDouble(number));	
            }
            else if(c != ' ')
            { 
                double value1 = values.pop(); 
                double value2 = values.pop(); 
                switch(c) 
                { 
                    case '+': values.push(value2 + value1); 
                    		  break; 
                    case '-': values.push(value2 - value1); 
                    		  break; 
                    case '/': values.push(value2 / value1); 
                    		  break; 
                    case '*': values.push(value2 * value1); 
                    		  break; 
                    case '^': values.push(Math.pow(value2, value1)); 
          		  			  break; 
                    		  
              } 
            } 
        } 
        return values.pop();     
    }
	//evaluating postfix expression which is of int type
    public static int evaluatePostfixInt(String exp) 
    { 
        
        Stack<Integer> values = new Stack<>(); 
        for(int i = 0 ; i < exp.length() ; i++) 
        { 
            char c = exp.charAt(i); 
            String number = "";
            if(Character.isDigit(c)) 
            {
            	while(i < exp.length() - 1 && (c >= '0' && c <= '9')) {
            		number += c;
            		i++;
            		c = exp.charAt(i);
            	}
            	values.push(Integer.parseInt(number));	
            }
            else if(c != ' ')
            { 
                int value1 = values.pop(); 
                int value2 = values.pop(); 
                switch(c) 
                { 
                    case '+': values.push(value2 + value1); 
                    		  break; 
                    case '-': values.push(value2 - value1); 
                    		  break; 
                    case '/': values.push(value2 / value1); 
                    		  break; 
                    case '*': values.push(value2 * value1); 
                    		  break; 
                    case '^': values.push((int)Math.pow(value2, value1)); 
          		  			  break; 
                    		  
              } 
            } 
        } 
        return values.pop();     
    }
	//evaluating postfix expression which is of long type
    public static long evaluatePostfixLong(String exp) 
    { 
        
        Stack<Long> values = new Stack<>(); 
        for(int i = 0 ; i < exp.length() ; i++) 
        { 
            char c = exp.charAt(i); 
            String number = "";
            if(Character.isDigit(c)) 
            {
            	while(i < exp.length() - 1 && (c >= '0' && c <= '9')) {
            		number += c;
            		i++;
            		c = exp.charAt(i);
            	}
            	values.push(Long.parseLong(number));	
            }
            else if(c != ' ')
            { 
            	long value1 = values.pop(); 
            	long value2 = values.pop(); 
                switch(c) 
                { 
                    case '+': values.push(value2 + value1); 
                    		  break; 
                    case '-': values.push(value2 - value1); 
                    		  break; 
                    case '/': values.push(value2 / value1); 
                    		  break; 
                    case '*': values.push(value2 * value1); 
                    		  break; 
                    case '^': values.push((long)Math.pow(value2, value1)); 
          		  			  break; 
                    		  
              } 
            } 
        } 
        return values.pop();     
    }
}
