package com.example.borrow_book.service;

import com.example.borrow_book.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IBookService {
    List<Book> listAllBook();

    Book findBookById(int id);
}
