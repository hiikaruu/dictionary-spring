package com.example.dictionaryspring.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashMap;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Dictionary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private DictionaryType dictionaryType;
    @OneToMany()
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private HashMap<String,Word> words;
}
