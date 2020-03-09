package com.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "user_book")
public class UserBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_book_ID")
    private long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_book_user_ID")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_book_book_ID")
    private Book book;

    @Column(name = "user_book_is_saved")
    private boolean isSaved;


    public UserBook() {
    }

    public UserBook(User user, Book book, boolean isSaved) {
        this.user = user;
        this.book = book;
        this.isSaved = isSaved;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public boolean isSaved() {
        return isSaved;
    }

    public void setSaved(boolean saved) {
        isSaved = saved;
    }

}
