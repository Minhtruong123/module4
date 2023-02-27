package com.example.sandwich.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandwichController {
    @GetMapping("/save")
    public String showForm(){
        return "/sandwichCondiments";
    }
    @PostMapping("/save")
    public String save(@RequestParam("condiment") String condiment, Model model){
        model.addAttribute("listCondiments", condiment);
        return "/sandwichCondiments";
    }
}
