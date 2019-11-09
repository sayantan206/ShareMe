package com.demo.controller;

import com.demo.entity.Author;
import com.demo.entity.Book;
import com.demo.entity.Publisher;
import com.demo.service.BookService;
import com.demo.utility.CustomAuthorEditor;
import com.demo.utility.CustomPublisherEditor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.beans.PropertyEditor;

@Controller
@RequestMapping("/book")
public class BookController {    //todo: delete dummy controller mappings
    @Autowired
    private BookService bookService;

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

    @GetMapping("/list2")
    public ModelAndView listBookmark2() {
        ModelAndView mav = new ModelAndView("list-bookmarks");
        mav.addObject("books", bookService.listBookmark());

        return mav;
    }

    @GetMapping("/form")
    public ModelAndView getForm() {
        ModelAndView mav = new ModelAndView("add-book");
        mav.addObject("book", new Book());
        return mav;
    }

    @GetMapping("/form2")
    public ModelAndView getForm2() {
        ModelAndView mav = new ModelAndView("form");
        mav.addObject("book", new Book());
        return mav;
    }

    @PostMapping("/save")
    public String saveBookmark(@Valid @ModelAttribute("book") Book book, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "add-book";
        book.getPublishers()
                .forEach(p -> p.setId(bookService.getPublisherByName(p.getName()).getId()));

        book.getAuthors()
                .forEach(a -> a.setId(bookService.getAuthorByName(a.getName()).getId()));
        bookService.saveBookmark(book);
        return "redirect:/book/list";
    }

    @GetMapping("/update2")
    public ModelAndView showUpdateForm2(@RequestParam("bookmarkId") int Id) {
        ModelAndView mav = new ModelAndView("form");
        Book book = bookService.getBookmarkByID(Id);
        mav.addObject("book", book);

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
    }
}
