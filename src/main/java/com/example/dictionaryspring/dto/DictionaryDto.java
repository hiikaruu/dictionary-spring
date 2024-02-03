package com.example.dictionaryspring.dto;

import com.example.dictionaryspring.models.DictionaryType;
import com.example.dictionaryspring.models.Word;
import jakarta.persistence.OneToMany;
import lombok.*;


import java.util.HashMap;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DictionaryDto {
    private Long id;
    private String name;
    private DictionaryType dictionaryType;
    private List<Word> words;
}
