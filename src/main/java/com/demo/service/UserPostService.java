package com.demo.service;

import com.demo.entity.Bookmark;
import com.demo.entity.User;

import java.util.Set;

public interface UserPostService {
    Set<Bookmark> getUserPosts(User user);
    Set<Bookmark> getUserSavedPosts(User user);
    Set<Bookmark> getUserArchivedPosts();
    Set<Bookmark> getUserFavouritePosts();
}
