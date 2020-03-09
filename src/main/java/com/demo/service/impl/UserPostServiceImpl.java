package com.demo.service.impl;

import com.demo.dao.BookmarkDAO;
import com.demo.dao.UserBookDAO;
import com.demo.dao.UserMovieDAO;
import com.demo.entity.Book;
import com.demo.entity.Bookmark;
import com.demo.entity.Movie;
import com.demo.entity.User;
import com.demo.service.UserPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class UserPostServiceImpl implements UserPostService {

    //todo: add user filters to view user specific bookmarks

    @Autowired
    private BookmarkDAO<Book> bookmarkDAO;

    @Autowired
    private BookmarkDAO<Movie> movieDAO;

    @Autowired
    private UserBookDAO userBookDAO;

    @Autowired
    private UserMovieDAO userMovieDAO;

    @Override
    @Transactional
    public Set<Bookmark> getUserPosts(User user) {
        Set<Bookmark> bookmarks = new LinkedHashSet<>();
        bookmarks.addAll(userBookDAO.getUserBooks(user.getId(), false));
        bookmarks.addAll(userMovieDAO.getUserMovies(user.getId(), false));

        return bookmarks;
    }

    @Override
    @Transactional
    public Set<Bookmark> getUserSavedPosts(User user) {
        Set<Bookmark> bookmarks = new LinkedHashSet<>();
        bookmarks.addAll(userBookDAO.getUserBooks(user.getId(), true));
        bookmarks.addAll(userMovieDAO.getUserMovies(user.getId(), true));

        return bookmarks;
    }

    @Override
    @Transactional
    public Set<Bookmark> getUserArchivedPosts() {
        Set<Bookmark> bookmarks = new HashSet<>();
        bookmarks.addAll(bookmarkDAO.listBookmark());
        bookmarks.addAll(movieDAO.listBookmark());

        return bookmarks;
    }

    @Override
    @Transactional
    public Set<Bookmark> getUserFavouritePosts() {
        Set<Bookmark> bookmarks = new HashSet<>();
        bookmarks.addAll(bookmarkDAO.listBookmark());
        bookmarks.addAll(movieDAO.listBookmark());

        return bookmarks;
    }
}
