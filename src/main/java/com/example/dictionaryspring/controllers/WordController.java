package com.example.dictionaryspring.controllers;

import com.example.dictionaryspring.dto.GetWordDto;
import com.example.dictionaryspring.dto.CreateWordDto;
import com.example.dictionaryspring.dto.UpdateWordDto;
import com.example.dictionaryspring.services.WordService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/dictionaries")
@AllArgsConstructor
public class WordController {
    private WordService wordService;
    @PostMapping("/{dictionaryId}/words")

    public ResponseEntity<?> createWord(@PathVariable Long dictionaryId, @RequestBody CreateWordDto createWordDto){
        return  ResponseEntity
                .status(HttpStatus.CREATED)
                .body(wordService.createWord(dictionaryId, createWordDto));
    }
    @GetMapping("/search_words")
    private ResponseEntity<List<GetWordDto>> getWordByWord(@RequestParam String word){
        return ResponseEntity.ok(wordService.findWordByWord(word));
    }
    @DeleteMapping("/{dictionaryId}/words")
    public ResponseEntity<?> deleteWordByValue(@PathVariable Long dictionaryId, @RequestParam String value){
        wordService.deleteWordByValue(dictionaryId,value);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/{dictionaryId}/words/{wordId}")
    public ResponseEntity<?> updateWord(@PathVariable Long dictionaryId, @PathVariable Long wordId,
                                        @RequestBody UpdateWordDto updateWordDto) {
        return ResponseEntity.ok(
                wordService.updateWord(
                        dictionaryId, wordId, updateWordDto));
    }
}
