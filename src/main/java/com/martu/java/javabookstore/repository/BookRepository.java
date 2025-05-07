package com.martu.java.javabookstore.repository;

import com.martu.java.javabookstore.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, String> {
    BookEntity save(BookEntity bookEntity);

    Optional<BookEntity> findByTitle(String title);
    List<BookEntity> findByAuthor(String author);
}
