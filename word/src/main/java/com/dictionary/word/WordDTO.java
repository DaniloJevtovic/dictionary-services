package com.dictionary.word;

public record WordDTO(
        String word,
        String translate,
        String description,
        Boolean favorite,
        WordType type,
        Integer wgId,
        Integer dicId
) {
}
