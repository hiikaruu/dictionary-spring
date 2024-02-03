package com.example.dictionaryspring.repositories;

import com.example.dictionaryspring.models.Dictionary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DictionaryRepository extends JpaRepository<Dictionary,Long> {
}
