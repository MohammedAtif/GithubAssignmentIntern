package com.zemoso.githubtask.assignment.services.impl;

public class ExpressionEvaluator {

    ExpressionEvaluator(){
    }

    public Double evaluate(String input) {

        ValidateExpression validator = new ValidateExpression();
        if (validator.isValid(input)) {
            InfixToPostfixConverter InfixToPostfixConverter = new InfixToPostfixConverter(input);
            String postfixExp = InfixToPostfixConverter.convert();
            PostfixEvaluation postfixEvaluation = new PostfixEvaluation(postfixExp);
            Double result = postfixEvaluation.evaluate();
            return result;
        }
        return null;

    }
}
