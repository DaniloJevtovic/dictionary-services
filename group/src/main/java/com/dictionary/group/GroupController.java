package com.dictionary.group;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/groups")
@AllArgsConstructor
public class GroupController {

    private final GroupService groupService;

    @GetMapping
    public List<Group> getAllGroups() {
        return groupService.getAllGroups();
    }

    @GetMapping("/{id}")
    public Group getGroupById(@PathVariable Integer id) {
        return groupService.getGroupById(id);
    }

    @GetMapping("/dic/{dicId}/group/{type}")
    public List<Group> getGroupsForDicByType(@PathVariable Integer dicId, @PathVariable String type) {
        return groupService.getGroupsForDicByType(dicId, type);
    }

    @PostMapping
    public Group saveGroup(@RequestBody GroupDTO groupDTO) {
        return groupService.saveGroup(groupDTO);
    }

    @PutMapping("/{id}")
    public Group updateGroup(@PathVariable Integer id, @RequestBody GroupDTO groupDTO) {
        return groupService.updateGroup(id, groupDTO);
    }

    @PutMapping("/{id}/increase")
    public void increaseNumOfItems(@PathVariable Integer id) {
        groupService.increaseNumOfItems(id);
    }

    @PutMapping("/{id}/decrease")
    public void decreaseNumOfItems(@PathVariable Integer id) {
        groupService.decreaseNumOfItems(id);
    }

    @DeleteMapping("/{id}")
    public void deleteGroup(@PathVariable Integer id) {
        groupService.deleteGroup(id);
    }

    @DeleteMapping("/dic/{dicId}")
    public Long deleteAllGroupsForDic(@PathVariable Integer dicId) {
        return groupService.deleteAllGroupsForDic(dicId);
    }
}
