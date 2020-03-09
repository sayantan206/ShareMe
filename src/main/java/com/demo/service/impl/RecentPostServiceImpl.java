package com.demo.service.impl;

import com.demo.dao.BookmarkDAO;
import com.demo.entity.Book;
import com.demo.entity.Bookmark;
import com.demo.entity.Movie;
import com.demo.service.RecentPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Service
public class RecentPostServiceImpl implements RecentPostService {

    @Autowired
    private BookmarkDAO<Book> bookmarkDAO;

    @Autowired
    private BookmarkDAO<Movie> movieDAO;

    @Override
    @Transactional
    public Set<Bookmark> getRecentPosts() {
        Set<Bookmark> bookmarks = new HashSet<>();
        bookmarks.addAll(bookmarkDAO.listBookmark());
        bookmarks.addAll(movieDAO.listBookmark());

        return bookmarks;
    }
}
