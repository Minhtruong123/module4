package com.example.calculator.controller;

import com.example.calculator.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @Autowired
    ICalculatorService iCalculatorService;

    @GetMapping("/calculator")
    public String showForm() {
        return "/calculator";
    }

    @PostMapping("/calculator")
    public String calculator(@RequestParam double firstNumber, @RequestParam double secondNumber, @RequestParam String calculation, Model model) throws Exception {
        model.addAttribute("result", iCalculatorService.calculate(firstNumber,secondNumber,calculation));
        return "/calculator";
    }
}
