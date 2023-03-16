package com.example.blog.service;

import com.example.blog.model.Blog;
import com.example.blog.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService{
    @Autowired
    private IBlogRepository blogRepository;


    @Override
    public Page<Blog> listAllBlogs(String search, Pageable pageable) {
        return blogRepository.findBlogByNameBlogContaining(search, pageable);
    }

    @Override
    public Blog getBlog(int id) {
        return blogRepository.findById(id).get();
    }

    @Override
    public List<Blog> listBlogsByCategory(String category) {
        return blogRepository.findBlogByCategoryNameCategory(category);
    }

    @Override
    public Blog createBlog(Blog blog) {
        return blogRepository.save(blog);
    }
}
