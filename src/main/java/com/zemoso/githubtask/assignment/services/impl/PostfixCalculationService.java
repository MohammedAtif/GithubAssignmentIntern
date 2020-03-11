package com.zemoso.githubtask.assignment.services.impl;

import com.zemoso.githubtask.assignment.exceptions.InvalidPostfixException;
import com.zemoso.githubtask.assignment.services.CalculationService;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.Stack;

@Service
public class PostfixCalculationService implements CalculationService {

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

    @Override
    public int calculateInt(String input) throws InvalidPostfixException {
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
                if (s.equals("/"))
                    stack.push(var1 / var2);
            } else {
                stack.push(Integer.parseInt(s));
            }
        }
        int result = stack.pop();
        return result;
    }

    @Override
    public float calculateFloat(String input) throws InvalidPostfixException {
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
                if (s.equals("/"))
                    stack.push(var1 / var2);
            } else {
                stack.push(Float.parseFloat(s));
            }
        }
        Float result = stack.pop();
        return result;
    }

    @Override
    public long calculateLong(String input) throws InvalidPostfixException {
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
                if (s.equals("/"))
                    stack.push(var1 / var2);
            } else {
                stack.push(Long.parseLong(s));
            }
        }
        long result = stack.pop();
        return result;
    }

    @Override
    public double calculateDouble(String input) throws InvalidPostfixException {
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
                if (s.equals("/"))
                    stack.push(var1 / var2);
            } else {
                stack.push(Double.parseDouble(s));
            }
        }
        double result = stack.pop();
        return result;
    }
}
