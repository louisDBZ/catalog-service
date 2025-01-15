package com.polarbookshop.catalogservice.domain;

import jakarta.validation.constraints.*;

public record Book(
        @NotBlank(message = "The book isbn must be defined.")
                @Pattern(
                        regexp= "^[0-9]{10}",// j'ai simplifié la regex
                        message="the ISBN format must be valid"
                )
        String isbn,
        @NotBlank(message = "The book title must be defined.")
        String title,
        @NotBlank(message = "The author  must be defined.")
        String author,
        @NotNull(message = "The price must be defined.")
        @Positive(message = "the book price must be greater than 0")
        Double price
) { }