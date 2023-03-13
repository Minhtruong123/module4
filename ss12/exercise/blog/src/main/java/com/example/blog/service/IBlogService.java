package com.example.blog.service;

import com.example.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IBlogService {
    Page<Blog> listAllBlogs(String search, Pageable pageable);

    Blog getBlog(int id);

    List<Blog> listBlogsByCategory(String category);
}
