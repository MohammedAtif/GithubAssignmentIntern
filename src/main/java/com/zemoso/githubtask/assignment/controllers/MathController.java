package com.zemoso.githubtask.assignment.controllers;

import com.zemoso.githubtask.assignment.pojos.MathResponse;
import com.zemoso.githubtask.assignment.services.CalculationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("calculate")
public class MathController {

    private final CalculationService calculationService;

    public MathController(CalculationService calculationService) {
        this.calculationService = calculationService;
    }

    @GetMapping("double")
    public @ResponseBody double calculateQuery(@RequestParam(required = false) String query){
        MathResponse mathResponse = new MathResponse();
        mathResponse.setValueDouble(calculationService.calculateDouble(query));
        return mathResponse.getValueDouble();
    }
    @GetMapping("integer")
    public @ResponseBody double calculateIntQuery(@RequestParam(required = false) String query){
        MathResponse mathResponse = new MathResponse();
        mathResponse.setValueInt(calculationService.calculateInt((query)));
        return mathResponse.getValueInt();
    }
    @GetMapping("float")
    public @ResponseBody float calculateFloatQuery(@RequestParam(required = false) String query){
        MathResponse mathResponse = new MathResponse();
        mathResponse.setValueFloat(calculationService.calculateFloat((query)));
        return mathResponse.getValueFloat();
    }
    @GetMapping("long")
    public @ResponseBody long calculatelongQuery(@RequestParam(required = false) String query){
        MathResponse mathResponse = new MathResponse();
        mathResponse.setValueLong(calculationService.calculateLong((query)));
        return mathResponse.getValueLong();
    }

}
