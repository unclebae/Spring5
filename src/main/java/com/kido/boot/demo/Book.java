package com.kido.boot.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Book
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Book {


    private String title;
    private String isbn;
    private Collection<String> authors = new ArrayList<>();


    public Book(String title, String isbn, String... authors) {
        this.title = title;
        this.isbn = isbn;
        this.authors.addAll(Arrays.asList(authors));

    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getAuthors() {
        return String.join(",", authors);
    }
}