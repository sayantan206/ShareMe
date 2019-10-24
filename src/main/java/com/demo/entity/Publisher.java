package com.demo.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Publisher_ID")
    private long id;

    @Column(name = "Publisher_name")
    private String name;

    @ManyToMany(mappedBy = "publishers", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Book> books;

    public Publisher() {
        //method called by spring container
    }

    public Publisher(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public void addBooks(List<Book> bookList) {
        if (books == null)
            books = new HashSet<>();
        books.addAll(bookList);
    }

    public void removeBooks(Set<Book> bookList) {
        if (bookList != null)
            books.removeAll(bookList);
    }

    @Override
    public String toString() {
        return name;
    }
}
