package com.zemoso.githubtask.assignment.services.impl;

import com.zemoso.githubtask.assignment.services.CalculationService;

import java.util.EmptyStackException;
import java.util.Stack;
import org.springframework.stereotype.Service;

class ExpressionEvaluation {

    public static double evaluate(String expression) throws EmptyStackException {
        char[] tokens = expression.toCharArray();

        Stack<Double> values = new Stack<Double>();


        Stack<Character> ops = new Stack<Character>();


        for (int i = 0; i < tokens.length; i++)
        {

            if (tokens[i] == ' ')
                continue;


            if (Character.isDigit(tokens[i])) {
                StringBuffer sbuf = new StringBuffer();


                while (i < tokens.length && (Character.isDigit(tokens[i]) || tokens[i] == '.')) {
                    sbuf.append(tokens[i++]);

                }
                i--;

                System.out.println(sbuf);
                values.push(Double.parseDouble(sbuf.toString()));

            } else if (tokens[i] == '(')
                ops.push(tokens[i]);


            else if (tokens[i] == ')') {
                while (ops.peek() != '(')
                    values.push(applyOperation(ops.pop(), values.pop(), values.pop()));
                ops.pop();
            } else if (tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '*' || tokens[i] == '/') {

                while (!ops.empty() && hasPrecedence(tokens[i], ops.peek()))
                    values.push(applyOperation(ops.pop(), values.pop(), values.pop()));


                ops.push(tokens[i]);
            }

        }


        while (!ops.empty()) {
            values.push(applyOperation(ops.pop(), values.pop(), values.pop()));
        }
        return values.pop();
    }


    public static boolean hasPrecedence(char op1, char op2) {
        if (op2 == '(')
            return false;
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
            return false;
        else
            return true;
    }


    public static double applyOperation(char op, double b, double a) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0)
                    throw new
                            UnsupportedOperationException("Cannot divide by 0");
                return a / b;
        }
        return 0;
    }
}
    @Service
public class PostfixCalculationService implements CalculationService {

    @Override
    public int calculateInt(String input)
    {
        System.out.println(ExpressionEvaluation.evaluate(input));
        return (int)ExpressionEvaluation.evaluate(input);
    }

    @Override
    public float calculateFloat(String input) {
        return (float)ExpressionEvaluation.evaluate(input);
    }

    @Override
    public long calculateLong(String input) {
        return (long) ExpressionEvaluation.evaluate(input);
    }

    @Override
    public double calculateDouble(String input) {
        return ExpressionEvaluation.evaluate(input);
    }

}
