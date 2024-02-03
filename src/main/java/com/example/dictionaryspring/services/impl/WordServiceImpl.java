package com.example.dictionaryspring.services.impl;

import com.example.dictionaryspring.dto.WordDto;
import com.example.dictionaryspring.mapper.WordMapper;
import com.example.dictionaryspring.models.DictionaryType;
import com.example.dictionaryspring.models.Word;
import com.example.dictionaryspring.repositories.WordRepository;
import com.example.dictionaryspring.services.WordService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class WordServiceImpl implements WordService {
    private WordRepository wordRepository;
    @Override
    @Transactional
    public WordDto createWord(WordDto wordDto) {
        Word word = WordMapper.mapToWord(wordDto);
        Word savedWord = wordRepository.save(word);
        return WordMapper.mapToWordDto(savedWord);
    }
}
