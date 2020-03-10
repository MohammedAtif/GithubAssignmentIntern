package com.zemoso.githubtask.assignment.services.impl;

import com.zemoso.githubtask.assignment.services.CalculationService;

import java.util.Stack;

import org.springframework.stereotype.Service;

@Service
public class PostfixCalculationService implements CalculationService {

    @Override
    public int calculateInt(String input) {
        String arr[]=input.split(" ");
        Stack<String> val=new Stack<String>();
        for(int i=0;i<arr.length;i++) {
        	if(arr[i].equals("*") || arr[i].equals("+") || arr[i].equals("-") || arr[i].equals("/")) {
        		int a=Integer.parseInt(val.pop());
        		int b=Integer.parseInt(val.pop());
        		switch (arr[i])  
                {  
                case "+": val.push(String.valueOf(a+b)); break;  
                case "-": val.push(String.valueOf(b-a)); break;  
                case "*": val.push(String.valueOf(b*a)); break;  
                case "/": val.push(String.valueOf(b/a)); break;  
                } 
        	}
        	else 
        		val.push(arr[i]);
        }
        return Integer.parseInt(val.pop());
    }

    @Override
    public float calculateFloat(String input) {
        String arr[]=input.split(" ");
        Stack<String> val=new Stack<String>();
        for(int i=0;i<arr.length;i++) {
        	if(arr[i].equals("*") || arr[i].equals("+") || arr[i].equals("-") || arr[i].equals("/")) {
        		Float a=Float.parseFloat(val.pop());
        		Float b=Float.parseFloat(val.pop());
        		switch (arr[i])  
                {  
                case "+": val.push(String.valueOf(a+b)); break;  
                case "-": val.push(String.valueOf(b-a)); break;  
                case "*": val.push(String.valueOf(b*a)); break;  
                case "/": val.push(String.valueOf(b/a)); break;  
                } 
        	}
        	else 
        		val.push(arr[i]);
        }
        return Float.parseFloat(val.pop());

    }

    @Override
    public long calculateLong(String input) {
    	String arr[]=input.split(" ");
        Stack<String> val=new Stack<String>();
        for(int i=0;i<arr.length;i++) {
        	if(arr[i].equals("*") || arr[i].equals("+") || arr[i].equals("-") || arr[i].equals("/")) {
        		long a=Long.parseLong(val.pop());
        		long b=Long.parseLong(val.pop());
        		switch (arr[i])  
                {  
                case "+": val.push(String.valueOf(a+b)); break;  
                case "-": val.push(String.valueOf(b-a)); break;  
                case "*": val.push(String.valueOf(b*a)); break;  
                case "/": val.push(String.valueOf(b/a)); break;  
                } 
        	}
        	else 
        		val.push(arr[i]);
        }
        return Long.parseLong(val.pop());

    }

    @Override
    public double calculateDouble(String input) {
    	String arr[]=input.split(" ");
        Stack<String> val=new Stack<String>();
        for(int i=0;i<arr.length;i++) {
        	if(arr[i].equals("*") || arr[i].equals("+") || arr[i].equals("-") || arr[i].equals("/")) {
        		double a=Double.parseDouble((val.pop()));
        		double b=Double.parseDouble((val.pop()));
        		switch (arr[i])  
                {  
                case "+": val.push(String.valueOf(b+a)); break;  
                case "-": val.push(String.valueOf(b-a)); break;  
                case "*": val.push(String.valueOf(b*a)); break;  
                case "/": val.push(String.valueOf(b/a)); break;  
                }
        	}
        	else 
    			val.push(arr[i]);
        }
        return Double.parseDouble(val.pop());
    }
}
