package com.demo.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Actor_ID")
    private long id;

    @Column(name = "Actor_name")
    private String name;

    @ManyToMany(mappedBy = "actors", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Movie> movies = new HashSet<>();

    public Actor() {
    }

    public Actor(String name) {
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

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }

    public void addMovie(Movie movie){
        this.movies.add(movie);
    }

    public void removeMovie(Movie movie){
        this.movies.remove(movie);
    }

    @Override
    public String toString() {
        return name;
    }
}
