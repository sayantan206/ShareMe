package com.demo.service;

import com.demo.entity.Movie;
import com.demo.entity.UserMovie;

import java.util.LinkedHashSet;

public interface UserMovieService {
    void saveUserBookmark(UserMovie userMovie);

    void deleteUserBookmark(long movieID);

    LinkedHashSet<Movie> getUserMovies(long userID, boolean isSaved);

    LinkedHashSet<UserMovie> getUserMoiveEntries(long userID, long movieID);
}
