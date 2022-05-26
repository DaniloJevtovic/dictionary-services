package com.dictionary.clients.sentence;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("sentence")
public interface SentenceClient {

    @DeleteMapping(path = "api/sentences/dic/{dicId}")
    public Long deleteAllSentencesForDic(@PathVariable("dicId") Integer dicId);

    @DeleteMapping(path = "api/sentences/sg/{sgId}")
    public Long deleteAllSentencesForSg(@PathVariable("sgId") Integer sgId);
}
