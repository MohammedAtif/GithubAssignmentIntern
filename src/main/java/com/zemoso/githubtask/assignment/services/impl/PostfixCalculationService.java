package com.zemoso.githubtask.assignment.services.impl;

import com.zemoso.githubtask.assignment.services.CalculationService;
import org.springframework.stereotype.Service;

import java.util.Stack;

@Service
public class PostfixCalculationService implements CalculationService {

    @Override
    public int calculateInt(String input) {
        String postfixExpression=infixToPostfix(input);
        postfixExpression=postfixExpression.trim();
        Stack<Integer> stack=new Stack<>();
        String postfixArray[]=postfixExpression.split(" ");
        for (int i = 0; i < postfixArray.length; i++) {
            if (postfixArray[i].equals("+") || postfixArray[i].equals("-") || postfixArray[i].equals("*") || postfixArray[i].equals("/")) {
                int number1 = stack.pop();
                int number2 = stack.pop();
                switch (postfixArray[i]) {
                    case "+":
                        stack.push(number2 + number1);
                        break;
                    case "-":
                        stack.push(number2 - number1);
                        break;
                    case "/":
                        stack.push(number2 / number1);
                        break;
                    case "*":
                        stack.push(number2 * number1);
                        break;
                }
            } else if (!postfixArray[i].equals("")) {
                stack.push(Integer.parseInt(postfixArray[i]));
            }
        }
        return stack.pop();
    }

    @Override
    public float calculateFloat(String input) {
        String postfixExpression=infixToPostfix(input);
        postfixExpression=postfixExpression.trim();
        Stack<Float> stack=new Stack<>();
        String postfixArray[]=postfixExpression.split(" ");
        for (int i = 0; i < postfixArray.length; i++) {
            if (postfixArray[i].equals("+") || postfixArray[i].equals("-") || postfixArray[i].equals("*") || postfixArray[i].equals("/")) {
                float number1 = stack.pop();
                float number2 = stack.pop();
                switch (postfixArray[i]) {
                    case "+":
                        stack.push(number2 + number1);
                        break;
                    case "-":
                        stack.push(number2 - number1);
                        break;
                    case "/":
                        stack.push(number2 / number1);
                        break;
                    case "*":
                        stack.push(number2 * number1);
                        break;
                }
            } else if (!postfixArray[i].equals("")) {
                stack.push(Float.parseFloat(postfixArray[i]));
            }
        }
        return stack.pop();
    }

    @Override
    public long calculateLong(String input) {
        String postfixExpression=infixToPostfix(input);
        postfixExpression=postfixExpression.trim();
        Stack<Long> stack=new Stack<>();
        String postfixArray[]=postfixExpression.split(" ");
        for (int i = 0; i < postfixArray.length; i++) {
            if (postfixArray[i].equals("+") || postfixArray[i].equals("-") || postfixArray[i].equals("*") || postfixArray[i].equals("/")) {
                long number1 = stack.pop();
                long number2 = stack.pop();
                switch (postfixArray[i]) {
                    case "+":
                        stack.push(number2 + number1);
                        break;
                    case "-":
                        stack.push(number2 - number1);
                        break;
                    case "/":
                        stack.push(number2 / number1);
                        break;
                    case "*":
                        stack.push(number2 * number1);
                        break;
                }
            } else if (!postfixArray[i].equals("")) {
                stack.push(Long.parseLong(postfixArray[i]));
            }
        }
        return stack.pop();
    }

    @Override
    public double calculateDouble(String input) {
        String postfixExpression=infixToPostfix(input);
        postfixExpression=postfixExpression.trim();
        Stack<Double> stack=new Stack<>();
        String postfixArray[]=postfixExpression.split(" ");
        for (int i = 0; i < postfixArray.length; i++) {
            if (postfixArray[i].equals("+") || postfixArray[i].equals("-") || postfixArray[i].equals("*") || postfixArray[i].equals("/")) {
                double number1 = stack.pop();
                double number2 = stack.pop();
                switch (postfixArray[i]) {
                    case "+":
                        stack.push(number2 + number1);
                        break;
                    case "-":
                        stack.push(number2 - number1);
                        break;
                    case "/":
                        stack.push(number2 / number1);
                        break;
                    case "*":
                        stack.push(number2 * number1);
                        break;
                }
            } else if(!postfixArray[i].equals("")) {
                stack.push(Double.parseDouble(postfixArray[i]));
            }
        }
        return stack.pop();
    }

    public int Precedence(char operand)
    {
        switch (operand) {
            case '+': return 1;
            case '-': return 1;
            case '*': return 2;
            case '/': return 2;
        }
        return -1;
    }

    //convert given infix expression to postfix expression
    public String infixToPostfix(String infixExpression) {
        String postfixExpression = "";
        Stack<Character> stack = new Stack<>();
        String number="";
        for (int i = 0; i<infixExpression.length(); i++) {
            char character = infixExpression.charAt(i);
            if(Character.isAlphabetic(character))
                continue;
            if (Character.isLetterOrDigit(character) || character=='.')
                number+=character;
            else if (character == '(') {
                stack.push(character);
            }
            else if (character == ')') {
                postfixExpression+=number+" ";
                number="";
                while (!stack.isEmpty() && stack.peek() != '(')
                    postfixExpression += stack.pop()+" ";
                stack.pop();
            }
            else {
                postfixExpression+=number+" ";
                number="";
                while (!stack.isEmpty() && Precedence(character) <= Precedence(stack.peek())){
                    postfixExpression += stack.pop()+" ";
                }
                stack.push(character);
            }
        }
        if (number!="")
            postfixExpression+=number+" ";
        while (!stack.isEmpty()){
            postfixExpression += stack.pop()+" ";
        }
        return postfixExpression;
    }
}
