package com.example.dictionaryspring.validators;

import com.example.dictionaryspring.dto.CreateDictionaryDto;
import com.example.dictionaryspring.dto.CreateWordDto;
import com.example.dictionaryspring.dto.GetDictionaryDto;
import com.example.dictionaryspring.exceptions.WordDictionaryTypeException;
import com.example.dictionaryspring.models.DictionaryType;
import com.example.dictionaryspring.models.WordType;
import com.example.dictionaryspring.repositories.DictionaryRepository;
import com.example.dictionaryspring.services.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WordDictionaryTypeValidator {
    @Autowired
    private DictionaryService dictionaryService;
    private DictionaryType getDictionaryTypeById(Long dictionaryId){
        return dictionaryService.getDictionaryById(dictionaryId).getDictionaryType();
    }
    public void wordDictionaryTypeValidation(Long dictionaryId,CreateWordDto createWordDto){

        if(getDictionaryTypeById(dictionaryId) == DictionaryType.LETTERS &&createWordDto.getValueWordType() == WordType.LETTERS
                && createWordDto.getTranslationWordType() == WordType.NUMBERS){
            throw new WordDictionaryTypeException(createWordDto.getValue(),createWordDto.getTranslation());
        }else if(getDictionaryTypeById(dictionaryId) == DictionaryType.NUMBERS &&createWordDto.getValueWordType() == WordType.NUMBERS
                && createWordDto.getTranslationWordType() == WordType.LETTERS){
            throw new WordDictionaryTypeException(createWordDto.getValue(),createWordDto.getTranslation());
        }

    }

}
