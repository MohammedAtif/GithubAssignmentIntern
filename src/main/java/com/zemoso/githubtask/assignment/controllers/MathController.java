package com.zemoso.githubtask.assignment.controllers;

import com.zemoso.githubtask.assignment.pojos.MathResponse;
import com.zemoso.githubtask.assignment.services.CalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("calculate")
public class MathController {

    MathResponse mathResponse = new MathResponse();
    private final CalculationService calculationService;

    @Autowired
    public MathController(CalculationService calculationService) {
        this.calculationService = calculationService;
    }

    @GetMapping("double")
    public @ResponseBody
    MathResponse calculateQuery(@RequestParam(required = false) String query) {
        try {
            mathResponse.setValueDouble(calculationService.calculateDouble(query));
        } catch (Exception e) {

            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "WRONG INPUT", e);
        }
        return mathResponse;
    }

    @GetMapping("int")
    public @ResponseBody
    MathResponse calculateQueryInt(@RequestParam(required = false) String query) {
        try{
            mathResponse.setValueInt(calculationService.calculateInt(query));}
        catch (Exception e)
        {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "WRONG INPUT", e);

        }
        return mathResponse;
    }

    @GetMapping("float")
    public @ResponseBody
    MathResponse calculateQueryFloat(@RequestParam(required = false) String query) {
        try{
            mathResponse.setValueFloat(calculationService.calculateFloat(query));}
        catch (Exception e)
        {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "WRONG INPUT", e);

        }
        return mathResponse;
    }

    @GetMapping("long")
    public @ResponseBody
    MathResponse calculateQueryLong(@RequestParam(required = false) String query) {
        try{
            mathResponse.setValueLong(calculationService.calculateLong(query));}
        catch (Exception e)
        {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "WRONG INPUT", e);

        }
        return mathResponse;
    }
}
