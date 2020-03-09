package com.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "user_movie")
public class UserMovie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_movie_ID")
    private long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_movie_user_ID")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_movie_movie_ID")
    private Movie movie;

    @Column(name = "user_movie_is_saved")
    private boolean isSaved;


    public UserMovie() {
    }

    public UserMovie(User user, Movie movie, boolean isSaved) {
        this.user = user;
        this.movie = movie;
        this.isSaved = isSaved;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public boolean isSaved() {
        return isSaved;
    }

    public void setSaved(boolean saved) {
        isSaved = saved;
    }

}
