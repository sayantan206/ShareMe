package com.demo.dao.impl;

import com.demo.dao.MovieDAO;
import com.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedHashSet;
import java.util.List;

@Component
public class MovieDAOImpl implements MovieDAO {
    @Autowired
    private SessionFactory sessionFactory;

    //todo: query will join with and actor
    @Override
    public LinkedHashSet<Movie> listBookmark() {
        System.out.println("-----------------------List-----------------------");
        Session session = sessionFactory.getCurrentSession();
        return new LinkedHashSet<>(session.createQuery("select m from Movie m" +
                " order by m.movieCT desc", Movie.class).list());
    }

    public void saveBookmark(Movie movie) {
        System.out.println("-----------------------Save-----------------------");
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(movie);
    }

    @Override
    public void updateBookmark(Movie movie) {
        System.out.println("-----------------------Update-----------------------");
        Session session = sessionFactory.getCurrentSession();
        session.merge(movie);
    }

    //todo: query will join with and actor
    public Movie getBookmarkByID(long id) {
        System.out.println("-----------------------Get movie by id-----------------------");
        Session session = sessionFactory.getCurrentSession();
        LinkedHashSet<Movie> movies = new LinkedHashSet<>(session.createQuery("select m from Movie m left join fetch m.directors" +
                " left join fetch m.actors where m.id=:id", Movie.class).setParameter("id", id).list());

        return movies.iterator().hasNext() ? movies.iterator().next() : null;
    }

    public void deleteBookmark(long id) {
        System.out.println("-----------------------Delete-----------------------");
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete from Movie where id= :movieId");
        query.setParameter("movieId", id);

        query.executeUpdate();
    }

    public void deleteBookmark(Movie movie) {
        System.out.println("-----------------------Delete-----------------------");
        Session session = sessionFactory.getCurrentSession();
        session.delete(movie);
    }

    //todo: fetch all director names at once for better performance
    @Override
    public Director getDirectorByName(String name) {
        System.out.println("-----------------------Get director by name-----------------------");
        Session session = sessionFactory.getCurrentSession();
        Query<Director> query = session.createQuery("select d from Director d where" +
                " d.name=:name", Director.class);

        query.setParameter("name", name);

        List<Director> resultList = query.getResultList();
        if(resultList.isEmpty())
            return new Director(name);
        return resultList.get(0);
    }

    @Override
    public Actor getActorByName(String name) {
        System.out.println("-----------------------Get Actor by name-----------------------");
        Session session = sessionFactory.getCurrentSession();
        Query<Actor> query = session.createQuery("select a from Actor a where" +
                " a.name=:name", Actor.class);

        query.setParameter("name", name);

        List<Actor> resultList = query.getResultList();
        if(resultList.isEmpty())
            return new Actor(name);
        return resultList.get(0);
    }
}
