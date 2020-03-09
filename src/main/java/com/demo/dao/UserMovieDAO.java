package com.demo.dao;

import com.demo.entity.Movie;
import com.demo.entity.UserMovie;

import java.util.LinkedHashSet;

public interface UserMovieDAO {
    void saveUserBookmark(UserMovie userMovie);

    void deleteUserBookmark(long movieID);

    LinkedHashSet<Movie> getUserMovies(long userID, boolean isSaved);

    LinkedHashSet<UserMovie> getUserMovieEntries(long userID, long MovieID);
}
