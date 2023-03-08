package com.example.borrow_book.controller;

import com.example.borrow_book.model.Book;
import com.example.borrow_book.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private IBookService bookService;

    @GetMapping("")
    public String listBook(Model model){
        model.addAttribute("listBook", bookService.listAllBook());
        return "list";
    }

    @GetMapping("/findBook/{id}")
    public String informBook(@PathVariable int id, Model model){
        model.addAttribute("book", bookService.findBookById(id));
        return "inform";
    }

    @GetMapping("/borrow/{id}")
    public String borrowBook(@PathVariable int id,Model model){
        Book book = bookService.findBookById(id);
        if (Integer.parseInt(book.getNumber())==0){
            throw new NullPointerException("Đã hết");
        }
        int number = Integer.parseInt(book.getNumber()) -1;
        book.setNumber(String.valueOf(number));
        model.addAttribute("listBook",bookService.listAllBook());
        return "redirect:/book";
    }
}
