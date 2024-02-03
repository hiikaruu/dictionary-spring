package com.example.dictionaryspring.repositories;

import com.example.dictionaryspring.models.Word;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WordRepository extends JpaRepository<Word,Long> {
}
