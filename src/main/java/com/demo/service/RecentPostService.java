package com.demo.service;

import com.demo.entity.Bookmark;

import java.util.Set;

public interface RecentPostService {
    Set<Bookmark> getRecentPosts();
}
