package com.example.dictionaryspring.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN)
public class WordTypeException extends RuntimeException{
    public WordTypeException(String word) {
        super(String.format("Не верный формат слова '%s'", word));
    }
}
