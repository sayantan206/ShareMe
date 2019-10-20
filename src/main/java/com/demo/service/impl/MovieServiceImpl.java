package com.demo.service.impl;

import com.demo.entity.Movie;
import com.demo.service.BookmarkService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class MovieServiceImpl implements BookmarkService<Movie> {

    @Transactional
    public List<Movie> listBookmark() {
        return null;
    }

    @Transactional
    public void addOrUpdateBookmark(Movie movie) {

    }


    @Transactional
    public Movie getBookmarkByID(long id) {
        return null;
    }

    @Transactional
    public void deleteBookmark(long id) {

    }

    @Transactional
    public void deleteBookmark(Movie movie) {

    }
}