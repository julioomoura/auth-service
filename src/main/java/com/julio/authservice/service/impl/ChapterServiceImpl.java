package com.julio.authservice.service.impl;

import com.julio.authservice.model.Chapter;
import com.julio.authservice.repository.ChapterRepository;
import com.julio.authservice.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChapterServiceImpl implements ChapterService {

    @Autowired
    private ChapterRepository chapterRepository;

    @Override
    public List<Chapter> findAll() {
        return chapterRepository.findAll();
    }

    @Override
    public Chapter create(Chapter chapter) {
        return chapterRepository.save(chapter);
    }
}
