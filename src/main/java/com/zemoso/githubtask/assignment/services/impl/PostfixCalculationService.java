package com.zemoso.githubtask.assignment.services.impl;

import com.zemoso.githubtask.assignment.services.CalculationService;

import java.util.Stack;

import org.springframework.stereotype.Service;

@Service
public class PostfixCalculationService implements CalculationService {
	
	private InputEvaluator evaluator;
	
	public PostfixCalculationService() {
		evaluator=new InputEvaluator();
	}
	
	
	
    @Override
    public int calculateInt(String input) {
    	
    	int val=(int)evaluator.calculateExpression(input);

    	return val;
    }

    @Override
    public float calculateFloat(String input) {
    	
    	float val=(float)evaluator.calculateExpression(input);
    	return  val;
     
    }

    @Override
    public long calculateLong(String input)
    {
        long val=(long)evaluator.calculateExpression(input);
        return val;
       }

    @Override
    public double calculateDouble(String input) {
    	double val=evaluator.calculateExpression(input);
        return val;
    }
}
