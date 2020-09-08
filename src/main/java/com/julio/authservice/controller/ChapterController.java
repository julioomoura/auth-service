package com.julio.authservice.controller;

import com.julio.authservice.dto.ChapterDTO;
import com.julio.authservice.dto.ChapterDTOCreation;
import com.julio.authservice.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
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

    @PostMapping
    public ResponseEntity<ChapterDTO> createChapter(@RequestBody ChapterDTOCreation chapterCreation) {
        ChapterDTO chapter = new ChapterDTO(chapterService.create(chapterCreation.convertToModel()));
        return ResponseEntity.ok(chapter);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteChapter(@PathParam("id") Long id) {
        chapterService.deleteById(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
