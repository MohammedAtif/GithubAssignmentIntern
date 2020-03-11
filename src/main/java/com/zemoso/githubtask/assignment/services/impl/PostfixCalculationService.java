package com.zemoso.githubtask.assignment.services.impl;

import com.zemoso.githubtask.assignment.services.CalculationService;
import java.util.Stack;
import org.springframework.stereotype.Service;

@Service
public class PostfixCalculationService implements CalculationService {

    @Override
    public int calculateInt(String input) {
    double answer=PostfixCalculationService.evaluate(input);
        int ans = (int)answer;
        return ans;
    }

    @Override
    public float calculateFloat(String input) {
    double answer=PostfixCalculationService.evaluate(input);
    float ans = (float)answer;
        return ans;
    }

    @Override
    public long calculateLong(String input) {
    double answer=PostfixCalculationService.evaluate(input);
    long ans = (long)answer;
        return ans;
    }

    @Override
    public double calculateDouble(String input) {
    double answer=PostfixCalculationService.evaluate(input);
        return answer;
    }
    static double evaluate(String expression) 
    { 
        char[] tokens = expression.toCharArray(); 
        double answer=0;
        Stack<Double> values = new Stack<Double>(); 
        Stack<Character> ops = new Stack<Character>(); 
        for (int i = 0; i < tokens.length; i++) 
        { 
            if (Character.isDigit(tokens[i])) 
            { 
                StringBuilder sb = new StringBuilder(); 
                while (i < tokens.length && (Character.isDigit(tokens[i])||tokens[i]=='.'))
                    sb.append(tokens[i++]); 
                values.push(Double.parseDouble(sb.toString()));
                if(i!=tokens.length)
                i--;
            } 
            else if (isOperator(tokens[i])) 
            { 
                while (!ops.empty() && hasPrecedence(tokens[i], ops.peek())) 
                {
                  values.push(applyOp(ops.pop(), values.pop(), values.pop()));

                }
        
                ops.push(tokens[i]); 
            } 
        } 
        while (!ops.empty())
        {
            values.push(applyOp(ops.pop(), values.pop(), values.pop()));  
        }
        answer=values.pop();
        String temp=""+answer;
        String s[]=temp.split("[.]");
         if(s[1].length()>2)
         {
             answer=Double.parseDouble(s[0]+"."+s[1].substring(0,2));
         }
        return answer; 
    } 
   
     static boolean hasPrecedence(char op1, char op2) 
    {  
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
        {
            return false; 
        }
        else
        {
            return true; 
        }
    } 
  
     static double applyOp(char op, double b, double a) 
     { 
        double result=0;
        switch (op) 
        { 
        case '+': 
            result = a + b;
            break;
        case '-': 
            result = a - b;
            break;
        case '*': 
            result = a * b;
            break;
        case '/': 
            try {
                result = a/b;
            } catch(ArithmeticException e) {
                System.out.println(e.getMessage());
            } 
            break;
        } 
        return result; 
    } 
    
    static boolean isOperator(char op)
    {
        boolean flag=false;
        if(op=='+'||op=='-'||op=='*'||op=='/')
        {
            flag=true;
        }
        else
        {
            flag=false;
        }
        return flag;
    }

}
