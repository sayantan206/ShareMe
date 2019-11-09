package com.demo.controller;

import com.demo.entity.Actor;
import com.demo.entity.Director;
import com.demo.entity.Movie;
import com.demo.service.MovieService;
import com.demo.utility.CustomActorEditor;
import com.demo.utility.CustomDirectorEditor;
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
@RequestMapping("/movie")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @InitBinder
    public void preProcess(WebDataBinder binder) {
        PropertyEditor  editor = new StringTrimmerEditor(true);
        binder.registerCustomEditor(String.class, editor);

        editor = new CustomDirectorEditor();
        binder.registerCustomEditor(Director.class, "directors", editor);

        editor = new CustomActorEditor();
        binder.registerCustomEditor(Actor.class, "actors", editor);
    }

    @GetMapping("/list")
    public ModelAndView listBookmark() {
        ModelAndView mav = new ModelAndView("list-all");
        mav.addObject("bookmarks", movieService.listBookmark());

        return mav;
    }

    //todo: delete dummy
    @GetMapping("/list2")
    public ModelAndView listBookmark2() {
        ModelAndView mav = new ModelAndView("list-movies");
        mav.addObject("movies", movieService.listBookmark());

        return mav;
    }

    @GetMapping("/form2")
    public ModelAndView getForm2() {
        ModelAndView mav = new ModelAndView("form-movie");
        mav.addObject("movie", new Movie());
        return mav;
    }

    @GetMapping("/form")
    public ModelAndView getForm() {
        ModelAndView mav = new ModelAndView("add-movie");
        mav.addObject("movie", new Movie());
        return mav;
    }

    @PostMapping("/save")
    public String saveBookmark(@Valid @ModelAttribute("movie") Movie movie, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "add-movie";

        movie.getDirectors()
                .forEach(d -> d.setId(movieService.getDirectorByName(d.getName()).getId()));
        movie.getActors()
                .forEach(a -> a.setId(movieService.getActorByName(a.getName()).getId()));

        movieService.saveBookmark(movie);
        return "redirect:/movie/list";
    }

    @GetMapping("/update")
    public ModelAndView showUpdateForm(@RequestParam("bookmarkId") int Id) {
        ModelAndView mav = new ModelAndView("form-movie");
        Movie movie = movieService.getBookmarkByID(Id);
        mav.addObject("movie", movie);

        return mav;
    }

    @GetMapping("/delete")
    public String deleteBookmark(@RequestParam("bookmarkId") int Id) {
        movieService.deleteBookmark(Id);
        return "redirect:/movie/list";
    }
}
