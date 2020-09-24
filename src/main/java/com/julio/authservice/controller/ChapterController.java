package com.julio.authservice.controller;

import com.julio.authservice.dto.ChapterDTO;
import com.julio.authservice.dto.ChapterDTOCreation;
import com.julio.authservice.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chapters")
public class ChapterController {

    @Autowired
    private ChapterService chapterService;

    @GetMapping
    public ResponseEntity<Page<ChapterDTO>> retrieveChapters(
        @RequestParam Integer page,
        @RequestParam Integer size
    ) {
        Page<ChapterDTO> chapters = ChapterDTO.convert(chapterService.findAll(page, size));
        return ResponseEntity.ok(chapters);
    }

    @PostMapping
    public ResponseEntity<ChapterDTO> createChapter(@RequestBody ChapterDTOCreation chapterCreation) {
        ChapterDTO chapter = new ChapterDTO(chapterService.create(chapterCreation.convertToModel()));
        return new ResponseEntity<ChapterDTO>(chapter, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteChapter(@PathVariable("id") Long id) {
        chapterService.deleteById(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
