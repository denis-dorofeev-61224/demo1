package com.example.demo1.controller;

import com.example.demo1.service.CalcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {

    private final CalcService calculatorService;

    @Autowired
    public CalculatorController(CalcService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("/add")
    public String add(@RequestParam int a, @RequestParam int b) {
        return "Result of addition: " + calculatorService.add(a, b);
    }

    @GetMapping("/subtract")
    public String subtract(@RequestParam int a, @RequestParam int b) {
        return "Result of subtraction: " + calculatorService.subtract(a, b);
    }

    @GetMapping("/multiply")
    public String multiply(@RequestParam int a, @RequestParam int b) {
        return "Result of multiplication: " + calculatorService.multiply(a, b);
    }

    @GetMapping("/divide")
    public String divide(@RequestParam int a, @RequestParam int b) {
        if (b == 0) {
            return "Error: Division by zero is not allowed!";
        }
        return "Result of division: " + calculatorService.divide(a, b);
    }
}