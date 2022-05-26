package com.dictionary.clients.group;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient("group")
public interface GroupClient {

    @PutMapping(path = "api/groups/{id}/decrease")
    public void decreaseNumOfItems(@PathVariable("id") Integer id);

    @PutMapping(path = "api/groups/{id}/increase")
    public void increaseNumOfItems(@PathVariable("id") Integer id);

    @DeleteMapping(path = "api/groups/dic/{dicId}")
    public Long deleteAllGroupsForDic(@PathVariable("dicId") Integer dicId);
}
