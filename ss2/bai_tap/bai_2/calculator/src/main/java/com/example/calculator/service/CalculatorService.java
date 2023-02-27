package com.example.calculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculatorService{

    @Override
    public double calculate(double numb1, double numb2, String calculation) throws Exception {
        double result = 0;
        switch (calculation){
            case "Addition":
                result = numb1 + numb2;
                break;
            case "Subtraction":
                result = numb1 - numb2;
                break;
            case "Multiplication":
                result = numb1 * numb2;
                break;
            case "Division":
                if (numb2 == 0){
                    throw new Exception("Số bị chia khác 0");
                }else
                    result = numb1 / numb2;
                break;
        }
        return result;
    }
}
