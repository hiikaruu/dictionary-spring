package com.example.dictionaryspring.services;

import com.example.dictionaryspring.dto.GetWordDto;
import com.example.dictionaryspring.dto.CreateWordDto;
import com.example.dictionaryspring.dto.UpdateWordDto;

import java.util.List;
import java.util.Map;

public interface WordService {
    Map.Entry<String, Long> createWord(Long dictionaryId, CreateWordDto createWordDto);
    CreateWordDto getWordType(CreateWordDto createWordDto);
    List<GetWordDto> findWordByWord(String word);
    void deleteWordByValue(Long dictionaryId, String value);
    GetWordDto updateWord(Long dictionaryId, Long wordId, UpdateWordDto updateWordDto);

}
