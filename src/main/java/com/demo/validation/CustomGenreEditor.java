package com.demo.validation;

import com.demo.constants.BookGenre;

import java.beans.PropertyEditorSupport;

public class CustomGenreEditor extends PropertyEditorSupport {
    @Override
    public String getAsText() {
        return super.getAsText();
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        setValue(BookGenre.valueOf(text).getGenre());
    }
}
