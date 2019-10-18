package com.demo.dao;

import com.demo.entity.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookDAOImpl implements BookmarkDAO<Book> {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Book> listBookmark() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Book order by bookCT", Book.class).list();
    }

    public void addOrUpdateBookmark(Book book) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(book);
    }

    public Book getBookmarkByID(long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Book.class, id);
    }

    public void deleteBookmark(long id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete from Book where id= :bookId");
        query.setParameter("bookId", id);

        query.executeUpdate();
    }

    public void deleteBookmark(Book book) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(book);
    }
}
