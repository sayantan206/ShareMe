package com.demo.service.impl;

import com.demo.dao.MovieDAO;
import com.demo.entity.Actor;
import com.demo.entity.Director;
import com.demo.entity.Movie;
import com.demo.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.LinkedHashSet;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    private MovieDAO movieDAO;

    @Transactional
    public LinkedHashSet<Movie> listBookmark() {
        return movieDAO.listBookmark();
    }

    @Transactional
    public void saveBookmark(Movie movie) {
        Movie savedMovie = movieDAO.getBookmarkByID(movie.getId());
        if (savedMovie == null)
            movieDAO.saveBookmark(movie);
        else
            movieDAO.updateBookmark(movie);
    }


    @Transactional
    public Movie getBookmarkByID(long id) {
        return movieDAO.getBookmarkByID(id);
    }

    @Transactional
    public void deleteBookmark(long id) {
        movieDAO.deleteBookmark(id);
    }

    @Transactional
    public void deleteBookmark(Movie movie) {
        movieDAO.deleteBookmark(movie);
    }

    @Override
    @Transactional
    public Director getDirectorByName(String name) {
        return movieDAO.getDirectorByName(name);
    }

    @Override
    @Transactional
    public Actor getActorByName(String name) {
        return movieDAO.getActorByName(name);
    }
}