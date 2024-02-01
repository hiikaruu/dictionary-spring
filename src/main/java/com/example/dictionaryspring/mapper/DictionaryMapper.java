package com.example.dictionaryspring.mapper;

import com.example.dictionaryspring.dto.DictionaryDto;
import com.example.dictionaryspring.models.Dictionary;

public class DictionaryMapper {
    public static DictionaryDto mapToDictionaryDto(Dictionary dictionary){
        return new DictionaryDto(
                dictionary.getId(),
                dictionary.getName(),
                dictionary.getDictionaryType(),
                dictionary.getWords()
        );
    }
    public static Dictionary mapToDictionary(DictionaryDto dictionaryDto){
        return new Dictionary(
                dictionaryDto.getId(),
                dictionaryDto.getName(),
                dictionaryDto.getDictionaryType(),
                dictionaryDto.getWords()
        );
    }
}
