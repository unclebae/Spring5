package com.kido.boot.demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import org.springframework.stereotype.Service;

/**
 * BookService
 */
@Service
public class BookService {


    Collection<Book> retValue = new ArrayList<>();

    public BookService() {

        retValue.add(new Book("Test1", "1111", "kido1", "kido2"));
        retValue.add(new Book("Test2", "2222", "kido3", "kido2"));
        retValue.add(new Book("Test3", "3333", "kido5", "kido2"));
    }

    public Collection<Book> findAll() {
        return retValue;
    }

    public Optional<Book> find(String isbn) {
        return retValue.stream().filter(book -> isbn.equals(book.getIsbn())).findFirst();
    }
}