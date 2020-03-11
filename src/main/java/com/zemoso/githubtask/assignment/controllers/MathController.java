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
    public @ResponseBody MathResponse calculateQueryDouble(@RequestParam(required = false) String query){
        MathResponse mathResponse = new MathResponse();
        mathResponse.setValueDouble(calculationService.calculateDouble(query));
        return mathResponse;
    }

    @GetMapping("integer")
    public @ResponseBody MathResponse calculateQueryInteger(@RequestParam(required = false) String query){
        MathResponse mathResponse = new MathResponse();
        mathResponse.setValueInt(calculationService.calculateInt(query));
        return mathResponse;
    }


    @GetMapping("float")
    public @ResponseBody MathResponse calculateQueryFloat(@RequestParam(required = false) String query) {
        MathResponse mathResponse = new MathResponse();
        mathResponse.setValueFloat(calculationService.calculateFloat(query));
        return mathResponse;
    }


    @GetMapping("long")
    public @ResponseBody MathResponse calculateQueryLong(@RequestParam(required = false) String query) {
        MathResponse mathResponse = new MathResponse();
        mathResponse.setValueLong(calculationService.calculateLong(query));
        return mathResponse;
    }

}
