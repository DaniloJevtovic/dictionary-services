package com.dictionary.grammar;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GrammarRepository extends JpaRepository<Grammar, Integer> {

    Page<Grammar> findByDicId(Integer dicId, Pageable pageable);

    Long removeByDicId(Integer dicID);
}
