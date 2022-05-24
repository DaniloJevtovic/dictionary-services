package com.dictionary.dictionary;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DictionaryRepository extends JpaRepository<Dictionary, Integer> {

    List<Dictionary> findByUserId(Integer userId);
}
