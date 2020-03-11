package com.zemoso.githubtask.assignment.controllers;

import com.zemoso.githubtask.assignment.exceptions.InvalidPostfixException;
import com.zemoso.githubtask.assignment.pojos.MathResponse;
import com.zemoso.githubtask.assignment.services.CalculationService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("calculate")
public class MathController {

    private final CalculationService calculationService;

    public MathController(CalculationService calculationService) {
        this.calculationService = calculationService;
    }

    @GetMapping("double")
    public @ResponseBody MathResponse calculateQueryDouble(@RequestParam(required = false) String query){
        MathResponse mathResponse = new MathResponse();
        try {
            mathResponse.setValueDouble(calculationService.calculateDouble(query));
        } catch (InvalidPostfixException invalidPostfixException) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,"Invalid postfix expression - Controller", invalidPostfixException
            );
        }
        return mathResponse;
    }
    @GetMapping("int")
    public @ResponseBody MathResponse calculateQueryInt(@RequestParam(required = false) String query){
        MathResponse mathResponse = new MathResponse();
        try {
            mathResponse.setValueInt(calculationService.calculateInt(query));
        }
        catch(InvalidPostfixException invalidPostfixException){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,"Invalid postfix expression - Controller", invalidPostfixException
            );
        }
        return mathResponse;
    }

    @GetMapping("float")
    public @ResponseBody MathResponse calculateQueryFloat(@RequestParam(required = false) String query){
        MathResponse mathResponse = new MathResponse();
        try {
            mathResponse.setValueFloat(calculationService.calculateFloat(query));
        } catch (InvalidPostfixException invalidPostfixException) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,"Invalid postfix expression - Controller", invalidPostfixException
            );
        }
        return mathResponse;
    }
    @GetMapping("long")
    public @ResponseBody MathResponse calculateQueryLong(@RequestParam(required = false) String query){
        MathResponse mathResponse = new MathResponse();
        try {
            mathResponse.setValueLong(calculationService.calculateLong(query));
        } catch (InvalidPostfixException invalidPostfixException) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,"Invalid postfix expression - Controller", invalidPostfixException
            );
        }
        return mathResponse;
    }

}
