package com.example.dictionaryspring.controllers;

import com.example.dictionaryspring.dto.CreateDictionaryDto;
import com.example.dictionaryspring.dto.CreateWordDto;
import com.example.dictionaryspring.dto.GetDictionaryDto;
import com.example.dictionaryspring.services.DictionaryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/dictionaries")
@AllArgsConstructor
public class DictionaryController {
    private DictionaryService dictionaryService;
    @GetMapping("/search_dict")

    private ResponseEntity<GetDictionaryDto> getDictionaryById(@RequestParam Long dictionaryId){
        return ResponseEntity.ok(dictionaryService.getDictionaryById(dictionaryId));
    }
    @PostMapping("/dict")
    public ResponseEntity<?> createDictionary(@RequestBody CreateDictionaryDto createDictionaryDto){
        return  ResponseEntity
                .status(HttpStatus.CREATED)
                .body(dictionaryService.createDictionary(createDictionaryDto));
    }
    @DeleteMapping("/{dictionaryId}")
    public ResponseEntity<?> deleteDictionaryById(@PathVariable @RequestParam Long dictionaryId){
        dictionaryService.deleteDictionaryById(dictionaryId);
        return ResponseEntity.noContent()
                .build();
    }
}
