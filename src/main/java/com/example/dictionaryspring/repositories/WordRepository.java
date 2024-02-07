package com.example.dictionaryspring.repositories;

import com.example.dictionaryspring.dto.WordDto;
import com.example.dictionaryspring.models.Word;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WordRepository extends JpaRepository<Word,Long> {
    List<Word> findByValueOrTranslation(String value, String translation);
}
