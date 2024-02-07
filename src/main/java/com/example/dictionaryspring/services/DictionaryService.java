package com.example.dictionaryspring.services;

import com.example.dictionaryspring.dto.DictionaryDto;

public interface DictionaryService {
    DictionaryDto createDictionary(DictionaryDto dictionaryDto);
    void getDictionaryById(Long dictionaryId);
}
