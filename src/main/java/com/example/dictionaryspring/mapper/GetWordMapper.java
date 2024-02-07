package com.example.dictionaryspring.mapper;

import com.example.dictionaryspring.dto.GetWordDto;
import com.example.dictionaryspring.dto.WordDto;
import com.example.dictionaryspring.models.Word;

public class GetWordMapper {
    public static GetWordDto mapToGetWordDto(Word word){
        return new GetWordDto(
                word.getValue(),
                word.getTranslation()
        );
    }
}
