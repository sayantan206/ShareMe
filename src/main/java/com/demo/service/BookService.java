package com.demo.service;

import com.demo.entity.Book;
import com.demo.entity.Publisher;

public interface BookService extends BookmarkService<Book> {
    Publisher getPublisherByName(String name, long bookID);
}
