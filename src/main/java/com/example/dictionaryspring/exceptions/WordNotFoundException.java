package com.example.dictionaryspring.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class WordNotFoundException extends  RuntimeException{
    public WordNotFoundException(String value) {
        super(String.format("'%s' - не найдено", value));
    }
}
