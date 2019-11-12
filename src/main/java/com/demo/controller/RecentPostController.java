package com.demo.controller;

import com.demo.service.RecentPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/recent")
public class RecentPostController {

    @Autowired
    private RecentPostService recentPostService;

    @GetMapping("/list")
    public ModelAndView recentPosts() {
        ModelAndView mav = new ModelAndView("list-all");
        mav.addObject("bookmarks", recentPostService.getRecentPosts());

        return mav;
    }
}
