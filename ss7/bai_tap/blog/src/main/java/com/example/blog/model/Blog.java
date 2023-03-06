package com.example.blog.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nameBlog;
    private String contentBlog;
    private String authorBlog;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    @JsonManagedReference
    private Category category;

    public Blog() {
    }

    public Blog(Integer id, String nameBlog, String contentBlog, String authorBlog) {
        this.id = id;
        this.nameBlog = nameBlog;
        this.contentBlog = contentBlog;
        this.authorBlog = authorBlog;
    }

    public Blog(Integer id, String nameBlog, String contentBlog, String authorBlog, Category category) {
        this.id = id;
        this.nameBlog = nameBlog;
        this.contentBlog = contentBlog;
        this.authorBlog = authorBlog;
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameBlog() {
        return nameBlog;
    }

    public void setNameBlog(String nameBlog) {
        this.nameBlog = nameBlog;
    }

    public String getContentBlog() {
        return contentBlog;
    }

    public void setContentBlog(String contentBlog) {
        this.contentBlog = contentBlog;
    }

    public String getAuthorBlog() {
        return authorBlog;
    }

    public void setAuthorBlog(String authorBlog) {
        this.authorBlog = authorBlog;
    }
}
