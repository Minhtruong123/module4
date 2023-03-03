package com.example.blog.service;

import com.example.blog.model.Blog;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IBlogService {
    List<Blog> listAllBlogs();

    Blog getBlog(int id);

    void createBlog(Blog blog);

    void deleteBlog(int id);

    void editBlog(Blog blog);

    List<Blog> searchBlog(String search);
}
