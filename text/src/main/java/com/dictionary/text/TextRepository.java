package com.dictionary.text;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TextRepository extends MongoRepository<Text, String> {

    Page<Text> findByDicId(Integer dicId, Pageable pageable);

    Page<Text> findByDicIdAndTitleContains(Integer dicId, String title, Pageable pageable);

    Long deleteByDicId(Integer dicId);
}
