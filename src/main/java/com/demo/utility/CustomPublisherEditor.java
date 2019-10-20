package com.demo.utility;

import com.demo.entity.Publisher;

import java.beans.PropertyEditorSupport;
import java.util.ArrayList;
import java.util.List;

public class CustomPublisherEditor extends PropertyEditorSupport {
    private List<Publisher> publisherList;

    @Override
    public String getAsText() {
        return super.getAsText();
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        publisherList = new ArrayList<Publisher>();

        String[] publishers = text.split(",");
        for (String publisherName : publishers)
            publisherList.add(new Publisher(publisherName.trim()));

        setValue(publisherList);
    }
}
