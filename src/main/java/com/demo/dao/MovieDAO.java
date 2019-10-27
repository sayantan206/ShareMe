package com.demo.dao;

import com.demo.entity.Actor;
import com.demo.entity.Director;
import com.demo.entity.Movie;

public interface MovieDAO extends BookmarkDAO<Movie> {
    Director getDirectorByName(String name);
    Actor getActorByName(String name);
}
