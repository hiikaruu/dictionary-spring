package com.example.dictionaryspring.services;

import com.example.dictionaryspring.dto.GetWordDto;
import com.example.dictionaryspring.dto.WordDto;
import com.example.dictionaryspring.models.Word;

import java.util.List;

public interface WordService {
    WordDto createWord(WordDto wordDto);
    void getWordType(WordDto wordDto);
    List<GetWordDto> findWordByWord(String word);

}
