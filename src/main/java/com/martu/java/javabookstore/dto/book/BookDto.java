package com.martu.java.javabookstore.dto.book;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;


@Getter
@AllArgsConstructor
@RequiredArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class BookDto {

    @NotBlank(message = "El titulo del Libro no puede estar sin completar")
    private String title;

    @NotBlank(message = "El nombre del Autor no puede estar sin completar")
    private String author;

    @NotNull(message = "El numero de pagonas no puede estar sin completar")
    private Integer pages;

    @NotBlank(message = "La categoria del Libro no puede estar sin completar")
    private String category;

    @NotBlank(message = "El contenido del libro no puede estar sin completar")
    private String content;
}
