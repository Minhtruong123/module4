package com.example.calculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @GetMapping("/calculator")
    public String showForm() {
        return "/calculator";
    }

    @PostMapping("/calculator")
    public String calculator(@RequestParam double firstNumber, @RequestParam double secondNumber, @RequestParam String calculation, Model model) {
        double result = 0;
        switch (calculation){
            case "Addition":
                result = firstNumber + secondNumber;
                break;
            case "Subtraction":
                result = firstNumber - secondNumber;
                break;
            case "Multiplication":
                result = firstNumber * secondNumber;
                break;
            case "Division":
                result = firstNumber / secondNumber;
                break;
        }
        model.addAttribute("result", result);
        return "/calculator";
    }
}
