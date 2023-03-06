package com.example.blog.service;

import com.example.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IBlogService {
    List<Blog> listAllBlogs();

    Blog getBlog(int id);

    void createBlog(Blog blog);

    void deleteBlog(int id);

    void editBlog(Blog blog);

    Page<Blog> searchBlog(String search,Pageable pageable);
}
