package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.service.IBlogService;
import com.example.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("")
    public String listBlogs(@RequestParam(name = "search", defaultValue = "")  String search,
                            Model model,
                            @PageableDefault(size = 5, sort = "id", direction = Sort.Direction.DESC)Pageable pageable) {
        Page<Blog> blogPage = blogService.searchBlog(search, pageable);
        model.addAttribute("blogsList", blogPage);
        List<Integer> integers = new ArrayList<>();
        for (int i=1; i <= blogPage.getTotalPages(); i++){
            integers.add(i);
        }
        model.addAttribute("pages", integers);
        return "/list";
    }
    @GetMapping("/showCreate")
    public String showCreateBlog(Model model) {
        model.addAttribute("categoryList", categoryService.listAllCategory());
        model.addAttribute("blog", new Blog());
        return "/create";
    }

    @PostMapping("/createBlog")
    public String createBlog(@ModelAttribute(name = "blogNew") Blog blogNew) {
        blogService.createBlog(blogNew);
        return "redirect:/blog";
    }

    @GetMapping("/inform/{id}")
    public String getInform(@PathVariable Integer id, Model model) {
        model.addAttribute("blogInform", blogService.getBlog(id));
//        model.addAttribute("categoryInform", categoryService.getCategoryById(id));
        return "/information";
    }

    @GetMapping("/deleteBlog/{id}")
    public String deleteBlog(@PathVariable int id) {
        blogService.deleteBlog(id);
        return "redirect:/blog";
    }

    @GetMapping("/showEdit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        model.addAttribute("categoryList", categoryService.listAllCategory());
        model.addAttribute("blog", blogService.getBlog(id));
        return "/edit";
    }

    @PostMapping("/editBlog")
    public String editBlog(@ModelAttribute(name = "blog") Blog blog, Model model) {
        blogService.editBlog(blog);
        return "redirect:/blog";
    }
}
