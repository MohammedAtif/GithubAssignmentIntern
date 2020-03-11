package com.zemoso.githubtask.assignment.services.impl;

import java.util.Stack;
import java.util.regex.Pattern;

public class PostfixEvaluation
{
    public static final String DELIMITER = ",";
    String[] postfixExpression;

    Stack<Double> stack;
    PostfixEvaluation(String postfix){
        stack=new Stack<>();
        postfixExpression =postfix.split(DELIMITER);
    }
    public Double evaluate()
    {

        if(postfixExpression.length==1)
                return Double.parseDouble(postfixExpression[0]);

        return performPostfixEvaluation();
    }

    private Double performPostfixEvaluation() {

        for (String element : postfixExpression) {

            if (isDigit(element))
                stack.push(Double.parseDouble(element));

            else {

                Double operand = performOperation(element);
                if(operand==null)
                    return null;
                stack.push(operand);

            }
        }
        return getResult();
    }

    private Double getResult() {
        return stack.pop();
    }

    private Double performOperation(String element) {

        Double operand2=stack.pop();;
        Double operand1=stack.pop();
        char operator = element.charAt(0);

        return performArithmeticOperation(operand1, operand2, operator);

    }

    private Double performArithmeticOperation(Double operand1, Double operand2, char operator) {

        switch (operator) {
            case '+':
                return (operand1 + operand2);
            case '-':
                return (operand1 - operand2);
            case '*':
                return (operand1 * operand2);
            case '/':
                if(Double.compare(operand2,0)==0)
                    return null;
                return (operand1 / operand2);
        }
        return null;
    }

    private boolean isDigit(String theChar)
    {
        String regExp="^[\\+-]?\\d*\\.?\\d+$";

        if(Pattern.matches(regExp,theChar))
            return true;
        else
            return false;
    }

}

