package com.martu.java.javabookstore.service.impl;

import com.martu.java.javabookstore.dto.book.BookDto;
import com.martu.java.javabookstore.entity.BookEntity;
import com.martu.java.javabookstore.exception.custom.BookAlreadyExistsException;
import com.martu.java.javabookstore.exception.custom.BookDeletionException;
import com.martu.java.javabookstore.exception.custom.BookNotCreatedException;
import com.martu.java.javabookstore.exception.custom.BookNotFoundException;
import com.martu.java.javabookstore.repository.BookRepository;
import com.martu.java.javabookstore.service.BookService;
import lombok.RequiredArgsConstructor;
import org.hibernate.exception.ConstraintViolationException;
import org.modelmapper.ModelMapper;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository repository;
    private final ModelMapper mapper;


    @Override
    public BookDto setBook(BookDto book) {

        try{
            BookEntity bookEntity = repository.save(mapper.map(book, BookEntity.class));
            return mapper.map(bookEntity, BookDto.class);

        } catch (DataIntegrityViolationException ex) {
            if (ex.getCause() instanceof ConstraintViolationException) {
                throw new BookAlreadyExistsException("Error: el libro con el ID ya existe.");
            }
            throw new BookNotCreatedException("Error al crear el libro.");
        }
    }

    @Override
    public void deleteBook(String id) {
        try{
            repository.deleteById(id);
        }catch (DataIntegrityViolationException e){
            throw new BookDeletionException("No se puede eliminar el registro del libro porque no se encuentra");
        }
    }

    @Override
    public BookDto getBook(String title) {
        BookEntity entity = repository.findByTitle(title)
                .orElseThrow(() -> new BookNotFoundException("No se encontró el libro con el título: " + title));
        return mapper.map(entity, BookDto.class);
    }

    @Override
    public List<BookDto> getBooks(String author) {
        List<BookEntity> bookEntities = repository.findByAuthor(author);
        if (bookEntities.isEmpty()) {
            throw new BookNotFoundException("No se encontraron libros del autor: " + author);
        }
        return bookEntities.stream()
                .map(bookEntity -> mapper.map(bookEntity, BookDto.class))
                .toList();
    }
}
