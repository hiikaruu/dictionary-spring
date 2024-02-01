package com.example.dictionaryspring.repositories;

import com.example.dictionaryspring.models.Dictionary;
import com.example.dictionaryspring.models.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class DictionaryRepository extends JpaRepository<Dictionary,Long> {
    HashMap<String, Word> findWordsByValue;

}
