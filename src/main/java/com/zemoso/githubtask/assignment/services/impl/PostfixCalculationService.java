package com.zemoso.githubtask.assignment.services.impl;

import com.zemoso.githubtask.assignment.services.CalculationService;
import org.springframework.stereotype.Service;

import java.util.MissingFormatArgumentException;
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
            char[] chars = expression.toCharArray();

            Stack<Double> operand = new Stack<Double>();
            Stack<Character> operator = new Stack<Character>();

            int count_left = 0, count_right = 0, count_operators = 0, count_operands = 0;

            for (int i = 0; i < chars.length; i++)
            {
                // Current chars is a whitespace, skip it
                if (chars[i] == ' ')
                    continue;

                // Current chars is a positive number, or a negative number, or even a decimal then push it to stack for numbers
                if ((chars[i] >= '0' && chars[i] <= '9') || chars[i]=='.' || (chars[i]=='-' && i==0) || (chars[i]=='-' && chars[i-1]=='(') )
                {
                    StringBuffer num = new StringBuffer();
                    if((chars[i]=='-' && i==0) || (chars[i]=='-' && chars[i-1]=='('))
                    {
                        num.append('-');
                        i++;
                    }
                    // There may be more than one digits in number
                    while (i < chars.length && ((chars[i] >= '0' && chars[i] <= '9')|| chars[i]=='.')) {
                        num.append(chars[i++]);
                    }
                    i--;
                    count_operands++;
                    operand.push(Double.parseDouble(num.toString()));
                }

                else if (chars[i] == '(') {
                    operator.push(chars[i]);
                    count_left++;
                }


                else if (chars[i] == ')')
                {
                    count_right++;
                    while (operator.peek() != '(') {
                        operand.push(applyOp(operator.pop(), operand.pop(), operand.pop()));
                    }
                    operator.pop();
                }

                // Current chars is an operator.
                else if (chars[i] == '+' || chars[i] == '-' || chars[i] == '*' || chars[i] == '/' || chars[i] == '^')
                {
                    count_operators++;
                    while (!operator.empty() && precedence(chars[i]) <= precedence(operator.peek())) {
                        if (operand.size()<=1) {
                            throw new
                                    MissingFormatArgumentException("Syntax error");
                        }
                        operand.push(applyOp(operator.pop(), operand.pop(), operand.pop()));
                    }

                    // Push current chars to 'operator'.
                    operator.push(chars[i]);
                }
            }


            if (count_left != count_right) {
                throw new
                        MissingFormatArgumentException("Missing parenthesis");
            }
            if (count_operators != count_operands-1) {
                throw new
                        MissingFormatArgumentException("Syntax error");
            }

            // Entire expression has been parsed, apply remaining operators
            // on remaining operands in stacks.
            while (!operator.empty()) {
                operand.push(applyOp(operator.pop(), operand.pop(), operand.pop()));
            }

            // Top of 'operand' contains result, return it
            return operand.pop();
        }

    // Returns the precedence of each operator,
    // relative to another.
    private int precedence(char ch)
    {
        switch (ch)
        {
            case '+':
                return 1;
            case '-':
                return 2;
            case '*':
                return 3;
            case '/':
                return 4;
            case '^':
                return 5;
        }
        return -1;

    }

    private double applyOp(char op, double b, double a)
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
                if (b == 0) {
                    throw new
                            UnsupportedOperationException("Cannot divide by zero");
                }
                return a / b;
            case '^':
                return (double)Math.pow(a,b);
        }
        return 0;
    }
}
