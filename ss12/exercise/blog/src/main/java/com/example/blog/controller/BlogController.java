package com.example.blog.controller;

import com.example.blog.dto.BlogDTO;
import com.example.blog.model.Blog;
import com.example.blog.model.Category;
import com.example.blog.service.IBlogService;
import com.example.blog.service.ICategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/blog")
@CrossOrigin("*")
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("")
    public Page<Blog> findAllBlogs(@PageableDefault(size = 4, sort = "id", direction = Sort.Direction.DESC) Pageable pageable,
                                   @RequestParam(required = false, defaultValue = "") String search
    ) {
        Page<Blog> blogs = blogService.listAllBlogs(search, pageable);
        List<Blog> blogList = blogs.toList();
        return new PageImpl<>(blogList, pageable, blogs.getTotalElements());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Blog> findBlogById(@PathVariable int id) {
        Blog blog = blogService.getBlog(id);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

    @GetMapping("/category")
    public List<Category> findAllCategories() {
        return categoryService.listAllCategory();

    }

    @GetMapping("/category/{category}")
    public ResponseEntity<Iterable<Blog>> findAllBlogByCategory(@PathVariable String category) {
        List<Blog> blogs = blogService.listBlogsByCategory(category);
        if (blogs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

    @PostMapping( value="")
    @ResponseStatus(HttpStatus.CREATED)
    public Blog createNewBlog(@RequestBody BlogDTO blog){
        Blog blog1 = new Blog();
        BeanUtils.copyProperties(blog, blog1);
        return blogService.createBlog(blog1);
    }
}
