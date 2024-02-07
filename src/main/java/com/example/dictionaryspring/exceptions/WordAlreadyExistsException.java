package com.example.dictionaryspring.exceptions;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class WordAlreadyExistsException extends RuntimeException{
    public WordAlreadyExistsException(String value){
        super(String.format("Слово с значением '%s' уже существует", value));

    }
}
