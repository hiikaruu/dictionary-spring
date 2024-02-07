package com.example.dictionaryspring.services.impl;

import com.example.dictionaryspring.dto.GetWordDto;
import com.example.dictionaryspring.dto.CreateWordDto;
import com.example.dictionaryspring.dto.UpdateWordDto;
import com.example.dictionaryspring.exceptions.WordNotFoundException;
import com.example.dictionaryspring.exceptions.WordTypeException;
import com.example.dictionaryspring.models.Word;
import com.example.dictionaryspring.models.WordType;
import com.example.dictionaryspring.repositories.WordRepository;
import com.example.dictionaryspring.services.WordService;
import com.example.dictionaryspring.validators.NotFoundedValidator;
import com.example.dictionaryspring.validators.WordAlreadyExistsValidator;
import com.example.dictionaryspring.validators.WordDictionaryTypeValidator;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


@Service
@AllArgsConstructor
public class WordServiceImpl implements WordService {
    private NotFoundedValidator notFoundedValidator;
    private WordRepository wordRepository;
    private final ModelMapper mapper;
    private WordAlreadyExistsValidator wordAlreadyExistsValidator;
    private WordDictionaryTypeValidator wordDictionaryTypeValidator;

    @Override
    public  Map.Entry<String, Long> createWord(Long dictionaryId, CreateWordDto createWordDto) {
        createWordDto = getWordType(createWordDto);
        wordDictionaryTypeValidator.wordDictionaryTypeValidation(dictionaryId,createWordDto);
        wordAlreadyExistsValidator.wordExistsValidation(createWordDto);
        return Map.entry(
                "id",
                wordRepository.save(
                        new Word(
                                dictionaryId,
                                createWordDto.getValue(),
                                createWordDto.getTranslation(),
                                createWordDto.getValueWordType(),
                                createWordDto.getTranslationWordType()
                        )
                ).getDictionaryId()
        );
    }

    @Override
    public CreateWordDto getWordType(CreateWordDto createWordDto) {
        if (createWordDto.getValue().matches("[0-9]{5}") && createWordDto.getTranslation().matches("[a-zA-Z]{4}")) {
            createWordDto.setValueWordType(WordType.NUMBERS);
            createWordDto.setTranslationWordType(WordType.LETTERS);
        } else if (createWordDto.getValue().matches("[a-zA-Z]{4}") &&  createWordDto.getTranslation().matches("[0-9]{5}")) {
            createWordDto.setValueWordType(WordType.LETTERS);
            createWordDto.setTranslationWordType(WordType.NUMBERS);
        }
        else {
            throw new WordTypeException(createWordDto.toString());
        }
        return createWordDto;
    }

    @Override
    public List<GetWordDto> findWordByWord(String word) {
       List<GetWordDto> words = wordRepository.findByValueOrTranslation(word, word)
               .stream()
               .map(w -> mapper.map(w, GetWordDto.class))
               .toList();
       if (words.isEmpty()){
           throw new WordNotFoundException(word);
       }
       return words;
   }
    @Transactional
    @Override
    public void deleteWordByValue(Long dictionaryId, String value) {
        notFoundedValidator.dictionaryExists(dictionaryId);
        notFoundedValidator.valueExists(value);
        wordRepository.deleteWordByValue(dictionaryId,value);
    }

    @Override
    public GetWordDto updateWord(Long dictionaryId, Long wordId, UpdateWordDto updateWordDto) {
        notFoundedValidator.dictionaryExists(dictionaryId);
        Word word = wordRepository.findById(wordId)
                .orElseThrow(() -> new WordNotFoundException(wordId.toString()));
        word.setValue(updateWordDto.getValue());
        word.setTranslation(updateWordDto.getTranslation());
        return mapper.map(word, GetWordDto.class);
    }
}
