package com.example.dictionaryspring.dto;

import com.example.dictionaryspring.models.DictionaryType;
import lombok.*;


import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetDictionaryDto {
    private Long id;
    private String name;
    private DictionaryType dictionaryType;
    private List<GetWordDto> words;
}
