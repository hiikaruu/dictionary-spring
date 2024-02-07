package com.example.dictionaryspring.validators;

import com.example.dictionaryspring.dto.WordDto;
import com.example.dictionaryspring.exceptions.WordLengthException;
import com.example.dictionaryspring.models.WordType;
import org.springframework.stereotype.Component;

@Component
public class WordLengthValidator {
    public void wordLengthValidation(WordDto wordDto){
        if ((wordDto.getValueWordType() == WordType.LETTERS
                && wordDto.getValue().length() != 4)
                && (wordDto.getTranslationWordType() == WordType.NUMBERS)
                && wordDto.getTranslation().length() != 5) {
            throw new WordLengthException(wordDto.toString());
        } else if ((wordDto.getValueWordType() == WordType.NUMBERS
                && wordDto.getValue().length() != 5)
                && (wordDto.getTranslationWordType() == WordType.LETTERS)
                && wordDto.getTranslation().length() != 4) {
            throw new WordLengthException(wordDto.toString());
        }
    }
}
