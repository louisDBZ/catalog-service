package com.polarbookshop.catalogservice.domain;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import org.springframework.data.annotation.*;

import java.time.Instant;


public record Book(

        @Id
        Long id,

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
        Double price,

        @CreatedDate
        Instant createdDate,

        @LastModifiedDate
        Instant lastModifiedDate,

        @Version
        int version

) {

    public static Book of(String isbn, String title, String author, Double price) {
        return new Book(null, isbn, title, author, price, null, null, 0);
    };
}
