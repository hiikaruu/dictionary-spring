package com.example.dictionaryspring.validators;

import com.example.dictionaryspring.dto.CreateWordDto;
import com.example.dictionaryspring.exceptions.WordAlreadyExistsException;
import com.example.dictionaryspring.repositories.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WordAlreadyExistsValidator {
    @Autowired
    private WordRepository wordRepository;
    public void wordExistsValidation(CreateWordDto createWordDto){
        String value = createWordDto.getValue();
        if (wordRepository.existsByValue(value)) {
            throw new WordAlreadyExistsException("Слово со значением " + value + " уже существует");
        }
    }
}
