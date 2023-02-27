package com.dictionary.sentence;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SentenceRepository extends JpaRepository<Sentence, Integer> {

    Page<Sentence> findByDicId(Integer dicId, Pageable pageable);

    Page<Sentence> findBySgId(Integer sgId, Pageable pageable);

    Page<Sentence> findByDicIdAndSentenceContainsOrDicIdAndTranslateContains(
            Integer dicId, String sentence, Integer dicId1, String translate, Pageable pageable);

    Page<Sentence> findBySgIdAndSentenceContainsOrSgIdAndTranslateContains(
            Integer sgId, String sentence, Integer sgId1, String translate, Pageable pageable);

    Long removeByDicId(Integer dicId);

    Long removeBySgId(Integer sgId);
}
