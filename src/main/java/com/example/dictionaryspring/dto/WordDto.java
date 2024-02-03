package com.example.dictionaryspring.dto;

import com.example.dictionaryspring.models.DictionaryType;
import com.example.dictionaryspring.models.WordType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WordDto {
    private Long id;
    private String value;
    private String translation;
    private WordType valueWordType;
    private WordType translationWordType;
    private DictionaryType dictionaryWord;
}
