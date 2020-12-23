package com.goodreads.goodreads.service;

import com.goodreads.goodreads.domain.Book;

import java.util.List;

public interface BookService {

    List<Book> findAllBooks();
    List<Book> getLast4Book();
    List<Book> top5Book();
    Book findById(Long aLong);
}
