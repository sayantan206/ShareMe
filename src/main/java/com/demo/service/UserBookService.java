package com.demo.service;

import com.demo.entity.Book;
import com.demo.entity.UserBook;


import java.util.LinkedHashSet;

public interface UserBookService {
    void saveUserBookmark(UserBook userBook);
    void deleteUserBookmark(long bookID);
    LinkedHashSet<Book> getUserBooks(long userID, boolean isSaved);
    LinkedHashSet<UserBook> getUserBookEntries(long userID, long bookID);
}
