package com.demo.dao.impl;

import com.demo.dao.MovieDAO;
import com.demo.entity.Book;
import com.demo.entity.Movie;
import org.springframework.stereotype.Component;

import java.util.LinkedHashSet;

@Component
public class MovieDAOImpl implements MovieDAO {

    @Override
    public LinkedHashSet<Book> listBookmark() {
        return null;
    }

    public void saveBookmark(Movie movie) {

    }

    @Override
    public void updateBookmark(Movie movie) {

    }

    public Book getBookmarkByID(long id) {
        return null;
    }

    public void deleteBookmark(long id) {

    }

    public void deleteBookmark(Movie movie) {

    }
}
