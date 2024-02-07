package com.example.dictionaryspring.controllers;

import com.example.dictionaryspring.dto.GetWordDto;
import com.example.dictionaryspring.dto.WordDto;
import com.example.dictionaryspring.models.Word;
import com.example.dictionaryspring.services.WordService;
import com.example.dictionaryspring.validators.WordLengthValidator;
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
    private WordLengthValidator wordLengthValidator;
    @PostMapping("/words")
    public ResponseEntity<WordDto> addWord(@RequestBody WordDto wordDto){
        wordLengthValidator.wordLengthValidation(wordDto);
        wordService.getWordType(wordDto);
        WordDto savedWord = wordService
                .createWord(wordDto);
        return new ResponseEntity<>(savedWord, HttpStatus.CREATED);
    }
    @GetMapping("/search_words")
    private ResponseEntity<List<GetWordDto>> getWordByWord(@RequestParam String word){
        return ResponseEntity.ok(wordService.findWordByWord(word));
    }
}
