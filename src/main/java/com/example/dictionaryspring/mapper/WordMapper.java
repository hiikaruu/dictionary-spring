package com.example.dictionaryspring.mapper;

import com.example.dictionaryspring.dto.WordDto;
import com.example.dictionaryspring.models.Word;

public class WordMapper {
    public static WordDto mapToWordDto(Word word){
        return new WordDto(
                word.getId(),
                word.getValue(),
                word.getTranslation(),
                word.getValueWordType(),
                word.getTranslationWordType()
        );
    }
    public static Word mapToWord(WordDto wordDto){
        return new Word(
                wordDto.getId(),
                wordDto.getValue(),
                wordDto.getTranslation(),
                wordDto.getValueWordType(),
                wordDto.getTranslationWordType()
        );
    }
}
