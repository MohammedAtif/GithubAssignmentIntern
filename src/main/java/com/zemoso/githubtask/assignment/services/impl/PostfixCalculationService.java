package com.zemoso.githubtask.assignment.services.impl;

import com.zemoso.githubtask.assignment.services.CalculationService;

import java.util.Stack;

import org.springframework.stereotype.Service;

@Service
public class PostfixCalculationService implements CalculationService {

    @Override
    public int calculateInt(String input) {
        double res = calculate(input);
        int r = (int) res;
        return r;
    }

    @Override
    public float calculateFloat(String input) {
        double res = calculate(input);
        float r = (float) res;
        return r;
    }

    @Override
    public long calculateLong(String input) {
        double res = calculate(input);
        long r = (long) res;
        return r;
    }

    @Override
    public double calculateDouble(String input) {
        double res;
        res = calculate(input);
        return res;
    }


    public double calculate(String inp) {
        char[] input = inp.toCharArray();

        Stack<Double> numstack = new Stack<Double>();

        Stack<Character> opstack = new Stack<Character>();

        for (int i = 0; i < input.length; i++)
        {
            if ((input[i] >= '0' && input[i] <= '9')|| input[i]=='.')
            {
                StringBuffer s = new StringBuffer();
                while (i < input.length && ((input[i] >= '0' &&input[i] <= '9') || input[i]=='.' ))
                    s.append(input[i++]);
                //s.append(".");
                numstack.push(Double.parseDouble(s.toString()));
                i=i-1;
            }
            else if (input[i] == '(')
                opstack.push(input[i]);

            else if (input[i] == ')')
            {
                while (opstack.peek() != '(')
                    numstack.push(eval(opstack.pop(), numstack.pop(), numstack.pop()));
                opstack.pop();
            }
            else if (input[i] == '+' || input[i] == '-' || input[i] == '*' || input[i] == '/')
            {
                if(input[i]=='-') {
                    if(i==0 || !Character.isDigit(input[i-1])) {
                        StringBuffer s = new StringBuffer();
                        s.append('-');
                        i+=1;
                        while (i<input.length && (input[i]>='0'&&input[i]<='9'))
                            s.append(input[i++]);
                        numstack.push(Double.parseDouble(s.toString()));
                        i=i-1;
                        continue;
                    }}

                while (!opstack.empty() && precedence(input[i], opstack.peek()))
                    numstack.push(eval(opstack.pop(), numstack.pop(), numstack.pop()));
                opstack.push(input[i]);
            }
        }
        while (!opstack.empty())
            numstack.push(eval(opstack.pop(), numstack.pop(), numstack.pop()));
        return numstack.pop();
    }
    public static double eval(char operator, double num2, double num1) {
        switch (operator) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                if (num2 == 0)
                    throw new
                            ArithmeticException(" / by 0 ");
                return num1 / num2;
        }
        return 0;
    }

    public static boolean precedence(char operator1, char operator2) {
        if (operator2 == '(' || operator2 == ')')
            return false;
        if ((operator1 == '*' || operator1 == '/') && (operator2 == '+' || operator2 == '-'))
            return false;
        else
            return true;
    }

}