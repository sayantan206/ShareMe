package com.demo.entity;

import javax.persistence.*;

@Entity
public class Publisher {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Author_ID")
    private long id;

    @Column(name = "Author_name")
    private String name;

    public Publisher() {
        //method called by spring container
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

    @Override
    public String toString() {
        return "Publisher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
