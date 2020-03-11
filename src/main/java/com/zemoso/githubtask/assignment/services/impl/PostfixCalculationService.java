package com.zemoso.githubtask.assignment.services.impl;

import com.zemoso.githubtask.assignment.services.CalculationService;
import org.springframework.stereotype.Service;

@Service
public class PostfixCalculationService implements CalculationService {

	private Calculator calculator;
	
	public PostfixCalculationService() {
		calculator = new Calculator();
	}
	
	@Override
    public int calculateInt(String input) {
		return (int)calculator.evaluate(input);
	}
	
	@Override
    public float calculateFloat(String input) {
		return (float)calculator.evaluate(input);
	}
	
	@Override
    public long calculateLong(String input) {
		return (long)calculator.evaluate(input);
	}
	
	@Override
    public double calculateDouble(String input) {
		return calculator.evaluate(input);
	}
	
}