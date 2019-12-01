package com.demo.validation;

import com.demo.entity.Actor;

import java.beans.PropertyEditorSupport;
import java.util.HashSet;
import java.util.Set;

public class CustomActorEditor extends PropertyEditorSupport {

    @Override
    public String getAsText() {
        return super.getAsText();
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        Set<Actor> actorList = new HashSet<>();

        String[] actors = text.split(",");
        for (String actorName : actors)
            actorList.add(new Actor(actorName.trim()));

        setValue(actorList);
    }
}
