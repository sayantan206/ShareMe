package com.demo.service.impl;

import com.demo.entity.Book;
import com.demo.entity.Bookmark;
import com.demo.entity.Movie;
import com.demo.service.BookmarkService;
import com.demo.service.RecentPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class RecentPostServiceImpl implements RecentPostService {

    @Autowired
    private BookmarkService<Book> bookService;

    @Autowired
    private BookmarkService<Movie> movieService;

    @Override
    public Set<Bookmark> getRecentPosts() {
        Set<Bookmark> bookmarks = new HashSet<>();
        bookmarks.addAll(bookService.listBookmark());
        bookmarks.addAll(movieService.listBookmark());

        return bookmarks;
    }
}
