package com.example.dictionaryspring.dto;

import com.example.dictionaryspring.models.WordType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateWordDto {
    private String value;
    private String translation;
    private WordType valueWordType;
    private WordType translationWordType;
}
