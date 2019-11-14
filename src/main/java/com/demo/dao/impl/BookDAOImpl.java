package com.demo.dao.impl;

import com.demo.dao.BookDAO;
import com.demo.entity.Author;
import com.demo.entity.Book;
import com.demo.entity.Publisher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedHashSet;
import java.util.List;

@Component
public class BookDAOImpl implements BookDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public LinkedHashSet<Book> listBookmark() {
        System.out.println("-----------------------List-----------------------");
        Session session = sessionFactory.getCurrentSession();
        return new LinkedHashSet<>(session.createQuery("select b from Book b " +
                "order by b.bookCT desc", Book.class).list());
    }

    public void saveBookmark(Book book) {
        System.out.println("-----------------------Save-----------------------");
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(book);
    }

    @Override
    public void updateBookmark(Book book) {
        System.out.println("-----------------------Update-----------------------");
        Session session = sessionFactory.getCurrentSession();
        session.merge(book);
    }

    public Book getBookmarkByID(long id) {
        System.out.println("-----------------------Get book by id-----------------------");
        Session session = sessionFactory.getCurrentSession();
        LinkedHashSet<Book> books = new LinkedHashSet<>(session.createQuery("select b from Book b left join fetch b.publishers" +
                " left join fetch b.authors where b.id=:id", Book.class).setParameter("id", id).list());

        return books.iterator().hasNext() ? books.iterator().next() : null;
    }

    public void deleteBookmark(long id) {
        System.out.println("-----------------------Delete-----------------------");
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete from Book where id= :bookId");
        query.setParameter("bookId", id);

        query.executeUpdate();
    }

    public void deleteBookmark(Book book) {
        System.out.println("-----------------------Delete-----------------------");
        Session session = sessionFactory.getCurrentSession();
        session.delete(book);
    }

    //todo: fetch all the publishers at once for performance improvement
    public Publisher getPublisherByName(String name) {
        System.out.println("-----------------------Get pub by name-----------------------");
        Session session = sessionFactory.getCurrentSession();
        Query<Publisher> query = session.createQuery("select p from Publisher p where" +
                " p.name=:name", Publisher.class);

        query.setParameter("name", name);

        List<Publisher> resultList = query.getResultList();
        if(resultList.isEmpty())
            return new Publisher(name);
        return resultList.get(0);
    }

    @Override
    public Author getAuthorByName(String name) {
        System.out.println("-----------------------Get author by name-----------------------");
        Session session = sessionFactory.getCurrentSession();
        Query<Author> query = session.createQuery("select a from Author a where" +
                " a.name=:name", Author.class);

        query.setParameter("name", name);

        List<Author> resultList = query.getResultList();
        if(resultList.isEmpty())
            return new Author(name);
        return resultList.get(0);
    }
}
