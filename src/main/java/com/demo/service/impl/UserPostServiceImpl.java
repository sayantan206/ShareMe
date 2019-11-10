package com.demo.service.impl;

import com.demo.entity.Book;
import com.demo.entity.Bookmark;
import com.demo.entity.Movie;
import com.demo.service.BookmarkService;
import com.demo.service.UserPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserPostServiceImpl implements UserPostService {

    //todo: add user filters to view user specific bookmarks

    @Autowired
    private BookmarkService<Book> bookService;

    @Autowired
    private BookmarkService<Movie> movieService;

    @Override
    public Set<Bookmark> getUserPosts() {
        Set<Bookmark> bookmarks = new HashSet<>();
        bookmarks.addAll(bookService.listBookmark());
        bookmarks.addAll(movieService.listBookmark());

        return bookmarks;
    }

    @Override
    public Set<Bookmark> getUserArchivedPosts() {
        Set<Bookmark> bookmarks = new HashSet<>();
        bookmarks.addAll(bookService.listBookmark());
        bookmarks.addAll(movieService.listBookmark());

        return bookmarks;
    }

    @Override
    public Set<Bookmark> getUserFavouritePosts() {
        Set<Bookmark> bookmarks = new HashSet<>();
        bookmarks.addAll(bookService.listBookmark());
        bookmarks.addAll(movieService.listBookmark());

        return bookmarks;
    }
}
