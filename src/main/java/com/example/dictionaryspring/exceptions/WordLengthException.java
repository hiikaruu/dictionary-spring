package com.example.dictionaryspring.exceptions;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN)
@ApiResponse(responseCode = "403",description = "Word not valid")
public class WordLengthException extends RuntimeException{
    public  WordLengthException(String word) {
        super(String.format("Не верная длина  слова '%s', " +
                "длина для Букв должна быть - 4 символа, длина для Цифр - 5 символов", word));
    }
}
