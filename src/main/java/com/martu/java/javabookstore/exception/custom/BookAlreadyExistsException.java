package com.martu.java.javabookstore.exception.custom;

public class BookAlreadyExistsException extends RuntimeException {
    public BookAlreadyExistsException(String message){
        super(message);
    }
}
