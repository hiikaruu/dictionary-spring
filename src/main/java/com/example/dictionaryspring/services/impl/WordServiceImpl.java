package com.example.dictionaryspring.services.impl;

import com.example.dictionaryspring.dto.GetWordDto;
import com.example.dictionaryspring.dto.WordDto;
import com.example.dictionaryspring.exceptions.WordNotFoundException;
import com.example.dictionaryspring.exceptions.WordTypeException;
import com.example.dictionaryspring.mapper.GetWordMapper;
import com.example.dictionaryspring.mapper.WordMapper;
import com.example.dictionaryspring.models.Word;
import com.example.dictionaryspring.models.WordType;
import com.example.dictionaryspring.repositories.WordRepository;
import com.example.dictionaryspring.services.DictionaryService;
import com.example.dictionaryspring.services.WordService;
import com.example.dictionaryspring.validators.WordLengthValidator;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class WordServiceImpl implements WordService {
    private WordRepository wordRepository;
    private DictionaryService dictionaryService;
    private WordLengthValidator wordLengthValidator;
    @Override
    @Transactional
    public WordDto createWord( WordDto wordDto) {
        Word word = WordMapper.mapToWord(wordDto);
        wordLengthValidator.wordLengthValidation(wordDto);
        dictionaryService.getDictionaryById(word.getDictionaryId());
        Word savedWord = wordRepository.save(word);
        return WordMapper.mapToWordDto(savedWord);
    }

    @Override
    public void getWordType(WordDto wordDto) {
        if (wordDto.getValue().matches("[0-9]+") && wordDto.getTranslation().matches(("[a-zA-Z]+"))) {
            wordDto.setValueWordType(WordType.NUMBERS);
            wordDto.setTranslationWordType(WordType.LETTERS);
        } else if (wordDto.getValue().matches("[a-zA-Z]+") &&  wordDto.getTranslation().matches("[0-9]+")) {
            wordDto.setValueWordType(WordType.LETTERS);
            wordDto.setTranslationWordType(WordType.NUMBERS);
        }
        else {
            throw new WordTypeException(wordDto.toString());
        }
    }

   @Override
    public List<GetWordDto> findWordByWord(String word) {

       List<GetWordDto> words = wordRepository.findByValueOrTranslation(word, word)
               .stream()
               .map(GetWordMapper::mapToGetWordDto)
               .toList();
       if (words.isEmpty()){
           throw new WordNotFoundException(word);
       }
       return words;
   }
}
