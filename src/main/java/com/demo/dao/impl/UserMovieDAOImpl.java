package com.demo.dao.impl;

import com.demo.dao.UserMovieDAO;
import com.demo.entity.Movie;
import com.demo.entity.UserMovie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashSet;

@Repository
public class UserMovieDAOImpl implements UserMovieDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void saveUserBookmark(UserMovie userMovie) {
        Session session = sessionFactory.getCurrentSession();
        session.save(userMovie);
    }

    @Override
    public void deleteUserBookmark(long movieID) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete from UserMovie where movie.id=:movieId");
        query.setParameter("movieId", movieID);
        query.executeUpdate();
    }

    @Override
    public LinkedHashSet<Movie> getUserMovies(long userID, boolean isSaved) {
        Session session = sessionFactory.getCurrentSession();
        Query<Movie> query = session.createQuery("from Movie m join fetch m.userMovies um where um.user.id=:userID " +
                "and um.isSaved=:isSaved", Movie.class);
        query.setParameter("userID", userID);
        query.setParameter("isSaved", isSaved);

        return new LinkedHashSet<>(query.list());
    }

    @Override
    public LinkedHashSet<UserMovie> getUserMovieEntries(long userID, long movieID) {
        Session session = sessionFactory.getCurrentSession();
        Query<UserMovie> query = session.createQuery("from UserMovie um " +
                "where um.user.id =:userID and um.movie.id=:movieID", UserMovie.class);

        query.setParameter("userID", userID);
        query.setParameter("movieID", movieID);

        LinkedHashSet<UserMovie> userMovies = new LinkedHashSet<>(query.list());
        return userMovies.isEmpty() ? null : userMovies;
    }
}
