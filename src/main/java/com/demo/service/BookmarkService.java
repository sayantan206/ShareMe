package com.demo.service;

import com.demo.entity.Bookmark;

import java.util.List;

public interface BookmarkService<T extends Bookmark> {
    List<T> listBookmark();

    void addOrUpdateBookmark(T t);

    T getBookmarkByID(long id);

    void deleteBookmark(long id);

    void deleteBookmark(T t);
}