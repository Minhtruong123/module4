package com.example.controller;

import com.example.model.MailBox;
import com.example.service.IMailBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;

@Controller
public class MailBoxController {
    @Autowired
    IMailBoxService iMailBoxService;

    @GetMapping("/showMail")
    public String showForm(Model model) {
        model.addAttribute("mailBox", iMailBoxService.mailBox());
        if (iMailBoxService.mailBox().isSpamFilter()) {
            model.addAttribute("spamFilter", "Enable spams filter");
        } else model.addAttribute("spamFilter", "Disanable spams filter");


        return "/index";
    }

    @GetMapping("/updateFormMail")
    public String showUpdate(Model model) {
        model.addAttribute("mailBox", iMailBoxService.mailBox());
        model.addAttribute("languages", Arrays.asList("English", "Vietnamese", "Japanese", "Chinese"));
        model.addAttribute("pageSize", Arrays.asList(5, 10, 15, 20, 25, 50, 100));
        return "/update";
    }

    @PostMapping("/updateEmail")
    public String updateMail(@ModelAttribute MailBox mailBox, RedirectAttributes redirectAttributes) {
        this.iMailBoxService.updateMailBox(mailBox);
        redirectAttributes.addFlashAttribute("msg", "Cập nhật thành công");
        return "redirect:/showMail";
    }
}
