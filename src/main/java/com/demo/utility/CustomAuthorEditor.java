package com.demo.utility;

import com.demo.entity.Author;

import java.beans.PropertyEditorSupport;
import java.util.HashSet;
import java.util.Set;

public class CustomAuthorEditor extends PropertyEditorSupport {

    @Override
    public String getAsText() {
        return super.getAsText();
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        Set<Author> authorList = new HashSet<>();

        String[] authors = text.split(",");
        for (String authorName : authors)
            authorList.add(new Author(authorName.trim()));

        setValue(authorList);
    }
}
