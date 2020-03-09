package com.demo.service.impl;

import com.demo.dao.BookDAO;
import com.demo.dao.UserBookDAO;
import com.demo.entity.Author;
import com.demo.entity.Book;
import com.demo.entity.Publisher;
import com.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.LinkedHashSet;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDAO bookDAO;

    @Autowired
    private UserBookDAO userBookDAO;

    @Transactional
    public LinkedHashSet<Book> listBookmark() {
        return bookDAO.listBookmark();
    }

    @Transactional
    public void saveBookmark(Book book) {
        Book savedBook = bookDAO.getBookmarkByID(book.getId());
        if(savedBook == null)
            bookDAO.saveBookmark(book);
        else
            bookDAO.updateBookmark(book);
    }

    @Transactional
    public Book getBookmarkByID(long id) {
        return bookDAO.getBookmarkByID(id);
    }

    @Transactional
    public void deleteBookmark(long id) {
        //remove all the user-book entries of the specified book
        userBookDAO.deleteUserBookmark(id);
        //delete the book entry
        bookDAO.deleteBookmark(id);
    }

    @Transactional
    public void deleteBookmark(Book book) {
        bookDAO.deleteBookmark(book);
    }

    @Transactional
    public Publisher getPublisherByName(String name) {
        return bookDAO.getPublisherByName(name);
    }

    @Transactional
    public Author getAuthorByName(String name) {
        return bookDAO.getAuthorByName(name);
    }
}
