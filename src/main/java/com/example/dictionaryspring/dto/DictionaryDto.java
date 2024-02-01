package com.example.dictionaryspring.dto;

import com.example.dictionaryspring.models.DictionaryType;
import com.example.dictionaryspring.models.Word;
import jakarta.persistence.OneToMany;
import lombok.*;


import java.util.HashMap;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DictionaryDto {
    private Long id;
    private String name;
    private DictionaryType dictionaryType;
    private HashMap<String, Word> words;
}
