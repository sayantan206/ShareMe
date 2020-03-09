package com.demo.service.impl;

import com.demo.dao.UserMovieDAO;
import com.demo.entity.Movie;
import com.demo.entity.UserMovie;
import com.demo.service.UserMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.LinkedHashSet;

@Service
public class UserMovieServiceImpl implements UserMovieService {
    @Autowired
    private UserMovieDAO userMovieDAO;

    @Override
    @Transactional
    public void saveUserBookmark(UserMovie userMovie) {
        userMovieDAO.saveUserBookmark(userMovie);
    }

    @Override
    @Transactional
    public void deleteUserBookmark(long movieID) {
        userMovieDAO.deleteUserBookmark(movieID);
    }

    @Override
    @Transactional
    public LinkedHashSet<Movie> getUserMovies(long userID, boolean isSaved) {
        return userMovieDAO.getUserMovies(userID, isSaved);
    }

    @Override
    @Transactional
    public LinkedHashSet<UserMovie> getUserMoiveEntries(long userID, long movieID) {
        return userMovieDAO.getUserMovieEntries(userID, movieID);
    }
}
