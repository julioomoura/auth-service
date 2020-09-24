package com.julio.authservice.dto;

import com.julio.authservice.model.Chapter;
import org.springframework.data.domain.Page;

public class ChapterDTO {
    private Long id;
    private String name;

    public ChapterDTO(Chapter chapter) {
        this.id = chapter.getId();
        this.name = chapter.getName();
    }

    public static Page<ChapterDTO> convert(Page<Chapter> chapters) {
        return chapters.map(ChapterDTO::new);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
