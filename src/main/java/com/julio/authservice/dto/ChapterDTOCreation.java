package com.julio.authservice.dto;

import com.julio.authservice.model.Chapter;

public class ChapterDTOCreation {

    private String name;

    public Chapter convertToModel() {
        return new Chapter(name);
    }

    public String getName() {
        return name;
    }
}
