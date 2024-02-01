package com.example.dictionaryspring.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Word {
    @Id
    private Long id;
    private String value;
    private String translation;
    private WordType valueWordType;
    private WordType translationWordType;

}
