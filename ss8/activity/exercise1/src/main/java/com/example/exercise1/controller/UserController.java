package com.example.exercise1.controller;

import com.example.exercise1.model.User;
import com.example.exercise1.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("")
    private String showUserList(Model model){
        model.addAttribute("listUser", userService.listAllUser());
        return "list";
    }
    @GetMapping("/showFormCreate")
    private String showFormCreate(Model model){
        model.addAttribute("user", new User());
        return "create";
    }

    @PostMapping("/validate")
    private String validateUser(@Validated @ModelAttribute User user, BindingResult bindingResult){
        if (bindingResult.hasFieldErrors()){
            return "create";
        }else {
            userService.addUser(user);
            return "redirect:/user";
        }
    }
}
