package com.demo.entity;

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
}