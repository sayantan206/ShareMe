package com.demo.dao;

import com.demo.entity.Bookmark;

import java.util.LinkedHashSet;

public interface BookmarkDAO<T extends Bookmark> {
    LinkedHashSet<T> listBookmark();

    void saveBookmark(T t);

    void updateBookmark(T t);

    T getBookmarkByID(long id);

    void deleteBookmark(long id);

    void deleteBookmark(T t);
}
