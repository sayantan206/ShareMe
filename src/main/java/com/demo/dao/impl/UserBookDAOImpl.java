package com.demo.dao.impl;

import com.demo.dao.UserBookDAO;
import com.demo.entity.Book;
import com.demo.entity.UserBook;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashSet;

@Repository
public class UserBookDAOImpl implements UserBookDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void saveUserBookmark(UserBook userBook) {
        Session session = sessionFactory.getCurrentSession();
        session.save(userBook);
    }

    @Override
    public void deleteUserBookmark(long bookID) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete from UserBook where book.id=:bookId");
        query.setParameter("bookId", bookID);
        query.executeUpdate();
    }

    @Override
    public LinkedHashSet<Book> getUserBooks(long userID, boolean isSaved) {
        Session session = sessionFactory.getCurrentSession();
        Query<Book> query = session.createQuery("from Book b join fetch b.userBooks ub where ub.user.id=:userID " +
                "and ub.isSaved=:isSaved", Book.class);
        query.setParameter("userID", userID);
        query.setParameter("isSaved", isSaved);

        return new LinkedHashSet<>(query.list());
    }

    @Override
    public LinkedHashSet<UserBook> getUserBookEntries(long userID, long bookID) {
        Session session = sessionFactory.getCurrentSession();
        Query<UserBook> query = session.createQuery("from UserBook ub " +
                "where ub.user.id =:userID and ub.book.id=:bookID", UserBook.class);

        query.setParameter("userID", userID);
        query.setParameter("bookID", bookID);

        LinkedHashSet<UserBook> userBooks = new LinkedHashSet<>(query.list());
        return userBooks.isEmpty() ? null : userBooks;
    }
}
