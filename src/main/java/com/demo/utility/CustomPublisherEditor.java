package com.demo.utility;

import com.demo.entity.Publisher;

import java.beans.PropertyEditorSupport;
import java.util.HashSet;
import java.util.Set;

public class CustomPublisherEditor extends PropertyEditorSupport {
    private Set<Publisher> publisherList;

    @Override
    public String getAsText() {
        return super.getAsText();
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        publisherList = new HashSet<>();

        String[] publishers = text.split(",");
        for (String publisherName : publishers)
            publisherList.add(new Publisher(publisherName.trim()));

        setValue(publisherList);
    }
}