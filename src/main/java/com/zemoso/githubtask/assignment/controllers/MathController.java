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
    public @ResponseBody double calculateQueryDouble(@RequestParam(required = false) String query){
        MathResponse mathResponse = new MathResponse();
        mathResponse.setValueDouble(calculationService.calculateDouble(query));
        return mathResponse.getValueDouble();
    }
    @GetMapping("integer")
    public @ResponseBody int calculateQueryInt(@RequestParam(required = false) String query){
        MathResponse mathResponse = new MathResponse();
        mathResponse.setValueInt(calculationService.calculateInt(query));
        return mathResponse.getValueInt();
    }
    @GetMapping("long")
    public @ResponseBody long calculateQueryLong(@RequestParam(required = false) String query) {
        MathResponse mathResponse = new MathResponse();
        mathResponse.setValueLong(calculationService.calculateLong(query));
        return mathResponse.getValueLong();
    }
    @GetMapping("float")
    public @ResponseBody float calculateQueryFloat(@RequestParam(required = false) String query) {
        MathResponse mathResponse = new MathResponse();
        mathResponse.setValueFloat(calculationService.calculateFloat(query));
        return mathResponse.getValueFloat();
    }
}
