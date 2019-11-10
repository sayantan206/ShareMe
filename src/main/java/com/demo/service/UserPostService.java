package com.demo.service;

import com.demo.entity.Bookmark;

import java.util.Set;

public interface UserPostService {
    Set<Bookmark> getUserPosts();
    Set<Bookmark> getUserArchivedPosts();
    Set<Bookmark> getUserFavouritePosts();
}
