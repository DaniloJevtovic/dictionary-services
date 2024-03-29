package com.dictionary.word;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WordRepository extends JpaRepository<Word, Integer> {

    Page<Word> findByDicId(Integer dicId, Pageable pageable);

    Page<Word> findByWgId(Integer wgId, Pageable pageable);

    // brisanje svih rjeci iz rjecnika
    Long removeByDicId(Integer dicId);

    // brisanje svih rjeci iz grupe
    Long removeByWgId(Integer wgId);

    // pretraga u rjecniku
    Page<Word> findByDicIdAndWordContainsOrDicIdAndTranslateContains(
            Integer dicId, String word, Integer dicId2, String translate, Pageable pageable);

    // pretraga u grupi
    Page<Word> findByWgIdAndWordContainsOrWgIdAndTranslateContains(
            Integer wgId, String word, Integer wgId1, String translate, Pageable pageable);
}
