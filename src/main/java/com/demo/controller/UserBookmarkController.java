package com.demo.controller;

import com.demo.service.UserPostService;
import com.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user_bookmark")
public class UserBookmarkController {
    @Autowired
    private UserPostService userPostService;

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public ModelAndView getUserPosts(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("user-bookmark");
        mav.addObject("bookmarks", userPostService.getUserPosts(userService.getCurrentUser(request)));

        return mav;
    }

    @GetMapping("/saved/list")
    public ModelAndView getUserSavedPosts(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("user-saved-bookmark");
        mav.addObject("bookmarks", userPostService.getUserSavedPosts(userService.getCurrentUser(request)));

        return mav;
    }

    /*@GetMapping("/archive")
    public ModelAndView getUserArchivedPosts() {
        ModelAndView mav = new ModelAndView("");
        mav.addObject("bookmarks", userPostService.getUserArchivedPosts());

        return mav;
    }

    @GetMapping("/favourite")
    public ModelAndView getUserFavouritePosts() {
        ModelAndView mav = new ModelAndView("");
        mav.addObject("bookmarks", userPostService.getUserFavouritePosts());

        return mav;
    }

    @GetMapping("/update")
    public ModelAndView showUpdateForm(@RequestParam("bookmarkId") int Id) {
        ModelAndView mav = new ModelAndView("add-book");
        Book book = bookService.getBookmarkByID(Id);
        mav.addObject("book", book);

        return mav;
    }

    @GetMapping("/delete")
    public String deleteBookmark(@RequestParam("bookmarkId") int Id) {
        bookService.deleteBookmark(Id);
        return "redirect:/book/list";
    }*/
}
