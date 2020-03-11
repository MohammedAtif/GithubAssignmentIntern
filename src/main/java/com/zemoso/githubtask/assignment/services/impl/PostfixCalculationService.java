package com.zemoso.githubtask.assignment.services.impl;

import com.zemoso.githubtask.assignment.services.CalculationService;
import org.springframework.stereotype.Service;

@Service
public class PostfixCalculationService implements CalculationService {

    ExpressionEvaluator expressionEvaluator;

    PostfixCalculationService(){
        expressionEvaluator=new ExpressionEvaluator();
    }

    @Override
    public int calculateInt(String input) {
        Double result=expressionEvaluator.evaluate(input);
        if(result==null)
            return 0;
        //double resultDouble=Double.parseDouble(result);
        return (int)result.doubleValue();
    }

    @Override
    public float calculateFloat(String input) {
        Double result=expressionEvaluator.evaluate(input);
        if(result==null)
            return 0;
        //double resultDouble=Double.parseDouble(result);
        return (float)result.doubleValue();
    }

    @Override
    public long calculateLong(String input) {
        Double result=expressionEvaluator.evaluate(input);
        if(result==null)
            return 0;
        return (long)result.doubleValue();
    }

    @Override
    public double calculateDouble(String input) {
        Double result=expressionEvaluator.evaluate(input);
        if(result==null)
            return 0;
        return result;
    }
}
