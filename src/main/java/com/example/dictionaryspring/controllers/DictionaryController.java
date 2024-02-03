package com.example.dictionaryspring.controllers;

import com.example.dictionaryspring.dto.DictionaryDto;
import com.example.dictionaryspring.services.DictionaryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/dictionaries")
@AllArgsConstructor
public class DictionaryController {
    private DictionaryService dictionaryService;
    @PostMapping
    public ResponseEntity<DictionaryDto> createDictionary(@RequestBody DictionaryDto dictionaryDto){
        DictionaryDto savedDictionary = dictionaryService.createDictionary(dictionaryDto);
        return new  ResponseEntity<>(savedDictionary, HttpStatus.CREATED);

    }
}
