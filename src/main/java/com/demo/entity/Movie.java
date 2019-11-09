package com.demo.entity;


import com.demo.constants.MovieGenre;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "Movie_ID")),
        @AttributeOverride(name = "title", column = @Column(name = "Movie_Title")),
        @AttributeOverride(name = "description", column = @Column(name = "Movie_description"))
})
public class Movie extends Bookmark {

    @Column(name = "Movie_release_year")
    @Pattern(regexp = "^19[5-9]\\d|20[0-4]\\d|2050$", message = "Invalid input")
    @NotEmpty(message = "This field cannot be empty")
    private String releaseYear;

    @Column(name = "Movie_imdb_rating")
    @DecimalMin(value = "0.0", inclusive = false, message = "Incorrect input")
    @DecimalMax(value = "10.0", inclusive = true, message = "Incorrect input")
    private float imdbRating;

    @Column(name = "Movie_CT")
    private String movieCT;

    @Column(name = "Movie_genre")
    private String genre;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "Movie_director",
            joinColumns = @JoinColumn(name = "Movie_director_movie_id"),
            inverseJoinColumns = @JoinColumn(name = "Movie_director_director_id")
    )
    @NotEmpty(message = "This field cannot be empty")
    private Set<Director> directors = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "Movie_actor",
            joinColumns = @JoinColumn(name = "Movie_actor_movie_id"),
            inverseJoinColumns = @JoinColumn(name = "Movie_actor_actor_id")
    )
    @NotEmpty(message = "This field cannot be empty")
    private Set<Actor> actors = new HashSet<>();

    public Movie() {
        //constructor called by spring container
    }

    public Movie(String title, String description, String releaseYear, float imdbRating, String genre) {
        super(title, description);
        this.releaseYear = releaseYear;
        this.imdbRating = imdbRating;
        this.genre = genre;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }

    public float getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(float imdbRating) {
        this.imdbRating = imdbRating;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getMovieCT() {
        return movieCT;
    }

    public void setMovieCT(String movieCT) {
        this.movieCT = movieCT;
    }

    public List<MovieGenre> getGenreOptions() {
        return Arrays.asList(MovieGenre.values());
    }

    public Set<Director> getDirectors() {
        return directors;
    }

    public void setDirectors(Set<Director> directors) {
        this.directors = directors;
        directors.forEach(d -> d.addMovie(this));
    }

    public void addDirector(Director director) {
        this.getDirectors().add(director);
        director.getMovies().add(this);
    }

    public void removeDirector(Director director) {
        this.getDirectors().remove(director);
        director.getMovies().remove(this);
    }

    public Set<Actor> getActors() {
        return actors;
    }

    public void setActors(Set<Actor> actors) {
        this.actors = actors;
        actors.forEach(a -> a.addMovie(this));
    }

    public void addActor(Actor actor) {
        this.getActors().add(actor);
        actor.getMovies().add(this);
    }

    public void removeActor(Actor actor) {
        this.getActors().remove(actor);
        actor.getMovies().remove(this);
    }

    @Override
    public String toString() {
        return super.toString() + "Movie{" +
                "releaseYear='" + releaseYear + '\'' +
                ", imdbRating='" + imdbRating + '\'' +
                ", genre='" + genre + '\'' +
                "} ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Movie)) return false;
        return super.getId() != 0L && super.getId() == ((Movie) o).getId();
    }

    @Override
    public int hashCode() {
        return 31;
    }
}
