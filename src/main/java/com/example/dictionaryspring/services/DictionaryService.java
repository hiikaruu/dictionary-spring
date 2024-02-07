package com.example.dictionaryspring.services;

import com.example.dictionaryspring.dto.CreateDictionaryDto;
import com.example.dictionaryspring.dto.CreateWordDto;
import com.example.dictionaryspring.dto.GetDictionaryDto;
import com.example.dictionaryspring.models.DictionaryType;

public interface DictionaryService {
    GetDictionaryDto getDictionaryById(Long dictionaryId);
    Long createDictionary(CreateDictionaryDto createDictionaryDto);
    void deleteDictionaryById(Long dictionaryId);

}
