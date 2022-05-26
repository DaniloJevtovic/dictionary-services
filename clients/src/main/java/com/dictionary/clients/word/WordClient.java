package com.dictionary.clients.word;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("word")
public interface WordClient {

    @DeleteMapping(path = "api/words/dic/{dicId}")
    public Long deleteAllWordsForDic(@PathVariable("dicId") Integer dicId);

    @DeleteMapping(path = "api/words/wg/{wgId}")
    public Long deleteAllWordsForWg(@PathVariable("wgId") Integer wgId);
}
