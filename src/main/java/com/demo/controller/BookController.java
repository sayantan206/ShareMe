package com.demo.controller;

import com.demo.constants.BookmarkType;
import com.demo.entity.*;
import com.demo.service.BookService;
import com.demo.service.UserBookService;
import com.demo.service.UserService;
import com.demo.validation.CustomAuthorEditor;
import com.demo.validation.CustomPublisherEditor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.beans.PropertyEditor;
import java.util.LinkedHashSet;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserBookService userBookService;

    @InitBinder
    public void preProcess(WebDataBinder binder) {
        PropertyEditor editor = new StringTrimmerEditor(true);
        binder.registerCustomEditor(String.class, editor);

        editor = new CustomPublisherEditor();
        binder.registerCustomEditor(Publisher.class, "publishers", editor);

        editor = new CustomAuthorEditor();
        binder.registerCustomEditor(Author.class, "authors", editor);
    }

    @GetMapping("/list")
    public ModelAndView listBookmark() {
        ModelAndView mav = new ModelAndView("list-all");
        mav.addObject("bookmarks", bookService.listBookmark());

        return mav;
    }

    @GetMapping("/form")
    public ModelAndView getForm() {
        ModelAndView mav = new ModelAndView("add-book");
        Book book = new Book();
        book.setBookmarkType(BookmarkType.Book);

        mav.addObject("book", book);
        return mav;
    }

    @PostMapping("/save")
    public String saveBookmark(@Valid @ModelAttribute("book") Book book, BindingResult bindingResult, HttpServletRequest request) {
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getAllErrors());
            return "add-book";
        }
        User currentUser = userService.getCurrentUser(request);
        book.getPublishers()
                .forEach(p -> p.setId(bookService.getPublisherByName(p.getName()).getId()));

        book.getAuthors()
                .forEach(a -> a.setId(bookService.getAuthorByName(a.getName()).getId()));

        LinkedHashSet<UserBook> userBookEntries = userBookService.getUserBookEntries(currentUser.getId(), book.getId());

        if (userBookEntries == null)
            book.setUserBook(new UserBook(currentUser, book, Boolean.FALSE));

        bookService.saveBookmark(book);
        System.out.println(book);

        return "redirect:/user_bookmark/list";
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
        return "redirect:/user_bookmark/list";
    }

    @GetMapping("/save-bookmark")
    public String saveUserBookmark(@RequestParam("bookmarkID") long ID, HttpServletRequest request) {
        UserBook userBook = new UserBook();
        userBook.setBook(bookService.getBookmarkByID(ID));
        userBook.setUser(userService.getCurrentUser(request));
        userBook.setSaved(Boolean.TRUE);

        userBookService.saveUserBookmark(userBook);

        return "redirect:/user_bookmark/saved/list";
    }
}
