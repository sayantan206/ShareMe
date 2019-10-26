package com.demo.service;

import com.demo.entity.Book;
import com.demo.entity.Bookmark;

import java.util.LinkedHashSet;

public interface BookmarkService<T extends Bookmark> {
    LinkedHashSet<Book> listBookmark();

    void saveCustomer(T t);

    T getBookmarkByID(long id);

    void deleteBookmark(long id);

    void deleteBookmark(T t);
}