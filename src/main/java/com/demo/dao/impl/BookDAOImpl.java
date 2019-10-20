package com.demo.dao.impl;

import com.demo.dao.BookDAO;
import com.demo.entity.Book;
import com.demo.entity.Publisher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookDAOImpl implements BookDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Book> listBookmark() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Book order by bookCT", Book.class).list();
    }

    //todo: separate add and update method as saveOrUpdate fires unnecessary amount of queries
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

    public Publisher getPublisherByName(String name, long bookID) {
        Session session = sessionFactory.getCurrentSession();
        Query<Publisher> query = session.createQuery("select p from Publisher p join p.books b where b.id=:bookID " +
                "and p.name=:name", Publisher.class);

        query.setParameter("bookID", bookID);
        query.setParameter("name", name);

        List<Publisher> resultList = query.getResultList();
        if(resultList.isEmpty())
            return new Publisher(name);
        return resultList.get(0);
    }
}
