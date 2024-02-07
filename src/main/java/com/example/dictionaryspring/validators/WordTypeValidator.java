package com.example.dictionaryspring.validators;

import com.example.dictionaryspring.dto.WordDto;
import com.example.dictionaryspring.exceptions.WordLengthException;
import com.example.dictionaryspring.models.Word;
import com.example.dictionaryspring.models.WordType;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class WordTypeValidator implements ConstraintValidator<WordValidation, WordDto> {

    @Override
    public void initialize(WordValidation constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(WordDto wordDto, ConstraintValidatorContext constraintValidatorContext) {
        if((wordDto.getValueWordType() == WordType.LETTERS
                && wordDto.getValue().length() !=4)
                && (wordDto.getTranslationWordType() == WordType.NUMBERS)
                && wordDto.getTranslation().length() !=5){
            throw new WordLengthException(wordDto.toString());
        } else if((wordDto.getValueWordType() == WordType.NUMBERS
                && wordDto.getValue().length() !=5)
                && (wordDto.getTranslationWordType() == WordType.LETTERS)
                && wordDto.getTranslation().length() !=4){
            throw new WordLengthException(wordDto.toString());
        }
        else {
            return true;
        }

    }
}
