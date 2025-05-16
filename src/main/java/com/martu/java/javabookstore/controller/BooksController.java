package com.martu.java.javabookstore.controller;

import com.martu.java.javabookstore.dto.book.BookDto;
import com.martu.java.javabookstore.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/book")
public class BooksController {
    private final BookService service;

    @PostMapping
    @PreAuthorize("hasAnyAuthority('SCOPE_libros.write', 'ROLE_ADMIN')")
    public ResponseEntity<BookDto> setBook(@Valid  @RequestBody BookDto book){
        BookDto savedBook = service.setBook(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBook);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteBook(@Valid @PathVariable String id){
        service.deleteBook(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("title/{title}")
    public ResponseEntity<BookDto> getBook(@Valid @PathVariable String title){
        BookDto bookDto = service.getBook(title);
        return ResponseEntity.status(HttpStatus.OK).body(bookDto);
    }

    @GetMapping("author/{author}")
    public ResponseEntity<List<BookDto>> getBooks(@Valid @PathVariable String author){
        List<BookDto> books = service.getBooks(author);
        return ResponseEntity.status(HttpStatus.OK).body(books);
    }
}
