package com.demo.validation;

import com.demo.entity.Director;

import java.beans.PropertyEditorSupport;
import java.util.HashSet;
import java.util.Set;

public class CustomDirectorEditor extends PropertyEditorSupport {

    @Override
    public String getAsText() {
        return super.getAsText();
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        Set<Director> directorSet = new HashSet<>();

        String[] directors = text.split(",");
        for (String directorName : directors)
            directorSet.add(new Director(directorName.trim()));

        setValue(directorSet);
    }
}
