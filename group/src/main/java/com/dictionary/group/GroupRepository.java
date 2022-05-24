package com.dictionary.group;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroupRepository extends JpaRepository<Group, Integer> {

    List<Group> findByDicIdAndType(Integer dicId, String type);

    Long removeByDicId(Integer dicId);
}
