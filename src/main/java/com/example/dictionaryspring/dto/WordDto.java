package com.example.dictionaryspring.dto;

import com.example.dictionaryspring.models.DictionaryType;
import com.example.dictionaryspring.models.WordType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WordDto {
    private Long id;
    private String value;
    private String translation;
    private WordType valueWordType;
    private WordType translationWordType;
    private Long dictionaryId;
}
