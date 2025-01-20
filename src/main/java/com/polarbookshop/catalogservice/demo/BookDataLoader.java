package com.polarbookshop.catalogservice.demo;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import com.polarbookshop.catalogservice.domain.Book;
import com.polarbookshop.catalogservice.domain.BookRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Profile("testdata")
public class BookDataLoader {

    private final BookRepository bookRepository;

    public BookDataLoader (BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    @EventListener ( ApplicationReadyEvent.class)
    public void loadBookTestData(){
        bookRepository.deleteAll();
        var book1 = Book.of("1234567890", "Notherm","Lyra",9.91 );
        var book2 = Book.of("1234567891", "Notherm2","Lyra2",9.94);
        bookRepository.saveAll(List.of(book1,book2));
    }
}
