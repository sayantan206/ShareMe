package com.demo.service;

import com.demo.dao.BookmarkDAO;
import com.demo.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BookServiceImpl implements BookmarkService<Book> {
    @Autowired
    @Qualifier("bookDAOImpl")
    private BookmarkDAO<Book> bookmarkDAO;

    @Transactional
    public List<Book> listBookmark() {
        return bookmarkDAO.listBookmark();
    }

    @Transactional
    public void addOrUpdateBookmark(Book book) {
        bookmarkDAO.addOrUpdateBookmark(book);
    }

    @Transactional
    public Book getBookmarkByID(long id) {
        return bookmarkDAO.getBookmarkByID(id);
    }

    @Transactional
    public void deleteBookmark(long id) {
        bookmarkDAO.deleteBookmark(id);
    }

    @Transactional
    public void deleteBookmark(Book book) {
        bookmarkDAO.deleteBookmark(book);
    }
}
