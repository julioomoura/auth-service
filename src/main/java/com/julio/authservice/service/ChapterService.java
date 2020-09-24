package com.julio.authservice.service;

import com.julio.authservice.model.Chapter;
import org.springframework.data.domain.Page;

public interface ChapterService {
    Page<Chapter> findAll(Integer page, Integer size);
    Chapter create(Chapter chapter);
    void deleteById(Long id);
}
