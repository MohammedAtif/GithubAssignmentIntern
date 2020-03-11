package com.zemoso.githubtask.assignment.services.impl;

import com.zemoso.githubtask.assignment.services.CalculationService;
import org.springframework.stereotype.Service;
import java.util.Stack;

@Service
public class PostfixCalculationService implements CalculationService {

    ExpressionEvaluation e = new ExpressionEvaluation();


    @Override
    public int calculateInt(String input) {
        String answer = e.evaluate(input);
        if (answer.equals("Invalid Expression"))
            return 0;
        else {
            double num = Double.parseDouble(answer);
            int numberInt = (int) Math.round(num);
            return numberInt;
//            int n=Integer.valueOf(input);
//            return n;
        }
    }

    @Override
    public float calculateFloat(String input) {

        String answer = e.evaluate(input);
        if (answer.equals("Invalid Expression"))
            return 0;
        else {
            double num = Double.parseDouble(answer);
            float numberFloat = (float) num;
            return numberFloat;
        }
    }

    @Override
    public long calculateLong(String input) {

        String answer = e.evaluate(input);
        if (answer.equals("Invalid Expression"))
            return 0;
        else {
            double num = Double.parseDouble(answer);
            long numberLong = (long) Math.round(num);
            return numberLong;
        }
    }


    @Override
    public double calculateDouble(String input) {
        String answer = e.evaluate(input);
        if (answer.equals("Invalid Expression"))
            return 0.0;
        else
            return Double.parseDouble(answer);
    }
}

