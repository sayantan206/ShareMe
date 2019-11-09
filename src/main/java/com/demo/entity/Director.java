package com.demo.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Director {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Director_ID")
    private long id;

    @Column(name = "Director_name")
    private String name;

    @ManyToMany(mappedBy = "directors", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Movie> movies = new HashSet<>();

    public Director() {
    }

    public Director(String name) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return id != 0L && id == ((Director) o).getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
