package com.demo.dao;

import com.demo.entity.Book;
import com.demo.entity.Bookmark;

import java.util.List;

public interface BookmarkDAO<T extends Bookmark> {
    List<Book> listBookmark();
    void addOrUpdateBookmark(T t);
    Book getBookmarkByID(long id);
    void deleteBookmark(long id);
    void deleteBookmark(T t);
}
