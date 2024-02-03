package com.example.dictionaryspring.services.impl;

import com.example.dictionaryspring.dto.DictionaryDto;
import com.example.dictionaryspring.mapper.DictionaryMapper;
import com.example.dictionaryspring.models.Dictionary;
import com.example.dictionaryspring.repositories.DictionaryRepository;
import com.example.dictionaryspring.services.DictionaryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
@Service
@AllArgsConstructor
public class DictionaryServiceImpl implements DictionaryService {
    private DictionaryRepository dictionaryRepository;
    @Override
    public DictionaryDto createDictionary(DictionaryDto dictionaryDto) {
        Dictionary dictionary = DictionaryMapper.mapToDictionary(dictionaryDto);
        Dictionary savedDictionary = dictionaryRepository.save(dictionary);
        return DictionaryMapper.mapToDictionaryDto(savedDictionary);
    }
}
