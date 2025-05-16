package com.martu.java.javabookstore.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.RequiredArgsConstructor;

@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "books", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"title", "author"})
})
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private Integer pages;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private String content;
}
