package com.polarbookshop.catalogservice.web;

import java.util.Set;

import com.polarbookshop.catalogservice.domain.BookService;
import jakarta.validation.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.polarbookshop.catalogservice.domain.BookAlreadyExistsException;
import com.polarbookshop.catalogservice.domain.BookNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.*;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.*;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
//import static org.springframework.test.web.servlet.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BookController.class)
public class BookControllerMvcTests {

    @Autowired
    //@SuppressWarnings("")
    private MockMvc mockMvc;

    @MockBean
    private BookService bookService;

    @Test
    void whenGetBooknotexistingthenshouldreturn404() throws Exception {
        String isbn = "73737373735";
        given(bookService.viewBookDetails(isbn)).willThrow(BookNotFoundException.class);
        mockMvc.perform(get("/books/"+ isbn)).andExpect(status().isNotFound());
    }

}
