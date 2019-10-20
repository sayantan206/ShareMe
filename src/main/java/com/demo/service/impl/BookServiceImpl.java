package com.demo.service.impl;

import com.demo.dao.BookDAO;
import com.demo.entity.Book;
import com.demo.entity.Publisher;
import com.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDAO bookDAO;

    @Transactional
    public List<Book> listBookmark() {
        return bookDAO.listBookmark();
    }

    @Transactional
    public void addOrUpdateBookmark(Book book) {
        bookDAO.addOrUpdateBookmark(book);
    }

    @Transactional
    public Book getBookmarkByID(long id) {
        return bookDAO.getBookmarkByID(id);
    }

    @Transactional
    public void deleteBookmark(long id) {
        bookDAO.deleteBookmark(id);
    }

    @Transactional
    public void deleteBookmark(Book book) {
        bookDAO.deleteBookmark(book);
    }

    @Transactional
    public Publisher getPublisherByName(String name, long bookID) {
        return bookDAO.getPublisherByName(name, bookID);
    }
}
