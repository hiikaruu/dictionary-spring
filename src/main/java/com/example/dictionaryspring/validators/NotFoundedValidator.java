package com.example.dictionaryspring.validators;

import com.example.dictionaryspring.exceptions.DictionaryNotFoundException;
import com.example.dictionaryspring.exceptions.WordNotFoundException;
import com.example.dictionaryspring.repositories.DictionaryRepository;
import com.example.dictionaryspring.repositories.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NotFoundedValidator {
    @Autowired
    private DictionaryRepository dictionaryRepository;
    @Autowired
    private WordRepository wordRepository;
    public void dictionaryExists(Long dictionaryId) {
        if (!dictionaryRepository.existsById(dictionaryId)) {
            throw new DictionaryNotFoundException(dictionaryId.toString());
        }
    }
    public void valueExists( String value) {
        if (!wordRepository.existsByValue( value)) {
            throw new WordNotFoundException(value);
        }
    }
}
