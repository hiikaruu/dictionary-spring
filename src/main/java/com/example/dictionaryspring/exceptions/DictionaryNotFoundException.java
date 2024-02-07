package com.example.dictionaryspring.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class DictionaryNotFoundException extends RuntimeException{
    public DictionaryNotFoundException(String dictionary) {
        super(String.format("Cловоря '%s' не существует, пожалуйста выберите другой словарь для добавления",dictionary ));
    }
}
