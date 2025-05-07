package com.martu.java.javabookstore.exception.hamdler;

import com.martu.java.javabookstore.exception.custom.BookAlreadyExistsException;
import com.martu.java.javabookstore.exception.custom.BookDeletionException;
import com.martu.java.javabookstore.exception.custom.BookNotCreatedException;
import com.martu.java.javabookstore.exception.custom.BookNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class BookExceptionHandler {
    @ExceptionHandler(BookNotCreatedException.class)
    public ResponseEntity<Map<String, String>> handleBookNotCreated(BookNotCreatedException ex) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("error", "No se pudo crear");
        errorResponse.put("detalle", ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @ExceptionHandler(BookAlreadyExistsException.class)
    public ResponseEntity<Map<String, String>> handleBookAlreadyExist(BookAlreadyExistsException ex) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("error", "ya existe");
        errorResponse.put("detalle", ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @ExceptionHandler(BookDeletionException.class)
    public ResponseEntity<Map<String, String>> handleBookCannotRenove(BookDeletionException ex) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("error", "No se pudo eliminar");
        errorResponse.put("detalle", ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleBookNotFound(BookNotFoundException ex) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("error", "No se encontro el libro");
        errorResponse.put("detalle", ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }
}
