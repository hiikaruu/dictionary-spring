package com.example.dictionaryspring.repositories;

import com.example.dictionaryspring.models.Dictionary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DictionaryRepository extends JpaRepository<Dictionary,Long> {
    void deleteDictionaryById(Long dictionaryId);
}
