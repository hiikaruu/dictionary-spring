package com.example.dictionaryspring.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashMap;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Dictionary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "dictionary_type")
    private DictionaryType dictionaryType;
    @OneToMany(mappedBy = "dictionary", cascade = CascadeType.ALL, orphanRemoval = true)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<Word> words;

    public Dictionary(String name, DictionaryType dictionaryType) {
        this.name = name;
        this.dictionaryType = dictionaryType;
    }
}
