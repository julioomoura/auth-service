package com.julio.authservice.controller;

import com.julio.authservice.dto.ChapterDTO;
import com.julio.authservice.model.Chapter;
import com.julio.authservice.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/chapters")
public class ChapterController {

    @Autowired
    private ChapterService chapterService;

    @GetMapping
    public ResponseEntity<List<ChapterDTO>> retrieveChapters() {
        List<ChapterDTO> chapters = ChapterDTO.convert(chapterService.findAll());
        return ResponseEntity.ok(chapters);
    }

}
