package com.julio.authservice.service.impl;

import com.julio.authservice.model.Chapter;
import com.julio.authservice.repository.ChapterRepository;
import com.julio.authservice.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ChapterServiceImpl implements ChapterService {

    @Autowired
    private ChapterRepository chapterRepository;

    @Override
    public Page<Chapter> findAll(Integer page, Integer size) {
        Pageable pagination = PageRequest.of(page, size);
        return chapterRepository.findAll(pagination);
    }

    @Override
    public Chapter create(Chapter chapter) {
        return chapterRepository.save(chapter);
    }

    @Override
    public void deleteById(Long id) {
        chapterRepository.deleteById(id);
    }
}
