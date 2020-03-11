package com.zemoso.githubtask.assignment.services.impl;

import java.util.HashMap;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateExpression {

    private final String REGEX_ARITHMETIC_EXPRESSION = "^([({\\[]*[+-]?\\d*p?\\d+[)}\\]]*)([+-/*][({\\[]*[+-]?\\d*p?\\d+[)}\\]]*)*$";
    Stack<Character> bracketStack;
    HashMap<Character, Character> bracketHashMap;
    public static final String CLOSED_BRACKETS = ")]}";
    public static final String OPEN_BRACKETS = "([{";


    public ValidateExpression(){
        bracketStack=new Stack<Character>();
        bracketHashMap =new HashMap<Character, Character>();
        bracketHashMap.put('(',')');
        bracketHashMap.put('[',']');
        bracketHashMap.put('{','}');
    }
    public boolean isValid(String s)
    {
        /*replace '.' with 'p'
            '.' is not handled properly using regex*/
        if(!s.contains("p")) {

            s=s.replace('.','p');

            Pattern pattern = Pattern.compile(REGEX_ARITHMETIC_EXPRESSION);

            Matcher matcher1 = pattern.matcher(s);
            if (matcher1.matches())
                return isBracketsAligned(s);
        }
        return false;
    }

    private boolean isBracketsAligned(String s) {

        for(int i=0;i<s.length();i++){

            char c=s.charAt(i);

            if(isOpenBracket(c))
                bracketStack.push(c);

            else if(isCloseBracket(c)){

                if(!isLastClosedBracket(c))
                    return false;
                bracketStack.pop();
            }
        }
        if(bracketStack.isEmpty())
            return true;
        return false;
    }
    private boolean isOpenBracket(char theChar) {

        if(OPEN_BRACKETS.contains(theChar+"")){
            return true;
        }
        return false;
    }

    private boolean isCloseBracket(char theChar) {

        if(CLOSED_BRACKETS.contains(theChar+""))
            return true;

        return false;
    }

    private boolean isLastClosedBracket(char theChar){

        if(!bracketStack.isEmpty()) {

            char lastOpenBracket = bracketStack.peek();
            return bracketHashMap.get(lastOpenBracket) == theChar;
        }

        return false;
    }

}