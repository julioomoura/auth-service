package com.julio.authservice.service;

import static org.junit.jupiter.api.Assertions.*;

import com.julio.authservice.model.Chapter;
import com.julio.authservice.repository.ChapterRepository;
import com.julio.authservice.service.impl.ChapterServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;

@ContextConfiguration(classes = {ChapterServiceImpl.class})

@ExtendWith(SpringExtension.class)
class ChapterServiceTest {

    @Autowired
    private ChapterService chapterService;

    @MockBean
    private ChapterRepository chapterRepository;

    @Test
    void testServiceInjection() {
        assertNotNull(chapterService);
    }

    @Test
    void validateCreateChapter() {
        Chapter chapter = new Chapter("New Chapter");

        Chapter mockedChapter = new Chapter("New Chapter");
        mockedChapter.setId(1L);

        Mockito.when(chapterRepository.save(chapter)).thenReturn(mockedChapter);

        Chapter createdChapter = chapterService.create(chapter);

        assertEquals("New Chapter", createdChapter.getName());
    }

    @Test
    void validateFindAllChapters() {
        Chapter chapterOne = new Chapter("Java");
        Chapter chapterTwo = new Chapter("Ruby");
        List<Chapter> chaptersMocked = Arrays.asList(chapterOne, chapterTwo);

        Mockito.when(chapterRepository.findAll()).thenReturn(chaptersMocked);

        List<Chapter> chapters = chapterService.findAll();

        assertEquals(2, chapters.size());
    }

    @Test
    void validateDeleteChapterById() {
        Long id = 1L;
        Mockito.doNothing().when(chapterRepository).deleteById(id);

        chapterService.deleteById(id);
    }
}
