package com.dictionary.clients.grammar;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("grammar")
public interface GrammarClient {

    @DeleteMapping(path = "api/grammars/dic/{dicId}")
    public Long deleteAllGrammarsForDic(@PathVariable("dicId") Integer dicId);
}
