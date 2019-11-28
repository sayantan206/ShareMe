package com.demo.entity;

import com.demo.constants.BookmarkType;
import com.demo.validation.ImageFileValidator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@MappedSuperclass
public abstract class Bookmark {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Book_ID")
    private long id;

    @Column(name = "Book_title")
    @NotNull(message = "This field cannot be empty")
    @Size(min = 1, message = "This field cannot be empty")
    private String title;

    @Column(name = "Book_description")
    private String description;

    //todo: add profileURL
    /*@Column
    private String profileURL;*/

    @Column(name = "Book_typeId")
    private BookmarkType bookmarkType;

    @Column(name = "Book_image_url")
    @ImageFileValidator()
    private String imageURL;

    public Bookmark() {
    }

    public Bookmark(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BookmarkType getBookmarkType() {
        return bookmarkType;
    }

    public void setBookmarkType(BookmarkType bookmarkType) {
        this.bookmarkType = bookmarkType;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}