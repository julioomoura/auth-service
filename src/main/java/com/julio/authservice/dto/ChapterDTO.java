package com.julio.authservice.dto;

import com.julio.authservice.model.Chapter;

import java.util.List;
import java.util.stream.Collectors;

public class ChapterDTO {
    private Long id;
    private String name;

    public ChapterDTO(Chapter chapter) {
        this.id = chapter.getId();
        this.name = chapter.getName();
    }

    public static List<ChapterDTO> convert(List<Chapter> chapters) {
        return chapters.stream().map(ChapterDTO::new).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
