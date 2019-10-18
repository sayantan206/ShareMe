package com.demo.service;

import com.demo.entity.Book;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class MovieServiceImpl implements BookmarkService<Book> {

    @Transactional
    public List<Book> listBookmark() {
        return null;
    }

    @Transactional
    public void addOrUpdateBookmark(Book book) {

    }


    @Transactional
    public Book getBookmarkByID(long id) {
        return null;
    }

    @Transactional
    public void deleteBookmark(long id) {

    }

    @Transactional
    public void deleteBookmark(Book book) {

    }
}