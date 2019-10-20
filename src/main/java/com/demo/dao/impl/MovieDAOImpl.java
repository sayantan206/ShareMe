package com.demo.dao.impl;

import com.demo.dao.MovieDAO;
import com.demo.entity.Book;
import com.demo.entity.Movie;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class MovieDAOImpl implements MovieDAO {

    @Override
    public List<Movie> listBookmark() {
        return null;
    }

    public void addOrUpdateBookmark(Movie movie) {

    }

    public Book getBookmarkByID(long id) {
        return null;
    }

    public void deleteBookmark(long id) {

    }

    public void deleteBookmark(Movie movie) {

    }
}
