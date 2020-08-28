package com.julio.authservice.service;

import com.julio.authservice.model.Chapter;

import java.util.List;

public interface ChapterService {
    List<Chapter> findAll();
    Chapter create(Chapter chapter);
}
