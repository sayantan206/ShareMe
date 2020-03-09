package com.demo.service.impl;

import com.demo.dao.UserBookDAO;
import com.demo.entity.Book;
import com.demo.entity.UserBook;
import com.demo.service.UserBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.LinkedHashSet;

@Service
public class UserBookServiceImpl implements UserBookService {
    @Autowired
    private UserBookDAO userBookDAO;

    @Override
    @Transactional
    public void saveUserBookmark(UserBook userBook) {
        userBookDAO.saveUserBookmark(userBook);
    }

    @Override
    @Transactional
    public void deleteUserBookmark(long bookID) {
        userBookDAO.deleteUserBookmark(bookID);
    }

    @Override
    @Transactional
    public LinkedHashSet<Book> getUserBooks(long userID, boolean isSaved) {
        return userBookDAO.getUserBooks(userID, isSaved);
    }

    @Override
    @Transactional
    public LinkedHashSet<UserBook> getUserBookEntries(long userID, long bookID) {
        return userBookDAO.getUserBookEntries(userID, bookID);
    }
}
