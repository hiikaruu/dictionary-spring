package com.example.dictionaryspring.controllers;

import com.example.dictionaryspring.dto.WordDto;
import com.example.dictionaryspring.models.DictionaryType;
import com.example.dictionaryspring.services.WordService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/dictionaries")
@AllArgsConstructor
public class WordController {
    private WordService wordService;
    @PostMapping("/{dictionary_word}/words")
    public ResponseEntity<WordDto> addWord(@RequestBody WordDto wordDto){
        WordDto savedWord = wordService.createWord(wordDto);
        return new ResponseEntity<>(savedWord, HttpStatus.CREATED);
    }
}
