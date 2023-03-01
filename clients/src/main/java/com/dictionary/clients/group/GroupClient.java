package com.dictionary.clients.group;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("group")
public interface GroupClient {

    @DeleteMapping(path = "api/groups/dic/{dicId}")
    public Long deleteAllGroupsForDic(@PathVariable("dicId") Integer dicId);
}
