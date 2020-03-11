package com.zemoso.githubtask.assignment.services;

import com.zemoso.githubtask.assignment.exceptions.InvalidPostfixException;

public interface CalculationService {

    int calculateInt(String input) throws InvalidPostfixException;
    float calculateFloat(String input) throws InvalidPostfixException;
    long calculateLong(String input) throws InvalidPostfixException;
    double calculateDouble(String input) throws InvalidPostfixException;

}
