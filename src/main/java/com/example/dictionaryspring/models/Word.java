package com.example.dictionaryspring.models;

import com.example.dictionaryspring.validators.WordValidation;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Word {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String value;
    @NotNull
    private String translation;
    private WordType valueWordType;
    private WordType translationWordType;
    @Column(name = "dictionary_id")
    private Long dictionaryId;
}
