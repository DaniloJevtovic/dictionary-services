package com.dictionary.group;

public record GroupDTO(
        String name,
        String description,
        String color,
        GroupType type,
        Integer dicId
) {
}
