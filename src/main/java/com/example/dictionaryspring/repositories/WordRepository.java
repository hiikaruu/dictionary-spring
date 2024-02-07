package com.example.dictionaryspring.repositories;

import com.example.dictionaryspring.models.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
public interface WordRepository extends JpaRepository<Word,Long> {
    List<Word> findByValueOrTranslation(String value, String translation);
    boolean existsByValue(String value);
    @Modifying
    @Transactional
    @Query("DELETE FROM Word w WHERE w.dictionaryId = :dictionaryId AND w.value = :value")
    void deleteWordByValue(@Param("dictionaryId") Long dictionaryId, @Param("value") String value);
}
