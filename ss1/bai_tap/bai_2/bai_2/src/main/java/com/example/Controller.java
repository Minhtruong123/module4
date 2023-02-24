package com.example;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@org.springframework.stereotype.Controller
public class Controller {
    private static final Map<String, String> listMap = new HashMap<>();
    static {
        listMap.put("computer", "máy tính");
        listMap.put("bike", "xe");
        listMap.put("desk", "cái bàn");
    }
    @GetMapping("/search")
    public String search(@RequestParam (required = false) String word, Model model){
        if (word == null){
            model.addAttribute("search", "Không tìm thấy");
            return "/search";
        }
        model.addAttribute("search", listMap.get(word));
        return "/search";
    }
}
