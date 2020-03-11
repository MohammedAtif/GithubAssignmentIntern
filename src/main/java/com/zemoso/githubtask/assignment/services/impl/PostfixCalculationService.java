package com.zemoso.githubtask.assignment.services.impl;

import com.zemoso.githubtask.assignment.exceptions.InvalidPostfixException;
import com.zemoso.githubtask.assignment.services.CalculationService;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.Stack;

@Service
public class PostfixCalculationService implements CalculationService {
    public int checkPrecedence(char operator) {
        if (operator == '*' || operator == '/') return 2;
        else if (operator == '+' || operator == '-') return 1;
        else return 0;
    }
    public boolean isOperator(char operator){
        if(operator == '+' || operator == '-' || operator == '*' || operator == '/') return true;
        return false;
    }
    public String infixToPostfix(String input){
        String output = "";
        Stack<Character> characterStack = new Stack<>();
        characterStack.push('(');
        input += ')';
        int i = 0;
        for (; i < input.length(); i++) {
            String temp = "";
            if (input.charAt(i) == '.' || (input.charAt(i) >= 48 && input.charAt(i) <= 57)) {
                for (; i < input.length(); i++) {
                    if (input.charAt(i) == '.' || (input.charAt(i) >= 48 && input.charAt(i) <= 57)) {
                        temp += input.charAt(i);
                    }
                    else {
                        output += temp + ",";
                        i--;
                        break;
                    }
                }
            } else if (isOperator(input.charAt(i))) {
                char x = characterStack.pop();
                while (isOperator(input.charAt(i))  &&  characterStack.size() > 0 && isOperator(x) && checkPrecedence(x) >= checkPrecedence(input.charAt(i))) {
                    output += x + ",";
                    x = characterStack.pop();
                }
                characterStack.push(x);
                characterStack.push(input.charAt(i));
            } else if (input.charAt(i) == ')') {
                while (characterStack.size() > 0 && characterStack.peek() != '(') {
                    output += characterStack.peek() + ",";
                    characterStack.pop();
                }
            }
        }
        return output;
    }
    public boolean postfixValidator(String[] arr) {
        for (String s : arr) {
            if (s == null) {
                return false;
            }
            if((s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"))) {
                continue;
            }
            try {
                double d = Double.parseDouble(s);
            } catch (NumberFormatException nfe) {
                return false;
            }
        }
        return true;
    }

    public boolean infixValidator(String input) {
        for(int i=0;i<input.length();i++){
            if(isOperator(input.charAt(i)) || input.charAt(i) == '.' || (input.charAt(i) >= 48 && input.charAt(i) <= 57) ||
                    input.charAt(i) == '(' || input.charAt(i) == ')') continue;
            else return false;
        }
        return true;
    }

    @Override
    public int calculateInt(String input) throws InvalidPostfixException {
        if(!infixValidator(input)) {
            throw new InvalidPostfixException("Invalid Postfix Expression - Service");
        };
        input = infixToPostfix(input);
        String[] arr = input.split(",");
        if(!postfixValidator(arr)) {
            throw new InvalidPostfixException("Invalid Postfix Expression - Service");
        };
        Stack<Integer> stack = new Stack<Integer>();
        for (String s : arr) {
            if ((s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) && (stack.size() > 1)) {

                int var2 = stack.pop();
                int var1 = stack.pop();

                if (s.equals("+"))
                    stack.push(var1 + var2);
                if (s.equals("-"))
                    stack.push(var1 - var2);
                if (s.equals("*"))
                    stack.push(var1 * var2);
                try {
                    if (s.equals("/"))
                        stack.push(var1 / var2);
                }
                catch(ArithmeticException e){
                    throw new InvalidPostfixException("Invalid Postfix Expression - Service");
                }
            } else {
                stack.push(Integer.parseInt(s));
            }
        }
        int result = stack.pop();
        return result;
    }

    @Override
    public float calculateFloat(String input) throws InvalidPostfixException {
        if(!infixValidator(input)) {
            throw new InvalidPostfixException("Invalid Postfix Expression - Service");
        };
        input = infixToPostfix(input);
        String[] arr = input.split(",");
        if(!postfixValidator(arr)) {
            throw new InvalidPostfixException("Invalid Postfix Expression - Service");
        };
        Stack<Float> stack = new Stack<Float>();
        for (String s : arr) {
            if ((s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) && (stack.size() > 1)) {

                Float var2 = stack.pop();
                Float var1 = stack.pop();

                if (s.equals("+"))
                    stack.push(var1 + var2);
                if (s.equals("-"))
                    stack.push(var1 - var2);
                if (s.equals("*"))
                    stack.push(var1 * var2);
                try {
                    if (s.equals("/"))
                        stack.push(var1 / var2);
                }
                catch(ArithmeticException e){
                    throw new InvalidPostfixException("Invalid Postfix Expression - Service");
                }
            } else {
                stack.push(Float.parseFloat(s));
            }
        }
        Float result = stack.pop();
        return result;
    }

    @Override
    public long calculateLong(String input) throws InvalidPostfixException {
        if(!infixValidator(input)) {
            throw new InvalidPostfixException("Invalid Postfix Expression - Service");
        };
        input = infixToPostfix(input);
        String[] arr = input.split(",");
        if(!postfixValidator(arr)) {
            throw new InvalidPostfixException("Invalid Postfix Expression - Service");
        };
        Stack<Long> stack = new Stack<Long>();
        for (String s : arr) {
            if ((s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) && (stack.size() > 1)) {

                long var2 = stack.pop();
                long var1 = stack.pop();

                if (s.equals("+"))
                    stack.push(var1 + var2);
                if (s.equals("-"))
                    stack.push(var1 - var2);
                if (s.equals("*"))
                    stack.push(var1 * var2);
                try {
                    if (s.equals("/"))
                        stack.push(var1 / var2);
                }
                catch(ArithmeticException e){
                    throw new InvalidPostfixException("Invalid Postfix Expression - Service");
                }
            } else {
                stack.push(Long.parseLong(s));
            }
        }
        long result = stack.pop();
        return result;
    }

    @Override
    public double calculateDouble(String input) throws InvalidPostfixException {
        if(!infixValidator(input)) {
            throw new InvalidPostfixException("Invalid Postfix Expression - Service");
        };
        input = infixToPostfix(input);
        String[] arr = input.split(",");
        if(!postfixValidator(arr)) {
            throw new InvalidPostfixException("Invalid Postfix Expression - Service");
        };
        Stack<Double> stack = new Stack<Double>();
        for (String s : arr) {
            if ((s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) && (stack.size() > 1)) {

                double var2 = stack.pop();
                double var1= stack.pop();

                if (s.equals("+"))
                    stack.push(var1 + var2);
                if (s.equals("-"))
                    stack.push(var1 - var2);
                if (s.equals("*"))
                    stack.push(var1 * var2);
                try {
                    if (s.equals("/"))
                        stack.push(var1 / var2);
                }
                catch(ArithmeticException e){
                    throw new InvalidPostfixException("Invalid Postfix Expression - Service");
                }
            } else {
                stack.push(Double.parseDouble(s));
            }
        }
        double result = stack.pop();
        return result;
    }
}
