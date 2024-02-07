package com.example.dictionaryspring.services.impl;

import com.example.dictionaryspring.dto.CreateDictionaryDto;
import com.example.dictionaryspring.dto.GetDictionaryDto;
import com.example.dictionaryspring.exceptions.DictionaryNotFoundException;
import com.example.dictionaryspring.models.Dictionary;
import com.example.dictionaryspring.repositories.DictionaryRepository;
import com.example.dictionaryspring.services.DictionaryService;
import com.example.dictionaryspring.validators.NotFoundedValidator;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class DictionaryServiceImpl implements DictionaryService {
    private DictionaryRepository dictionaryRepository;
    private final ModelMapper mapper;
    private NotFoundedValidator notFoundedValidator;

    @Override
    public GetDictionaryDto getDictionaryById(Long dictionaryId){
        return dictionaryRepository.findById(dictionaryId)
                .map(d -> mapper.map(d, GetDictionaryDto.class))
                .orElseThrow(() ->  new  DictionaryNotFoundException(dictionaryId.toString()));
    }

    @Override
    public Long createDictionary(CreateDictionaryDto createDictionaryDto) {
        return dictionaryRepository.save(
                new Dictionary(
                        createDictionaryDto.getName(),
                        createDictionaryDto.getDictionaryType())
        ).getId();
    }
    @Transactional
    @Override
    public void deleteDictionaryById(Long dictionaryId) {
        notFoundedValidator.dictionaryExists(dictionaryId);
        dictionaryRepository.deleteDictionaryById(dictionaryId);
    }
}
