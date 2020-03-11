package com.zemoso.githubtask.assignment.services.impl;

import com.zemoso.githubtask.assignment.services.CalculationService;
import org.springframework.stereotype.Service;

import java.util.Stack;

@Service
public class PostfixCalculationService implements CalculationService {

    @Override
    public int calculateInt(String input) {
        return (int)calculateDouble(input);
    }

    @Override
    public float calculateFloat(String input) {
        return (float)calculateDouble(input);
    }

    @Override
    public long calculateLong(String input) {
        return (long)calculateDouble(input);
    }

    @Override
    public double calculateDouble(String expression) {
        if(expression.length()==0)
            return -1;
        expression = expression.trim();
        char[] tokens = expression.toCharArray();
        char lastchar = tokens[tokens.length - 1];
        if(!(lastchar >= '0' && lastchar <= '9') && lastchar!=')')
            return -1;

        Stack<Double> operand = new Stack<>();
        Stack<Character> operator = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {

            if (tokens[i] == ' ')
                continue;

            if ((tokens[i] >= '0' && tokens[i] <= '9') || tokens[i] == '.') {
                StringBuffer stringBuffer = new StringBuffer();

                while (i < tokens.length && ((tokens[i] >= '0' && tokens[i] <= '9') || tokens[i] == '.'))
                    stringBuffer.append(tokens[i++]);
                int count = 0;
                for(int j = 0; j < stringBuffer.length(); j++) {
                    if(stringBuffer.charAt(j) == '.')
                        count++;
                    if(count > 1)
                        return -1;
                }
                operand.push(Double.parseDouble(stringBuffer.toString()));
                if(i != tokens.length)
                    i--;
            }

            else if (tokens[i] == '(')
                operator.push(tokens[i]);

            else if (tokens[i] == ')') {

                while (operator.size() > 0 && operator.peek() != '(')
                    operand.push(applyOp(operator.pop(), operand.pop(), operand.pop()));
                if(operator.size() == 0 || (operator.size() > 0 && operator.peek() != '('))
                    return -1;
                operator.pop();

            }

            else if (tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '*' || tokens[i] == '/') {
                if(tokens[i - 1] == '+' || tokens[i - 1] == '-' || tokens[i - 1] == '*' || tokens[i - 1] == '/')
                    return -1;

                while (!operator.empty() && precedence(tokens[i], operator.peek())) {
                    if(operand.size() < 2)
                        return -1;
                    operand.push(applyOp(operator.pop(), operand.pop(), operand.pop()));
                }

                operator.push(tokens[i]);
            }
            else {
                return -1;
            }
        }

        if(operator.size() > 0 && operand.size() < 2)
            return -1;
        while (!operator.empty())
            operand.push(applyOp(operator.pop(), operand.pop(), operand.pop()));
        double answer = operand.pop();
        return answer;
    }

    public static int getPrecedence(char operator) {
        switch(operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '(':
            case ')':
                return 0;
        }
        return 0;
    }

    public static boolean precedence(char op1, char op2) {
        return getPrecedence(op1) <= getPrecedence(op2);
    }

    public static double applyOp(char op, double b, double a) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0)
                    return -1;
                return a / b;
        }
        return 0;
    }
}