package com.example.blog.service;

import com.example.blog.model.Blog;
import com.example.blog.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService{
    @Autowired
    private IBlogRepository blogRepository;


    @Override
    public List<Blog> listAllBlogs() {
        return blogRepository.findAll();
    }

    @Override
    public Blog getBlog(int id) {
        return blogRepository.getById(id);
    }

    @Override
    public void createBlog(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void deleteBlog(int id) {
        blogRepository.delete(getBlog(id));
    }

    @Override
    public void editBlog(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public List<Blog> searchBlog(String search) {
        return blogRepository.findBlogByNameBlogContaining(search);
    }
}
