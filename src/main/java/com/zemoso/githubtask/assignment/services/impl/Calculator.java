package com.zemoso.githubtask.assignment.services.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Calculator {
	
	public double evaluate(String input) {
		if(input.charAt(0) == '-')
			input = "0" + input;
		input = input.replace("(-", "(0-");
		List<Object> postfix = convertDecimal(input);
		Stack<Double> operandStack = new Stack<Double>();
		double operand1 = 0, operand2 = 0;
		for (Object obj : postfix) {
			if (obj instanceof Character) {
				char c = (Character) obj;
				operand2 = operandStack.pop();
				operand1 = operandStack.pop();
				switch (c) {
				case '+':
					operandStack.push(operand1 + operand2);
					break;
				case '-':
					operandStack.push(operand1 - operand2);
					break;
				case '*':
					operandStack.push(operand1 * operand2);
					break;
				case '/':
					if(operand2 == 0)
						throw new ArithmeticException();
					operandStack.push(operand1 / operand2);
					break;
				default:
					System.out.println("Invalid Operator");
				}
			} else
				operandStack.push((Double)obj);
		}
		return operandStack.pop();
	}
	
	public static int rank(char operator) {		
		if(operator == '+' || operator == '-')
			return 1;
		else if(operator == '*' || operator == '/')
			return 2;
		else
			return 0;
	}
	
	public static List<Object> convertDecimal(String input) {
		Stack<Character> operatorStack = new Stack<Character>();
		List<Object> postfix = new LinkedList<Object>();
		double number = 0;
		boolean decimal = false;
		long decimalPlace = 10;
		boolean generating = false;
		for (char ch : input.toCharArray()) {
			if ((ch >= '0' && ch <= '9') || ch == '.') {
				if (ch == '.') {
					decimal = true;
					continue;
				}
				if (!decimal)
					number = number * 10 + ch - '0';
				else {
					number += (double) (ch - '0') / (double) decimalPlace;
					decimalPlace *= 10;
				}
				generating = true;
			}
			else if (Character.isAlphabetic(ch))
				throw new NumberFormatException();
			else {
				if (generating)
					postfix.add(number);
				number = 0;
				generating = false;
				decimal = false;
				decimalPlace = 10;
				if (ch == ' ' || ch == '\t')
					continue;
				if (ch == '(')
					operatorStack.push('(');
				else if (ch == ')') {
					while (operatorStack.peek() != '(')
						postfix.add(operatorStack.pop());
					operatorStack.pop();
				}
				else {
					while (!operatorStack.isEmpty() && rank(ch) <= rank(operatorStack.peek()))
						postfix.add(operatorStack.pop());
					operatorStack.push(ch);
				}
			}
		}
		if (generating)
			postfix.add(number);
		while (!operatorStack.isEmpty())
			postfix.add(operatorStack.pop());
		return postfix;
	}
}