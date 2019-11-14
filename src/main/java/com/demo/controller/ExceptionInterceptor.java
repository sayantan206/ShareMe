package com.demo.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionInterceptor {

    @ExceptionHandler(value = Exception.class)
    public ModelAndView handleException(Exception e){
        ModelAndView mav = new ModelAndView("error");

        mav.addObject("message", "Oops, Page not found!!!");
        mav.addObject("errorCode", "404");

        return mav;
    }
}
