package com.demo.dao;

import com.demo.entity.Book;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class MovieDAOImpl implements BookmarkDAO<Book> {
    public List<Book> listBookmark() {
        return null;
    }

    public void addOrUpdateBookmark(Book book) {

    }

    public Book getBookmarkByID(long id) {
        return null;
    }

    public void deleteBookmark(long id) {

    }

    public void deleteBookmark(Book book) {

    }
}
