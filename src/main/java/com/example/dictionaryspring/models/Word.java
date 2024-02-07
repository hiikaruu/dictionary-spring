package com.example.dictionaryspring.models;

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
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "value"))
public class Word {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Column(unique = true)
    private String value;
    @NotNull
    private String translation;
    private WordType valueWordType;
    private WordType translationWordType;
    @Column(name = "dictionary_id")
    private Long dictionaryId;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "dictionary_id", nullable = false, updatable = false, insertable = false)
    private Dictionary dictionary;

    public Word(Long dictionaryId, String value, String translation, WordType valueWordType, WordType translationWordType) {
        this.dictionaryId = dictionaryId;
        this.value = value;
        this.translation = translation;
        this.valueWordType = valueWordType;
        this.translationWordType = translationWordType;

    }
}
