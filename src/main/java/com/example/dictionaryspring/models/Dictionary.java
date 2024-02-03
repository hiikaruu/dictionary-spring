package com.example.dictionaryspring.models;

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
    @OneToMany()
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<Word> words;
}
