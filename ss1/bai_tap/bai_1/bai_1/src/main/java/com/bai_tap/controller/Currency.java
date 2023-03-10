package com.bai_tap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class Currency {

    @GetMapping("/currency")
    public String currency(@RequestParam(required = false) Double usd, Model model) {
        if (usd == null) {
            return "/currency";
        }
        double vnd = usd * 23000;
        model.addAttribute("vnd", vnd);
        return "/currency";
    }
}
