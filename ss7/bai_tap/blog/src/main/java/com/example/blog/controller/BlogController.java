package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping("")
    public String listBlogs(@RequestParam(name = "search", defaultValue = "")  String search, Model model) {
        model.addAttribute("blogsList", blogService.searchBlog(search));
        return "/list";
    }

    @GetMapping("/showCreate")
    public String showCreateBlog(Model model) {
        model.addAttribute("blog", new Blog());
        return "/create";
    }

    @PostMapping("/createBlog")
    public String createBlog(@ModelAttribute(name = "blogNew") Blog blogNew) {
        blogService.createBlog(blogNew);
        return "redirect:/blog";
    }

    @GetMapping("/inform/{id}")
    public String getInform(@PathVariable int id, Model model) {
        model.addAttribute("blogInform", blogService.getBlog(id));
        return "/information";
    }

    @GetMapping("/deleteBlog/{id}")
    public String deleteBlog(@PathVariable int id) {
        blogService.deleteBlog(id);
        return "redirect:/blog";
    }

    @GetMapping("/showEdit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        model.addAttribute("blog", blogService.getBlog(id));
        return "/edit";
    }

    @PostMapping("/editBlog")
    public String editBlog(@ModelAttribute(name = "blog") Blog blog, Model model) {
        blogService.editBlog(blog);
        return "redirect:/blog";
    }
}
