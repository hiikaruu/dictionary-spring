package com.example.dictionaryspring.dto;

import com.example.dictionaryspring.models.DictionaryType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateDictionaryDto {
    private String name;
    private DictionaryType dictionaryType;
}
