package com.zemoso.githubtask.assignment.services.impl;

import java.util.Stack;

public class InfixToPostfixConverter {

    Stack<Character> stack;

    private String infix;
    private final String DELIMITER =",";
    private String postfix="";
    public static final String DIGIT_SIGN = "+-";
    public static final String OPEN_BRACKETS = "([{";
    public static final String CLOSED_BRACKETS = ")]}";
    private int inputLength;

    InfixToPostfixConverter(String inputStr){
        infix=inputStr;
        stack= new Stack<>();
        postfix=new String();
        inputLength = infix.length();
    }

    public String convert(){


        for(int currIndex = 0; currIndex< inputLength; currIndex++){

            char currChar=infix.charAt(currIndex);

            // checks for digit
            if (Character.isLetterOrDigit(currChar)||(currChar=='.'))
                currIndex = addDigitToPostfixExp(currIndex, currChar);

            //checks if open bracket then adds to stack
            else if (isOpenBracket(currChar))
                currIndex = pushCharCheckNextDigitSign(currIndex, currChar);

            //checks if closed bracket
            else if(isCloseBracket(currChar))
                handleClosedBracket();

            //operator
            else{
                handleOperator(currIndex, currChar);
                currIndex = pushCharCheckNextDigitSign(currIndex, currChar);
            }
        }

        emptyStackToPostfix();

        return postfix;
    }

    private void emptyStackToPostfix() {
        while (!stack.isEmpty())
            postfix += stack.pop()+ DELIMITER;
    }

    private void handleOperator(int currIndex, char currChar) {
        while(!stack.isEmpty() && operatorPrecedence(currChar)<= operatorPrecedence(stack.peek())){
            postfix += stack.pop();
            if(currIndex!=0)
                postfix += DELIMITER;
        }
    }

    private void handleClosedBracket() {
        while (!stack.isEmpty() && !isOpenBracket(stack.peek()))
            postfix+=stack.pop()+ DELIMITER;
        stack.pop();
    }

    private int pushCharCheckNextDigitSign(int currIndex, char currChar) {
        stack.push(currChar);
        if (isSign(infix.charAt(currIndex + 1))) {
            currIndex++;
            postfix += infix.charAt(currIndex);
        }
        return currIndex;
    }

    private int addDigitToPostfixExp(int currIndex, char currChar) {

        String digit = ""+currChar;

        while ((currIndex+1)<inputLength &&
                (Character.isLetterOrDigit(infix.charAt(currIndex+1))
                || (infix.charAt(currIndex+1) == '.'))) {

            currIndex++;
            currChar=infix.charAt(currIndex);
            digit += currChar;
        }

        if (!digit.isEmpty()) {
            postfix += digit + DELIMITER;
        }
        return currIndex;
    }


    private boolean isSign(char c) {

        if(DIGIT_SIGN.contains(c+""))
            return true;

        return false;

    }

    private int operatorPrecedence(char operator) {

        switch (operator)
        {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;
        }
        return -1;
    }

    private boolean isOpenBracket(char theChar) {

        if(OPEN_BRACKETS.contains(theChar+""))
            return true;

        return false;
    }

    private boolean isCloseBracket(char theChar) {

        if(CLOSED_BRACKETS.contains(theChar+""))
            return true;

        return false;
    }

}
