package com.dictionary.group;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class GroupService {

    private final GroupRepository groupRepository;

    public List<Group> getAllGroups() {
        return groupRepository.findAll();
    }

    public Group getGroupById(Integer id) {
        return groupRepository.findById(id).orElse(null);
    }

    public List<Group> getGroupsForDicByType(Integer dicId, String type) {
        return groupRepository.findByDicIdAndType(dicId, type);
    }

    public Group saveGroup(GroupDTO groupDTO) {
        Group group = Group.builder()
                .name(groupDTO.name())
                .description(groupDTO.description())
                .color(groupDTO.color())
                .type(groupDTO.type())
                .numOfItems(0)
                .dicId(groupDTO.dicId())
                .build();

        return groupRepository.save(group);
    }

    public Group updateGroup(Integer id, GroupDTO groupDTO) {
        Group group = getGroupById(id);
        group.setName(groupDTO.name());
        group.setDescription(groupDTO.description());
        group.setColor(groupDTO.color());
        return groupRepository.save(group);
    }

    public void increaseNumOfItems(Integer id) {
        Group group = getGroupById(id);
        group.setNumOfItems(group.getNumOfItems() + 1);
        groupRepository.save(group);
    }

    public void decreaseNumOfItems(Integer id) {
        Group group = getGroupById(id);
        group.setNumOfItems(group.getNumOfItems() - 1);
        groupRepository.save(group);
    }

    public void deleteGroup(Integer id) {
        groupRepository.deleteById(id);
    }

    @Transactional
    public Long deleteAllGroupsForDic(Integer dicId) {
        return groupRepository.removeByDicId(dicId);
    }
}
