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
    public @ResponseBody MathResponse calculateDoubleQuery(@RequestParam(required = false) String query){
    	System.out.println(query);
        MathResponse mathResponse = new MathResponse();
        mathResponse.setValueDouble(calculationService.calculateDouble(query));
        return mathResponse;
    }
    @GetMapping("int")
    public @ResponseBody MathResponse calculateIntQuery(@RequestParam(required = false) String query){
    	System.out.println(query);
        MathResponse mathResponse = new MathResponse();
        mathResponse.setValueInt(calculationService.calculateInt(query));
        return mathResponse;
    }
    @GetMapping("long")
    public @ResponseBody MathResponse calculateLongQuery(@RequestParam(required = false) String query){
    	System.out.println(query);
        MathResponse mathResponse = new MathResponse();
        mathResponse.setValueLong(calculationService.calculateLong(query));
        return mathResponse;
    }
    @GetMapping("float")
    public @ResponseBody MathResponse calculateFloatQuery(@RequestParam(required = false) String query){
    	System.out.println(query);
        MathResponse mathResponse = new MathResponse();
        mathResponse.setValueFloat(calculationService.calculateFloat(query));
        return mathResponse;
    }

}
