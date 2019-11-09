package com.demo.service;

import com.demo.entity.Actor;
import com.demo.entity.Director;
import com.demo.entity.Movie;

public interface MovieService extends BookmarkService<Movie> {
    Director getDirectorByName(String name);
    Actor getActorByName(String name);
}
