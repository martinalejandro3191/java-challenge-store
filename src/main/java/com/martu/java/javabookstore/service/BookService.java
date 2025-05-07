package com.martu.java.javabookstore.service;

import com.martu.java.javabookstore.dto.book.BookDto;

import java.util.List;

public interface BookService {
    BookDto setBook(BookDto book);

    void deleteBook(String id);

    BookDto getBook(String title);

    List<BookDto> getBooks(String author);
}
