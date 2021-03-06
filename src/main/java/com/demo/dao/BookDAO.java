package com.demo.dao;

import com.demo.entity.Author;
import com.demo.entity.Book;
import com.demo.entity.Publisher;

public interface BookDAO extends BookmarkDAO<Book>{
    Publisher getPublisherByName(String name);
    Author getAuthorByName(String name);
}
