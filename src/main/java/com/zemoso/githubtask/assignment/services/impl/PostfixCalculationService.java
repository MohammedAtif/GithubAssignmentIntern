package com.zemoso.githubtask.assignment.services.impl;

import com.zemoso.githubtask.assignment.services.CalculationService;
import org.springframework.stereotype.Service;

import java.util.Stack;

@Service
public class PostfixCalculationService implements CalculationService {

    @Override
    public int calculateInt(String input) {
        String[] words = input.split(" ");
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (int i = 0; i < words.length; i++) {
            String ch = words[i];
            if (ch.equals("+") || ch.equals("-") || ch.equals("*") || ch.equals("/")) {
                int j = stack.pop();
                int k = stack.pop();
                switch (ch) {
                    case "+":res = j + k;break;
                    case "-":res = k - j;break;
                    case "*":res = j * k;break;
                    case "/":res = j / k;break;
                    default:res = 0;
                }
                stack.push(res);
            }
            else
                stack.push(Integer.parseInt(ch));
        }
        res=stack.pop();
        return res;
    }

    @Override
    public float calculateFloat(String input) {
        String[] words = input.split(" ");
        Stack<Float> stack = new Stack<>();
        float res = 0;
        for (int i = 0; i < words.length; i++) {
            String ch = words[i];
            if (ch.equals("+") || ch.equals("-") || ch.equals("*") || ch.equals("/")) {
                float j = stack.pop();
                float k = stack.pop();
                switch (ch) {
                    case "+":res = j + k;break;
                    case "-":res = k - j;break;
                    case "*":res = j * k;break;
                    case "/":res = j / k;break;
                    default:res = 0;
                }
                stack.push(res);
            }
            else
                stack.push(Float.parseFloat(ch));
        }
        res=stack.pop();
        return res;
    }

    @Override
    public long calculateLong(String input) {
        String[] words = input.split(" ");
        Stack<Long> stack = new Stack<>();
        long res = 0;
        for (int i = 0; i < words.length; i++) {
            String ch = words[i];
            if (ch.equals("+") || ch.equals("-") || ch.equals("*") || ch.equals("/")) {
                long j = stack.pop();
                long k = stack.pop();
                switch (ch) {
                    case "+":res = j + k;break;
                    case "-":res = k - j;break;
                    case "*":res = j * k;break;
                    case "/":res = j / k;break;
                    default:res = 0;
                }
                stack.push(res);
            }
            else
                stack.push(Long.parseLong(ch));
        }
        res=stack.pop();
        return res;
    }

    @Override
    public double calculateDouble(String input) {
        String[] words = input.split(" ");
        Stack<Double> stack = new Stack<>();
        double res = 0;
        for (int i = 0; i < words.length; i++) {
            String ch = words[i];
            if (ch.equals("+") || ch.equals("-") || ch.equals("*") || ch.equals("/")) {
                double j = stack.pop();
                double k = stack.pop();
                switch (ch) {
                    case "+":res = j + k;break;
                    case "-":res = k - j;break;
                    case "*":res = j * k;break;
                    case "/":res = j / k;break;
                    default:res = 0;
                }
                stack.push(res);
            }
            else
                stack.push(Double.parseDouble(ch));
        }
        res=stack.pop();
        return res;
    }
}
