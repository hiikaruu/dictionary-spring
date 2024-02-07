package com.example.dictionaryspring.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class WordDictionaryTypeException extends  RuntimeException{
    public WordDictionaryTypeException(String value, String translation) {
        super(String.format("Тип введенного слова не подходит для словаря",value, translation ));
    }
}
